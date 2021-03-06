if(document.readyState == 'loading'){
    document.addEventListener('DOMContentLoaded' , ready)
}

else{
    ready()
}

function ready(){
    
    var removeFromCart = document.getElementsByClassName("btn-danger")
    for(var i = 0; i < removeFromCart.length; i++){
    var button = removeFromCart[i]
    button.addEventListener('click', removeItem)
    
    }
    
    
    var quantityNum = document.getElementsByClassName('quantity-num')
    for(var i = 0; i < quantityNum.length; i++){
    var num = quantityNum[i]
    num.addEventListener('change', updateQuantity)
        
    }
    
    
    var addButton = document.getElementsByClassName('add')
    for(var i = 0; i < addButton.length; i++){
        var add = addButton[i]
        add.addEventListener('click', addToCart)
    }
    
    document.getElementsByClassName('purchase')[0].addEventListener('click', purchaseClicked)
}

function purchaseClicked() {
    alert('Thank you for your purchase')
    var cartItems = document.getElementsByClassName('items')[0]
    while (cartItems.hasChildNodes()) {
        cartItems.removeChild(cartItems.firstChild)
    }
    updateCartTotal()
}
function removeItem(event){
        var buttonClicked = event.target
        buttonClicked.parentElement.parentElement.remove();
        updateCartTotal()
}
    
function updateQuantity(event){
    var num = event.target
    if(isNaN(num.value) || num.value <= 0){
        input.val = 1
    }
    
    updateQuantity()
}

function addToCart(event){
    var add = event.target
    var item = add.parentElement.parentElement
    var itemName = item.getElementsByClassName('item')[0].innerText
    var price = item.getElementsByClassName('price')[0].innerText
    var src = item.getElementsByClassName('pix')[0].src
    addItem(itemName, price, src)
    updateTotal()
}

function addItem(itemName, price, src){
    var row = document.createElement('div')
    row.classList.add('row')
    var cart = document.getElementsByClassName('items')[0]
    var cartItems = cart.getElementsByClassName('item2')
    for(var i = 0; i < cartItems.length; i++){
        if(cartItems[i].innerText == itemName){
            alert("This is item is already in the cart")
            return 
        }
    }
    var cartContent =`
        <div class="item2 column">
            <img class="cart-img" src="${src}" width="100" height="100">
            <span class="pid">${item}</span>
        </div>
        <span class="price2 column">${price}</span>
        <div class="quantity column">
            <input class="quantity-num" type="number" value="1">
            <button class="btn btn-danger" type="button">REMOVE</button>
        </div>`
    row.innerHTML = cartContent
    cart.append(row)
    row.getElementsByClassName('btn-danger')[0].addEventListener('click', removeItem)
    row.getElementsByClassName('quantity-num')[0].addEventListener('change', updateQuantity)
    
    
}

function updateTotal(){
    
    var finalCart = document.getElementsByClassName('items')[0]
    var rows = finalCart.getElementsByClassName('row')
    var settle = 0
    for(var i = 0; i < rows.length; i++){
        var row = rows[i]
        var price = row.getElementsByClassName('price2')[0]
        var quantity = row.getElementsByClassName('quantity-num')[0]   
        var totalPrice = parseFloat(price.innerText.replace('$', ''))
        var totalQuantity = quantity.value
        settle = settle + (totalPrice * totalQuantity)
    }  
    
    settle = Math.round(settle * 100) / 100
    document.getElementsByClassName('total')[0].innerText = '$' + settle
}