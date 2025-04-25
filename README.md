# Pokemon Battle

## Overview 
Pokemon battle, a turn based battle game where 2 players chose their Pokemon and battle against eachother. Each player selects 3 Pokemon from a pool of 10, the game ends once a player has no remaining Pokemon.

## Features:

### Player Setup: 
- Players can select their own names. 
- Players can set the deafult level they want the Pokemon to be.
### Battle Mechanics: 
- Players can attack or swap Pokemon during their turn 
- Moves have varying power that is effected by level and may apply status effects like Poison, Burn, or Freeze. 
- Status effects can deal additional damage or skip the opponent's turn.

## How to Play

### Start the Game:
1. Run the `Game.java` file.
2. Enter the names of Player 1 and Player 2.
3. Set the level for all Pokemon.

### Choose Pokemon:
- Each player selects 3 Pokemon from the pool of 10.
- Pokemon stats are based on their power and the level
- The moves of each will always stay the same.

### Battle:
- Players take turns to:
    - **Attack**: Use one of the active Pokemon's move.
    - **Swap Pokemon**: Switch the active Pokemon on the team (skips your turn).
- Your Pokemon may also be hit with a status effect and be dealt damage or skipping your turn.

### Win the Game:
- The game ends when one player has no remaining Pokemon.
- The player with remaining Pokemon left is declared the winner.

## Pokemon Pool
You will be able to select your Pokemon from the pool below

1. Charmander
- Ember (Power: 15, Effect: Burn)
- Scratch (Power: 10, Effect: None)

2. Squirtle
- Water Gun (Power: 14, Effect: None)
- Tackle (Power: 9, Effect: None)

3. Bulbasaur
- Poison Powder (Power: 0, Effect: Poison)
- Tackle (Power: 11, Effect: None)

4. Pikachu
- Thunder Wave (Power: 0, Effect: Freeze)
Quick Attack (Power: 12, Effect: None)

5. Eevee
- Bite (Power: 13, Effect: None)
- Swift (Power: 11, Effect: None)

6. Jigglypuff
- Sing (Power: 0, Effect: Freeze)
- Pound (Power: 10, Effect: None)

7. Meowth
- Scratch (Power: 12, Effect: None)
- Pay Day (Power: 14, Effect: None)

8. Machop
- Karate Chop (Power: 15, Effect: None)
- Low Kick (Power: 13, Effect: None)

9. Gastly
- Lick (Power: 10, Effect: Freeze)
- Night Shade (Power: 12, Effect: None)

10. Psyduck
- Water Pulse (Power: 14, Effect: None)
- Confusion (Power: 13, Effect: None)
