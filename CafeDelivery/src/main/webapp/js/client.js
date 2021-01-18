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

function getAllMenuItems() {
    fetch("http://localhost:8080/CafeDelivery/api/menu", {

        })
        .then(response => {

        })
        .then(data => {
            console.log(data);
        })
}