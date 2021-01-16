/** Notes:
 * Authentication is handled by Form elements directly to the Server.
 * - Logging in
 * - Logging Out
 */

////////////////////
// FETCH CALLS
////////////////////


/**
    Customer Logging In!
*/

/** Registering as a new Customer
let data = {
    username: ?,
    firstName: ?,
    lastName: ?,
    password: ?
}

fetch('localhost:8080/CafeDelivery/api/customer', {
    method: 'POST',
    body: data
})
.then(response => {

})
.then(data => {

})
*/

/** Retrieving all orders by Customer ID
fetch('http://localhost:8080/CafeDelivery/api/landing')
.then(response => {

})
.then(data => {

})
*/

/** Retrieving order items by Order ID
fetch('http://localhost:8080/CafeDelivery/api/landing')
.then(response => {

})
.then(data => {

})
*/

/** Posting a new order

let data = {
    "orderId": ?,
    "customerOrder": ?,
    "item_name": items
}

let itemsArray = [];

function customerSelectionObjCreator(name, amount) {
    let tempObj = {
        "itemName": name,
        "itemPrice": amount
    };
    return tempObj
}

items.append(customerElectionObjCreator);

fetch('localhost:8080/CafeDelivery/api/order', {
    method: 'POST',
    body: data
})
.then(response => {

})
.then(data => {

})
*/


////////////////////
// DOM Manipulation
////////////////////