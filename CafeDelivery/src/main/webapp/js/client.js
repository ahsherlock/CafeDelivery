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
        let orderId = 0; // Order ID
        let orderArray = []; // Contains food name : food price


        for(let i = 0; i < data[1].length; i++) {

            let tbody  = document.querySelector("#order-history-table");
            let trow = document.createElement('tr');
            // let td1 = document.createElement('td');
            // let td1 = document.createElement('td');
            
            // let td2 = document.createElement('td');
            // let td2 = document.createElement('td');


            let td3 = document.createElement('td');

            td3.innerText = data[1][i];

            // console.log("test 1:" +data[0][i].itemName);
            // console.log("test 2: " + data[0][i][0].itemName);

            let count = 0;
            let layer1 = data[0]
            layer1[0].forEach( e => {
                count++;
            })
            console.log(count);
            
            for(let j = 0; j < count; j ++) {

                // Object.keys(data[0][i][j]).forEach(cell => {
                //     console.log(data[0][i][j][cell]);
                // })

                let td1 = document.createElement('td');
                let td2 = document.createElement('td');

                td1.innerText = data[0][i][j].itemName;
                console.log(data[0][i][j].itemName);
                td2.innerText = `${data[0][i][j].itemPrice}`;
                console.log(data[0][i][j].itemPrice);

                trow.appendChild(td1);
                trow.appendChild(td2);
                trow.appendChild(td3);
            }
            tbody.appendChild(trow);
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