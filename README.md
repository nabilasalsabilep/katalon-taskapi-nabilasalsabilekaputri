# Katalon API Automation

This repository contains the API automation testing project using **Katalon Studio** as part of the assigned exercise.

## 🔗 Public API
API used for testing:  
👉 [BookCart API – Swagger Documentation](https://bookcart.azurewebsites.net/swagger/index.html)

---

## ✅ Test Scenarios

The test cases were designed and executed in the following logical order:

| No | Folder       | Test Case Name       | Method   | Description                                |
|----|--------------|----------------------|----------|--------------------------------------------|
| 1  | Register     | Register_Valid       | `POST`   | Register a new user with valid data        |
| 2  | Login        | Login_Valid          | `POST`   | Log in with valid user credentials         |
| 3  | ListOfBooks  | GetListOfBooks       | `GET`    | Retrieve the list of available books       |
| 4  | Cart         | DeleteCart           | `DELETE` | Clear existing items from the user's cart  |
| 5  | Cart         | AddtoCart            | `POST`   | Add a selected book to the user's cart     |
| 6  | Cart         | GetListOfCarts       | `GET`    | Retrieve all items currently in the cart   |
| 7  | Cart         | UpdateCart           | `PUT`    | Update the quantity or content in the cart |

> These scenarios simulate a complete user flow from registration to managing a shopping cart.
> Each test case is structured under the `Test Cases/Scenarios` folder and included in a Test Suite.

---

## 📌 Notes

- When running the test cases, make sure to switch the execution profile from **default** to **staging**.

---
