# Starter kit pour le TP1

Projet servant de starter KIT pour le TP1.
Un exemple de TDD a deja ete implémenté en partie (les tests ont été écrits, il reste à les faire passer).

## Stack technique
* Java 21
* Springboot 3.3.3
* Test 
  * Junit 5
  * Mockito
  * Archunit

### 1.1 Lancer l'application
``` mvn spring-boot:run  ```

Données chargées au lancement de l'application présentes dans data-h2.sql

### 1.2 Lancer les tests
``` mvn test ```

### 1.3 API 
Méthode  | Path                         | Description                                                
------------- |------------------------------|------------------------------------------------------------
GET           | /voitures/proprietaire/{nom} | Récupère la liste des voitures pour un propriétaires donné 
A compléter   |            A compléter |                                                            |


## Documentation
Url d'accès au swagger de l'application

```http://localhost:8080/swagger-ui/index.html ```

## Pattern d'architecture
Ces patterns d'architecture sont garantis par la lib Archunit qui peremt d'effectuer les verifications lors de la phase de test, avec la classe ArchitectureTest
### Convention de nommage
Les Repository sont les classes qui permettent de faire le lien entre l'application et la base de données. Ils sont situés dans le package 'fac.luminy.m2.aa1.tp1.repository'
Les classes contenues dans le package 'fac.luminy.m2.aa1.tp1.repository' doivent être suffixé par Repository

Les Controllers sont les points d'entrée de l'application. Ils sont responsables de la gestion des requêtes HTTP et de la transformation des données en DTO.
Ils sont situés dans le package 'fac.luminy.m2.aa1.tp1.controller', suffixé de Controller

### Convention technique
Les classes présentes dans la couche controller ne doivent pas appeler directement les repository

Les repository utilisant JpaRepository, sont présent uniquement dans le package 'fac.luminy.m2.aa1.tp1.repository' et pas ailleurs