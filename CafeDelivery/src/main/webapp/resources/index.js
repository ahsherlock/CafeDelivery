/** Notes:
 * Authentication is handled by Form elements directly to the Server.
 * - Logging in
 * - Logging Out
 */

////////////////////
// FETCH CALLS
////////////////////

/** Registering as a new Customer
function registerCustomer() {
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

