**Technical Write-up: Foodbox - Online Food Delivery Web Application**

**Project Overview:**
Foodbox is an online food delivery web application designed to facilitate the ordering of food items from a restaurant. As a Full Stack Java Developer, the objective is to create a dynamic and responsive application with features such as registration, login, payment gateway, searching, filtering, sorting, dynamic data, and responsiveness across different devices.

**Features:**
1. Registration
2. Login
3. Payment gateway
4. Searching
5. Filtering
6. Sorting
7. Dynamic data
8. Responsive design compatible with different devices

**Used Technologies:**
- Database Management: MySQL
- Backend Logic: Java programming, Spring boot
- Frontend Development: JSP, Bootstrap, HTML/CSS, and Javascript
- Automation and Testing Technologies: TestNG
- DevOps and Production Technologies: Git, GitHub, Jenkins, Docker, AWS

# use-cases 
**Admin Portal:**
- Add or remove, update,  fetch different cuisines
- Add, remove, update, fetch food item details (name, price, cuisine, description, offers)
- Enable or disable food items

**User Portal:**
- sing-up
- Sign-in to maintain activity records
- search sort filter cusine
- Search, sort, filter food items
- Add selected items to the cart and customize purchases
- Seamless payment process
- Order summary details page post-payment

# Entities :
- Admin :
  + id
  + username
  + hashedPassword
  + salt
  + email
- User:
  + id
  + fname
  + lname
  + address
  + age
  + dateAdded
  + emailid
  + pwd
- cusine
  + id
  + name
- product
  + name
  + price
  + dateAdded
  + cusineId
  + description
  + casineId
  + viewable
- purcahses
  + id
  + userId
  + date
  + total
-  purcahseitem
  + id
  + purcahseId
  + prodcutId
  + userId
  + rate
  + qty
  + price
- users
  + id
  + fname
  + lname
  + address
  + age
  + dateAdded
  + emailid
  + pwd
    

**Sprint Planning:**
- **Sprint 1 (Day 1):** Setup project structure, database design, and implement admin portal registration and login, curd  cusine, food.
- **Sprint 2 (Day 2):** Develop user portal functionalities , login, register, home  page, food, cusine filtering, sorting viewing.
- **Sprint 3 (Day 3):** Integrate payment gateaway ( stripe ), checkout process.
- **Sprint 4 (Day 4):** Add unit tests, configure ci/cd, deploy on aws E2C  instance.

Each sprint delivers a part of the application, ensuring steady progress towards the final product.


# backlog 
[x] **Sprint 1 (Day 1):** Setup project structure, database design, and implement admin portal registration and login, curd  cusine, food.
[x] **Sprint 2 (Day 2):** Develop user portal functionalities , login, register, home  page, food, cusine filtering, sorting viewing.
[] - **Sprint 3 (Day 3):** Integrate payment gateaway final step of checkout ( stripe ), checkout process.
[] - **Sprint 4 (Day 4):** Add unit tests, configure jenkis ci/cd, deploy on aws E2C  instance.