# Fighter Game
This game is made for as assignment from a company

## Rules
- User first create a player with given name.
- User can buy weapons with given amount of money based on level.
- Available weapons has some attack depends upon type.
- This game is a turn based fight game. First hero attack opponent with selected weapon.
- User can change weapon on every attack.
- Then opponent attack back user's hero with randomly selected weapon.
- Every attack decrease health of hero and opponent depending on attack of weapon.
- Fight finishes when hero or opponent is killed.
- Level of hero increases with increase of experience
- On every higher level opponent is more stronger

## Known Limitations
Following limitations are not covered due to shortage of time
- Proper validations of input fields.
- Some Edge cases are not handled.


## Compile
```
$ mvn clean package
```
## Run
```
$ java -jar fighter-game-1.0-SNAPSHOT.jar
```