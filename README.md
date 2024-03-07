# E-Commerce Using Java Spring Boot

Welcome to the E-Commerce project built with Java Spring Boot. This project aims to revolutionize online shopping experiences by offering a diverse range of product categories. It includes distinct roles for administrators, customers, and global users, each with specific privileges and actions. The project prioritizes seamless usability, security, and scalability, utilizing modern web technologies such as HTML, CSS, Bootstrap, JavaScript, and backend components like Spring Boot and MySQL.

## Project Brief

This e-commerce project is designed to provide users with a comprehensive online shopping platform. It offers a wide variety of product categories and features roles for different types of users, ensuring a smooth and secure shopping experience.

### System Actors/Roles

This system has three actors:
* Admin
* Customer
* Global User

#### Admin
We all known that admin is the most powerful actor in every system. Similarly in this system admin is the most powerful actor. Admin is responsible for all of the action which are mention below:
* Add Category
* Delete Category
* Edit Category
* Add Product
* Modify Product
* Delete Product
* Accept Order
* Red Complaint
* View Customer
* Update Customer Status

#### Customer
The customer is a lead actor. Customer’s Action are mention below:
* Register
* Login
* Place Order
* View Product
* View Category
* View Filtered Data
* Submit Complaint
* Payment
* Cancel Order

### Global User
A person who can submit complaint without registering into the system.
## Tech Stack

**Client:** HTML, CSS, Bootstrap, JavaScript

**Server:** Java, Spring Boot (2.6.3)
* **Dependency:**
    * Spring Data JPA
    * Security
    * Thymeleaf
    * Validation
    * Spring Web
    * Dev Tool
    * MySQL Connector
    * MySQL Driver
    * Lombok
* Build Tool: **Maven**

## Admin / User Guide

[View the step by step guide in pdf](https://drive.google.com/file/d/1aly4NYULqFYW-6TrRpCS_ey5Q7YM6Tj-/view?usp=sharing)
## Installation

* **Editor:** IntelliJ IDEA / Eclipse / NetBeans
* **MySQL** - 8.0.32

## Clone and Run

* **Step 1:** Open Terminal And Run Below Command
```bash
  git clone https://github.com/rudradcruze/Jonas-General-Purpose-Shop-SpringBoot.git
```
* **Step 2: ** Open MySQL Command Promte and Run The Below Query
```sql
    INSERT INTO `jgps_rudra`.`roles` (`name`) VALUES ('ADMIN');
    INSERT INTO `jgps_rudra`.`roles` (`name`) VALUES ('CUSTOMER');
```
* **Step 3:**
Import the project in your IDE and run the both module (admin and customer).Then<br>
For Admin Module: `http://localhost:8087/`<br>
For Customer Module: `http://localhost:8020/` 

## Screenshots
![customer-view](https://github.com/shivamverma26/Ecommerce_SpringBoot/assets/94590743/15042e41-531f-4e72-916e-4623a05dab60)
![admin-view](https://github.com/shivamverma26/Ecommerce_SpringBoot/assets/94590743/0f2d2c1a-a1f6-4d0c-bbaf-560612a76e76)





## 🚀 About Me
With an insatiable appetite for innovation and a fervent dedication to mastering the art of technology, I journey through the digital landscape with boundless passion
## 🔗 Social Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shivamverma61/)
[![verma.shivam2605@gmail.com](https://img.shields.io/badge/gmail-4267B2?style=for-the-badge&logo=gmail&logoColor=white)](mailto:verma.shivam2605@gmail.com)

## License
[MIT License](/LICENSE)
