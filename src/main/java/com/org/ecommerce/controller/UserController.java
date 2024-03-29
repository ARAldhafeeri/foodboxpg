package com.org.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.org.ecommerce.modal.Admin;
import com.org.ecommerce.modal.Product;
import com.org.ecommerce.modal.Purchase;
import com.org.ecommerce.modal.PurchaseItem;
import com.org.ecommerce.modal.User;
import com.org.ecommerce.requests.ChangePasswordRequest;
import com.org.ecommerce.requests.ChargeRequest;
import com.org.ecommerce.requests.CreateAdminRequest;
import com.org.ecommerce.requests.ChargeRequest.Currency;
import com.org.ecommerce.service.CusineService;
import com.org.ecommerce.service.PaymentService;
import com.org.ecommerce.service.ProductService;
import com.org.ecommerce.service.PurchaseItemService;
import com.org.ecommerce.service.PurchaseService;
import com.org.ecommerce.service.UserServices;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductService productService;

    @Autowired
    private CusineService cusineService;

    @Autowired
    private PurchaseItemService purchaseItemService;

    @Autowired 
    private PurchaseService purchaseService;

    @Autowired
    private PaymentService paymentsService;

        // authentication

        @GetMapping("/login")
        public String login() {
            return "userLogin";
        }

        @GetMapping("/register")
        public String register() {
            return "userRegister";
        }

        @PostMapping("/login")
        public RedirectView userLogin(
            Model model, 
            @ModelAttribute("user") User user,
            RedirectAttributes redirectAttributes) {
            User authenticatedUser = userServices.authenticate(user.getEmail(), user.getPwd());
            System.out.println(user.getEmail());
            System.out.println(user.getPwd());
            if(authenticatedUser == null) {
                redirectAttributes.addFlashAttribute("user", authenticatedUser);
                return new RedirectView("/user/login");
            }
            model.addAttribute("error", "Invalid Credentials");
            return new RedirectView("/user/home");
        }

        @PostMapping("/register")
        public RedirectView register(
            Model model, 
            User user,
            RedirectAttributes redirectAttributes) {
            System.out.println(user.getFname());
            System.out.println(user.getLname());
            System.out.println(user.getEmail());
            System.out.println(user.getPwd());
            System.out.println(user.getAddress());
            System.out.println(user.getAge());

            User registeredUser = userServices.createUser(user);
            if(registeredUser != null) {
                redirectAttributes.addFlashAttribute("user", registeredUser);
                return new RedirectView("/user/login");
            }
            model.addAttribute("error", "Invalid Credentials");
            return new RedirectView("/user/login");
        }

        // home
        @GetMapping("/home")
        public String home(
            Model model
        ) {
            model.addAttribute("products", productService.getAllProducts());
            model.addAttribute("cusines", cusineService.getAllCusines());
            return "userHome";
        }

        // cart & checkout
        @PostMapping("/addToCart")
        public RedirectView addToCart(
            Model model, 
            @ModelAttribute("PurcahseItem") PurchaseItem purchaseItem,
            RedirectAttributes redirectAttributes) {

            purchaseItemService.createPurchaseItem(
                purchaseItem
            );
            return new RedirectView("/user/home");
        }

        @GetMapping("/checkout")
        public String checkout(
            Model model
        ) {
            List<PurchaseItem> purchaseItems = purchaseItemService.getAllItemsByPurchaserId(1);
            model.addAttribute("products", purchaseItems);
            BigDecimal total = new BigDecimal(0);
            for(PurchaseItem purchaseItem: purchaseItems) {
                total = total.add(purchaseItem.getPrice());
            }

            model.addAttribute("total", total);
            model.addAttribute("amount", 50 * 100); // in cents
            model.addAttribute("stripePublicKey", paymentsService.getPublicKey());
            model.addAttribute("currency", ChargeRequest.Currency.EUR);

            return "userCheckout";
        }

        @PostMapping("/checkout")
        public RedirectView checkout(
            Model model, 
            @ModelAttribute("PurcahseItem") PurchaseItem purchaseItem,
            @ModelAttribute("ChargeRequest") ChargeRequest chargeRequest,
            RedirectAttributes redirectAttributes) throws StripeException {
            
            List<PurchaseItem> purchaseItems = purchaseItemService.getAllItemsByPurchaserId(purchaseItem.getUserId());
            
            Purchase purchase = new Purchase();
            BigDecimal total = new BigDecimal(0);

            purchase.setUserId(1);
            purchase.setDate(new java.util.Date().toString());

            for(PurchaseItem item: purchaseItems) {
                total = total.add(item.getPrice());
            }
            purchase.setTotal(total);
        
            Purchase created = purchaseService.createPurchase(purchase);

            for(PurchaseItem item: purchaseItems) {
                item.setPurchaseId(created.getID());
                purchaseItemService.updateItem(item);
            }

            chargeRequest.setDescription("Example charge");
            chargeRequest.setCurrency(Currency.EUR);
            chargeRequest.setAmount(total.intValue());

            Charge charge = paymentsService.charge(chargeRequest);
            model.addAttribute("id", charge.getId());
            model.addAttribute("status", charge.getStatus());
            model.addAttribute("chargeId", charge.getId());
            model.addAttribute("balance_transaction", charge.getBalanceTransaction());
            
            return new RedirectView("/user/checkoutResult");
        }

        // checkout result
        @GetMapping("/checkoutResult")
        public String checkoutResult(
            Model model
        ) {

            return "checkoutRes";
        }



    
}
