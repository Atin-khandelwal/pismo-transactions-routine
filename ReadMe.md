# Pismo Transaction Routine

### Overview

This project is issued by Pismo to create apis to registers accounts, fetch customer's
account details and generate a transaction.
Each cardholder (customer) has an account with their data.
For each operation done by the customer a transaction is created and associated with their
respective account.
Each transaction has a specific type (normal purchase, withdrawal, credit voucher or
purchase with installments)
Transactions of type purchase and withdrawal are registered with negative amounts, while
transactions of credit voucher are registered with positive value.

- Spring Boot 3XX
- Java 21 SE
- H2 database (postgres in case of docker compose)
- Docker

### Get this Project

```shell
# Clone  repository
$ git clone <https://github.com/Atin-khandelwal/pismo-transactions-routine>

# Go to the directory
$ cd pismo-transactions-routine


### Project Structure

Project structure is based on domain driven architecture  and models are separated by two entities one is dto and other one is domain model.
Defined packages below
- *model*: layer responsible for data object used for business logic.
- *dto*: layer responsible for data object used for request response logic.
- *controller*: entry point for each request , further have one layer of abstraction to support non function usecase like document etc.
- *service*: layer responsible for to concentrate the business logic.
- *repository*: layer responsible for to concentrate the storing and retrieving data.

Three database tables has been used.
TABLE Operations with id, description, evaluation_type with enum ('POSITIVE','NEGATIVE') column
TABLE accounts id ,ACCOUNT_NUMBER, ACCOUNT_HOLDER_NAME ,CREATED_AT,ACCOUNT_TYPE 
TABLE transactions id ,ACCOUNT_ID,OPERATION_ID ,EVENT_DATE ,AMOUNT 
### Todo Items
These are the tags where there will be scope of improvement.


### Application Tests

Unit test at the controller layer has been written.Which covers the business and request model validation.

```shell
$ mvn clean install
```

### Docs

The *endpoints* documentation was implemented following the Swagger UI documentation tool.

```
http://localhost:8080/swagger-ui/index.html
```

In this url above, you look for the following endpoints:

- /api/v1/accounts
- /api/v1/accounts/accountId
- /api/v1/transactions

!
