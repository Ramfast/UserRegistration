# User Registration

A microservice that handles the registration of a new users in steps.

### Setup

* You will need a local redis instance running on your local machine
    * [How to set up redis](https://redis.io/topics/quickstart)
    * For mac users i would recommend installing redis with Homebrew
* Clone and open project in IntelliJ IDEA
* Copy the file application-dev.properties.example and remove the .example extension.
* Fill in your redis credentials
* Build and run the application

### Endpoints

* /ping
* /registration
* /registration/{uuid}/personalia
* /registration/{uuid}/address

See the provided [Postman collection](../UserRegistration.postman_collection.json) for more documentation on the endpoints.

### Todo
* Swagger documentation on endpoints
* Better exception and error handling
* Integration with the Customer service
* Writing tests
* Metrics
* Cloud deployment