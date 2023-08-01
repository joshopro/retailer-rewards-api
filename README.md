# Retailer Rewards Program API

This Spring Boot application provides a RESTful API to track customers' transactions and calculate their rewards based on a retailer's rewards program.

## Getting Started
### Prerequisites

To run this application, you will need:

* Java 8 or newer
* Maven 3.2+

### Building the application

1. Clone the repository:
```
git clone https://github.com/joshopro/retailer-rewards-api.git
```

2. Change into the directory:
```
cd retailer-rewards-api
```

3. Build the application using Maven:
```
mvn clean install
```

### Running the application
To run the application, execute:
```
mvn spring-boot:run
```

Alternatively, you can run the application directly using the Spring Boot Maven plugin:
```
mvn spring-boot:run
```

### API Endpoints
The application provides the following RESTful endpoints:

* **POST /api/transactions**: Submit a new transaction.

```json
{
    "customerId": "string",
    "amount": "decimal",
    "dateOfTransaction": "yyyy-MM-dd"
}
```
* **GET /api/customers/{customerId}/rewards**: Get the total reward points for a specific customer.

    Path variable:
  * `customerId`: ID of the customer

* **GET /api/customers/{customerId}/rewards?month={month}&year={year}**: Get the reward points for a specific customer for a given month and year.
  
    Path variable:
  * `customerId`: ID of the customer

  Query parameters:
  * `month`: Month to retrieve reward points for
  * `year`: Year to retrieve reward points for

### Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [H2 Database Engine](https://www.h2database.com/html/main.html)

### Author
Josh Owens
