# Smart Warehouse Inventory Tracker 📦

A simple yet powerful Java-based inventory management system using JDBC and MySQL. This project is designed to simulate real-world stock monitoring, reorder tracking, and inventory operations for warehouse-based businesses.

## 💡 Features

- ➕ **Add New Products**  
- 🔄 **Update Product Quantity and Reorder Level**  
- ❌ **Delete Products**  
- 📋 **View All Products**  
- ✅ **Show In-Stock Items**  
- 🚨 **Show Items Below Reorder Level (Out of Stock)**

## 📁 Project Structure

smart_warehouse/
├── database/
│ └── DBUtil.java
├── Product_check/
│ ├── Product.java
│ ├── ProductDAO.java
│ └── ProductStockCheck.java

## 🛠️ Tech Stack

- **Java**
- **JDBC**
- **MySQL**
- **IntelliJ IDEA**
- **Git & GitHub**

## 🧠 Concepts Practiced

- Core Java (OOP, Encapsulation, Abstraction)
- JDBC Database Connectivity
- DAO (Data Access Object) Design Pattern
- Exception Handling
- Collections (`ArrayList`, Streams)
- Simple Service-Oriented Structure

## 🔧 How to Run

1. Clone the repository:
   
   git clone https://github.com/SribalajiV007/Smart_Warehouse.git

**2.Create the database in MySQL:**

CREATE DATABASE smart_warehouse;
USE smart_warehouse;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    quantity INT,
    reorder_level INT
);

CREATE DATABASE smart_warehouse;
USE smart_warehouse;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    quantity INT,
    reorder_level INT
);

CREATE DATABASE smart_warehouse;
USE smart_warehouse;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    quantity INT,
    reorder_level INT
);

**3.Update your MySQL credentials in DBUtil.java.**
**4.Compile and run ProductStockCheck.java:**
javac ProductStockCheck.java
java ProductStockCheck


🚀 What's Next?
*Incoming Stock Feature
*Subtracting Sold Stock
*Search & Filter Products
*Reorder Report Generator
*Spring Boot + Web Integration (Future Upgrade)

📌 This project is built as part of my Java learning journey and to demonstrate backend fundamentals using JDBC.
⭐ Star the repo if you find it useful!

