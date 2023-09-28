# OMSA
ORDER MANAGEMENT SYSTEM API
Kuehne+Nagel back-end testwork
ORDER MANAGEMENT SYSTEM API:

##MODEL DESCRIPTION:
	- An Order is made of N OrderLine and is related to a Customer, and has a date of submission
	- Each OrderLine is made of a Product and a quantity
	- A Product has a name, skuCode, unitPrice
	- A Customer has a registrationCode, fullName, email, telephone
  API-s:
  - Create customer
	- Create product
	- Create order
	- Search all orders by date
  - Search Orders by product
	- Search Orders by customer
	- Change quantity of products in an order line

## Prerequisites:
- **Java Development Kit (JDK):**
- JDK 17 or a later version.

- **Build Tool (Gradle):**
- Gradle is the build tool.
- You can use the Gradle Wrapper included in the project.

- **Database:**
- PostgreSQL database.

  ## Dependencies
- **Spring Boot:** The core framework for building Java applications.
- **Spring Data JPA:** Simplifies database operations with JPA (Java Persistence API).
- **Spring Boot Starter Validation:** Provides validation capabilities for your application.
- **Spring Boot Starter Web:** Allows you to build web applications.
- **Lombok:** A library to reduce boilerplate code in Java classes.
- **PostgreSQL JDBC Driver:** Allows Java applications to connect to PostgreSQL databases.
- **Springdoc OpenAPI:** Provides OpenAPI documentation for your API.
- **MapStruct:** Simplifies bean mappings between different Java bean types.

## How to Run
  **Database Configuration**:
   Configure the PostgreSQL database settings in the 
   'application.prperties'
  
   **Database Cleanup**:
   If needed, you can delete the database or reset it to its initial state
   under directory 'database' run
   'reset_database.sql'
   'create.sql'
   'import.sql'

   **Swagger**
   Opens atumatically after perfect run in Google Chrome.
   Possible to test API-s.

## Folder Structure:
- `src`: Contains the Java source code.
  it's divided into 'business' and 'domain'
  **business**
  contains controllers, services and dtos separately for each table
  **domain**
  contains tables entities, mappers and repositories.
  
- `database`: Contains SQL scripts for database setup and reset.

## TESTING
for testing API-s I used Swagger

## Contact:
If you have any questions or feedback, please contact me at [kaimarlilienthal@gmail.com].
