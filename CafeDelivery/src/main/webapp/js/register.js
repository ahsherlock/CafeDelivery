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
function registerNewCustomer() {
    let data = {
        username: document.getElementById("username").value,
        firstName: document.getElementById("firstname").value,
        lastName: document.getElementById("lastname").value,
        password: document.getElementById("password").value
    }

    fetch('localhost:8080/CafeDelivery/api/customer', {
            method: 'POST',
            body: data
        })
        .then(response => {
            console.log(response);
        })
        .then(data => {
            console.log(data);
        })
}