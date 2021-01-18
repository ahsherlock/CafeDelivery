console.log(29);

window.onload = function () {
    getAllMenuItems();
}

function logout() {
    console.log("LOGOUT FUNCTION IS BEING CALLED");
    fetch("http://localhost:8080/CafeDelivery/api/logout", {

        })
        .then(response => {

        })
        .then(data => {
            window.location.replace("http://localhost:8080/CafeDelivery/api/landing");
        })
}

function getAllOrders() {
    console.log('Called getAllOrders()');
    fetch("http://localhost:8080/CafeDelivery/api/orderbycustomer", {
        method: "GET",
        headers : { 
            'Content-Type': 'application/json',
            'Accept': 'application/json'
           }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)

        let orderHistory = {};
        let orderArray = [];
        let layerOne = data[0]; 
        let orderId = 0; // Order ID
        let itemsObj = {}; // Contains food name : food price

        // console.log(data[0].length);
        // console.log(data[0][2].length);    

        // while(data[0][2]) {

        // }

        // for(let j = 0; j < data[0].value([2].length); j++) {
        //     // for(let i = 0; i < data.length; i++) {
    
        //     //     // for(let j = 0; j < data[0].length; i++) {
        //     //     //     console.log("These should be the food items");
        //     //     //     console.log(data[0][j].itemName);
        //     //     //     console.log(data[0][j].itemPrice);
        //     //     // }
    
        //     //     console.log(returnObj[0][0]) // Order #1 Food Objects
        //     //     console.log(returnObj[0][0][0]) // Order #1, Food Object 1
        //     //     console.log(returnObj[0][0][0].itemName) // Order #1, Food Object 1, name
        //     //     console.log(returnObj[0][0][0].itemPrice) // Order #1, Food Object 1, price
    
        //     //     console.log("This should be the Order Id:")
        //     //     console.log(data[2][i])

        //     //     orderArray.push
        //     //     orderHistory.orderId = orderArray;
        //     //     orderArray=[];
        //     // }
        //     orderId = data[2][j];
        //     console.log(orderId);

        // }
        
        for(let e in data[0][2]) {
            console.log(e);
        }
    })

}

function getAllMenuItems() {
    fetch("http://localhost:8080/CafeDelivery/api/menu")
        .then(response => response.json())
        .then(data => {
            console.log(data);
            for(let i = 0; i < data.length; i ++) {
                let tbody  = document.querySelector("#menu-table");
                let trow = document.createElement('tr');
                let td1 = document.createElement('td');
                let td2 = document.createElement('td');
                let td3 = document.createElement('button');

                td3.setAttribute("item-name", data[i].itemName);
                td3.setAttribute("item-price", data[i].itemPrice);
                td3.classList.add("btn");
                td3.classList.add("btn-primary");
                td3.innerText = "add";
                td3.id = "menu-btn";

                td1.innerText = data[i].itemName;
                td2.innerText = `${data[i]. itemPrice}`;
                trow.appendChild(td1);
                trow.appendChild(td2);
                trow.appendChild(td3);
                tbody.appendChild(trow);
            }
            getAllOrders();
        })
}

// Order Creation 
let itemName;
let itemPrice;

let newOrder = {};
let newOrderArray = [];

document.addEventListener("click", function(e) {
    if(e.target && e.target.id == 'menu-btn') {
        itemName = e.target.getAttribute('item-name');
        itemPrice = e.target.getAttribute('item-price');
        newOrder.itemName = itemName;
        newOrder.itemPrice = itemPrice;

        newOrderArray.push(newOrder);
        // console.log(newOrder);
        // console.log(newOrderArray);
        newOrder = {};
    }
})

// Order Creation The Remix
let newOrderObj = {};

newOrderObj.orderId = 0;
newOrderObj.customerOrder = null;
newOrderObj.menu = newOrderArray;

// Order Submit -- note to empty the orderobject at the promise
function submitOrder() {
    console.log(newOrderObj);
    document.querySelector("#order-submit").addEventListener("click", function() {
        fetch("http://localhost:8080/CafeDelivery/api/order", {
            method: 'POST',
            body: JSON.stringify(newOrderObj)
        })
        .then(response => response.json())
        .catch(err => console.log(err));

    })
}