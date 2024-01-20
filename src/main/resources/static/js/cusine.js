function filterCuisine(cuisine) {
    $(".card").hide();
    $(".card[cusineid=" + cuisine + "]").show();
}

function sortProducts() {
    var cards = $(".product-card");
    cards.sort(function(a, b) {
        return parseFloat($(a).find("p:contains('Price')").text().replace('Price: ', '')) -
               parseFloat($(b).find("p:contains('Price')").text().replace('Price: ', ''));
    });
    $(".card-container").html(cards);
}

function searchProducts() {
    var input, filter, cards, card, i, txtValue;
    input = document.getElementById('searchInput');
    filter = input.value.toUpperCase();
    cards = $(".product-card");
    
    for (i = 0; i < cards.length; i++) {
        card = cards[i];
        txtValue = card.textContent || card.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            cards[i].style.display = "";
        } else {
            cards[i].style.display = "none";
        }
    }
}