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
function registerCustomer(username, firstName, lastName, password) {
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
}
*/

/** Retrieving all orders by Customer ID
function ordersByCustomerId() {
    fetch('http://localhost:8080/CafeDelivery/api/landing')
    .then(response => {

    })
    .then(data => {

    })
}
*/

/** Retrieving order items by Order ID
function ordersByOrderId() {

    fetch('http://localhost:8080/CafeDelivery/api/landing')
    .then(response => {

    })
    .then(data => {

    )
}
*/

/** Posting a new order
function postNewOrder() {
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
}
*/


////////////////////
// DOM Manipulation
////////////////////

// Calls each "GET" Fetch function above to use for manipulation

// REGISTER FORM
/**
 * Registration requires username, firstname, lastname, and password fields.
 * Although the user will input data into input fields of a Form element, the request will be sent using the Fetch API.
 */
// let username = document.querySelector('').value;
// let firstName = document.querySelector('').value;
// let lastName = document.querySelector('').value;
// let password = document.querySelector('').value;
// registerCustomer(username, firstName, lastName, password);

// POST NEW ORDER:
/**
 * New Order requires an array of objects (created within the postNewOrder method) that represent a series of food items as well as their cost.
 */
// postNewOrder()

// GET Order by OrderId
/**
 * Makes a call to retrieve a full list of food items and their costs based on what "Order" the user clicks.
 */
// let orderResponse = ordersByOrderId();
// orderResponse parse()
// Display each food item and associated Cost
// Display Total amount and perhaps # of items

// GET all orders by Customer Id
/**
 * This method is automatically made when the user is authenticated. It will return a list of integers that represent each Order Id.
 */
// let allOrders = ordersByCustomerId();
// allOrders parse();
// display default text or images to accompany order Ids
