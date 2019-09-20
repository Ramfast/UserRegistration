# User Registration

A microservice that handles the registration of a new user in steps.

### Setup

* You will need a local redis instance running on your local machine
* Clone and open project in IntelliJ IDEA
* Copy the file application-dev.properties.example and remove the .example suffix.
* Fill in your redis credentials
* Build and run the application

### Endpoints

* /ping
* /registration
* /registration/{uuid}/personalia
* /registration/{uuid}/address

See the provided Postman collection for more documentation on the endpoints.