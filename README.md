# Fighter Game
This game is made for as assignment from a company

## Rules
- User first create a player with given name.
- User can buy weapons with given money. Amount of money is based on level.
- Available weapons has some attack and defence depends upon type.
- This game is a turn based fight game. First hero attack opponent we selected weapon.
- User can select weapon on every attack.
- Then opponent attack back user's hero with randomly selected weapon.
- Every attack decrease health of hero and opponent depending on attack of weapon.
- Fight finishes when one of the player killed.

## Known Limitations
Following limitations are not covered due to shortage of time
- Proper validations of input fields


## Compile
```
$ mvn clean package
```
## Run
```
$ java -jar fighter-game-1.0-SNAPSHOT.jar
```