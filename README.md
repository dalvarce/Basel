# Basel Service
Basel based service for categorization and calification (obtaining the Probability of Default) of a given banking
operation -mortgages, loans, credits, cards, etc-, for credit risk management purposes.

Also, base project to test some concepts (REST API, Eureka as naming server, Ribbon as load balancer, Docker as
container service, Kubernetes as container orchestrator, transactional methods, concurrency and so on).

## Info

Basic REST API services for categorization of a banking operation based on the product type, quantity of the operation and the 
collaterals provided.
The project consist on two services (Basel and Currency Conversor) and Eureka as a naming server.

Basel service call Currency Conversion service once for every amount to convert to Euros.

Create multiple instances of the Currency Conversor service to see how the load is balanced (***port*** field in Basel service response).


#### Basel service:
**Endpoints:**
* [POST] /basel/v1/analyzes : generate new analysis for a given banking operation
* [GET] /basel/v1/analyzes : get all analyzes (paginated)
* [GET] /basel/v1/analyzes/{idAnalysis} : get the {idAnalysis} analysis

#### Currency Conversor service: 
**Endpoints:**
* [GET] /currencyconversor/v1/conversions : convert a quantity from one currency to another currency (constant 
conversion, conversion based on tables to be implemented)

#### Eureka naming server
Default port: 8761

## TO-DO
The following list contains some random features to be implemented (not necessarily in order):

* Transactional methods
* Console log
* HATEOAS
* Concurrency (plus CurrencyConversor service accepting a list of conversions)
* Filtering & sorting in basel requests
* Calculate Probability of Default (decision tree based method)
* Automated tests
* Docker for containerization & Kubernetes for container orchestration

## Guides
For further reference, please consider the following sections:

* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Eureka Naming Server](https://github.com/Netflix/eureka)
* [Ribbon](https://github.com/Netflix/ribbon)
