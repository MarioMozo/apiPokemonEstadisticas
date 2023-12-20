# Project Backend Statistics

Aplication Back-end Spring, Spring Boot, Gradle, Lombok, JPA y MySQL:  PokeAPI, statistics, Domain architecture

## Requires

Java 17
MySQL 8.0
Postman

"Installation of IntelliJ IDEA IDE with the mentioned dependencies.

"Database configuration in the 'application.properties' file."


```bash
Start:

Configuration of application.properties"

spring.datasource.username= username
spring.datasource.password= password

public class PokeApiApplication.java


## Usage


@SpringBootApplication
@EnableJpaRepositories

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
--------------
#STRUCTURE

ENTITY
PERSISTENCE
REPOSITORY
SERVICE
CONTROLLER

```
##
ENDPOINT FOR BATTLE NODEJS TEAM

# url http://localhost:8091/api/history/save

# HistoryDTO

{


idUser	integer
nameUser	string
timeBet	integer
isWinnerUser	boolean
idUserPokemon	integer
nameUserPokemon	string
typeUserPokemon	string
moveUserPokemon	string
hpUserPokemon	integer
isOpntWinner	boolean
nameOpntPokemon	string
typeOpnt	string
moveOpntPokemon	string
hpOpntPokemon	integer
numberTurns	integer


}


# ENDPOINT TO SHOW IN THE STATISTICS FRONTEND


 url http://localhost:8091/api/history/findall

 
{


"idUser": 3,
  "nameUser": "mario",
  "timeBet": 10,
  "isWinnerUser": true,
  "idUserPokemon": 1,
  "nameUserPokemon": "picachu",
  "typeUserPokemon": "l",
  "moveUserPokemon": "l",
  "hpUserPokemon": 10,
  "isOpntWinner": true,
  "nameOpntPokemon": "pc1",
  "typeOpnt": "earth",
  "moveOpntPokemon": "thunder",
  "hpOpntPokemon": 10,
  "numberTurns": 3

  
}

## Contributing


Mario Iván Martínez Mozo

Martín Mosqueda Juárez

Israel Meneses Pérez


--------------------Please make sure to update tests as appropriate.-----------------------

## License

FREE
