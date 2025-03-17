# RESTful API - JAVA
Criação de uma API REST com Spring Boot, Java e Railway, desenvolvido no módulo sobre Spring Boot do curso: **Bradesco - Java Cloud Native**, da *Digital Innovation One* (DIO).\
Código criado por [Venilton Falvo Jr - @falvojr](https://github.com/falvojr) nas aulas ministradas.

## Diagrama de Classes
```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```
