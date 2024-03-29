# spring-cloud-poc

POC per vedere all'opera i componenti fondamentali di Spring Cloud. 
Il progetto ha puro scopo dimostrativo e di studio, non fa praticamente niente se non esporre 3 endpoint, una delle quali chiama l'altra.

## Moduli

Ogni modulo Maven è un microservizio. Possiamo dividerli in due macrogruppi:

* ***infrastruttura***
    * **config-server**: server di configurazione "[Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/)". Le configurazioni risiedono in [un altro repository](https://github.com/VincenzoNTT/microservices-poc-artifact-config)
    * **eureka-server**: service registry ("[Eureka Server](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)")
    * **zipkin-server**: server di analisi dei tempi medi delle chiamate tra servizi ("[Zipkin](https://zipkin.io/)")
    
* ***applicativi***
    * **customer-services**: servizi inerenti ai clienti (ha solo un endpoint di prova)
    * **order-services**: servizi inerenti agli ordini dei clienti (ha solo un endpoint di prova)
    * **supplier-services**: servizi inerenti agli ordini dei clienti (ha solo un endpoint di prova)
    
## Startup

Data la natura dei servizi, quelli di "infrastruttura" dovrebbero essere avviati prima di quelli applicativi. 
In particolare, è vero esclusivamente per il **config-server** perché i servizi applicativi sono configurati per *fallire subito* se non lo trovano.

## Branches

