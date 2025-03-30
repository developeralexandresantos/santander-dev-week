# Santander Dev Week 2023
Java RESTful API criada para a Santander Dev Week.

## Diagrama de classes

```mermaid
classDiagram
    class User {
        -String name
        -Account account
        -List~Feature~ features
        -Card card
        -List~News~ news
    }

    class Account {
        -String agency
        -String number
        -Double balance
        -Double limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -Double limit
    }

    class News {
        -String newsIcon
        -String newsDescription
    }

    User --> Account
    User --> Feature
    User --> Card
    User --> News
```
