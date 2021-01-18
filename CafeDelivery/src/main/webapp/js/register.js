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
    console.log("Register Customer funtion is called...")
    let data = {
        customerId: 0,
        username: document.getElementById("username").value,
        firstName: document.getElementById("firstname").value,
        lastName: document.getElementById("lastname").value,
        password: document.getElementById("password").value
    }

    console.log(data);
    fetch('http://localhost:8080/CafeDelivery/api/customer', {
            method: 'POST',
            body: JSON.stringify(data)
        })
        .then(response => {
            console.log(response);
        })
        .then(data => {
            console.log(data);
            window.location.replace("http://localhost:8080/CafeDelivery/api/landing");
        })

}