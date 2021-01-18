# CafeDelivery

## Description

A small Cafe application in which customers can order food over the internet. Customers can sign up for an account, log in, and purchase food from a menu. Customers will also have the ability to see all of their previous 

## Technologies

![Java](https://img.shields.io/badge/java%20-%23323330.svg?&style=for-the-badge&logo=java&logoColor=%23F7DF1E)

![Hibernate](https://img.shields.io/badge/hibernate%20-%23E34F26.svg?&style=for-the-badge&logo=hibernate&logoColor=white)

![Postgresql](https://img.shields.io/badge/postgresql%20-%231572B6.svg?&style=for-the-badge&logo=postgres&logoColor=white)

![HTML](https://img.shields.io/badge/html5%20-%23E34F26.svg?&style=for-the-badge&logo=html5&logoColor=white)

![CSS](https://img.shields.io/badge/css3%20-%231572B6.svg?&style=for-the-badge&logo=css3&logoColor=white)

![JavaScript](https://img.shields.io/badge/javascript%20-%23323330.svg?&style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

## Usage and Additional Notes
<details>
    <summary>API Routes</summary>
    <br><details>
        <summary>GET orders by OrderId</summary><br>
        <strong>Endpoint:</strong> localhost:8080/CafeDelivery/api/order
        <br><br>
        <strong>Explanation:</strong> This route will take in the ID of any order and return the food items and prices associated with those food items in a JSON response. The format of the returned data will be an array of objects.
    </details>
    <br><details>
        <summary>GET all orders by CustomerId</summary><br>
        <strong>Endpoint:</strong> localhost:8080/CafeDelivery/api/orderbycustomer
        <br><br>
        <strong>Explanation:</strong><nl> This route will take in the ID of the currently authenticated user and return ALL orders associated with the user's Id in a JSON response. The format of the returned data will be an array of integers, each representing an Order Id.
    </details>
</details>

<br>

<details>
    <summary>Service Layer</summary>
    <br>
    <strong>All Service layer methods can be found at /src/main/java/service/Service.java</strong>
    <br><br>
    <strong>Method:</strong> localhost:8080/CafeDelivery/api/order
    <br>
    <strong>Explanation:</strong> This route will take in the ID of any order and return the food items and prices associated with those food items in a JSON response. The format of the returned data will be an array of objects.
    <br>
    <strong>Input:</strong>
    <br>
    <strong>Output:</strong>
    <br><br>
</details>

<br>

<details>
    <summary>DAO Layer</summary>
</details>

<br>

## Contributors

Alec Sherlock
George Yoo
Mohammad Al Lami
William Freeman
William He

## License

[MIT](https://choosealicense.com/licenses/mit/)
