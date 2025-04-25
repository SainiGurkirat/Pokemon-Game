import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Game {
    static Random random = new Random();
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Pokemon Battle Game!");

        // player names
        System.out.print("Enter Player 1 name: ");
        Player player1 = new Player(userInput.nextLine());

        System.out.print("Enter Player 2 name: ");
        Player player2 = new Player(userInput.nextLine());

        // set default level for all pokemon
        System.out.print("Set Pokemons level: ");
        int level = userInput.nextInt();
        userInput.nextLine();

        // allow both players to choose their pokemon from the pool of 10 pokemon
        ArrayList<Pokemon> pool = generatePokemonPool(level);
        choosePokemon(player1, pool);
        choosePokemon(player2, pool);

        // sets the first player to start the game
        boolean player1Turn = true;
        boolean skipNextTurn = false;

        // main game loop. it will keep looping until one player has no remaining pokemon
        while (player1.hasRemainingPokemon() && player2.hasRemainingPokemon()) {
            // skips players turn when needed
            if (skipNextTurn) {
                skipNextTurn = false;
                player1Turn = !player1Turn;
                continue;
            }

            // sets current and opponent players based on turn
            Player current;
            Player opponent;
            if (player1Turn) {
                current = player1;
                opponent = player2;
            } else {
                current = player2;
                opponent = player1;
            }

            System.out.println("\n--- " + current.getName() + "'s Turn ---");

            // sets active and target pokemon depending who's turn it is
            Pokemon active = current.getActivePokemon();
            Pokemon target = opponent.getActivePokemon();

            System.out.println(current.getName() + "'s active Pokémon:");
            active.showStats();
            System.out.println("\n" + opponent.getName() + "'s active Pokémon:");
            target.showStats();

            System.out.println("\nChoose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Swap Pokémon");
            int actionChoice = userInput.nextInt();
            userInput.nextLine();
            
            // swap pokemon if the player chooses to do so
            if (actionChoice == 2) {
                System.out.println("Choose a Pokémon to swap to:");
                // prints all available pokemon on the team
                current.showAvailablePokemon(); 
                int swapChoice = userInput.nextInt();
                userInput.nextLine();

                // swaps pokemon with the selected one
                current.swapPokemon(swapChoice - 1); 

                // swaps turns
                player1Turn = !player1Turn;
                continue;
            }

            if(actionChoice == 1){
                Move[] moves = active.getMoves();
                System.out.println("Choose a move:");
    
                // prints all available moves for the active pokemon with their power and status effect
                for (int i = 0; i < moves.length; i++) {
                    System.out.println((i + 1) + ". " + moves[i].getName() + " (Power: " + moves[i].getPower() + ", Effect: " + moves[i].getStatusEffect() + ")" + ", PP: " + moves[i].getPP());
                }

                // gets player's choice of move
                int moveChoice = userInput.nextInt();
                userInput.nextLine();
                Move chosen = moves[moveChoice - 1];
    
                // uses the chosen move on the target pokemon
                System.out.println(active.getName() + " uses " + chosen.getName() + "! it did " + chosen.getPower() + " damage!");
                chosen.use(target, level);
    
                // checks if the target pokemon has a status effect and applies it
                String effect = chosen.getStatusEffect();
                int statusDmg = 0;
                switch (effect) {
                    // simply takes damage based on level
                    case "Poison":
                        if (!target.isFainted()) {
                            statusDmg = 3*level/5; 
                            target.takeDamage(statusDmg); 
                            System.out.println(target.getName() + " is poisoned and takes " + statusDmg + " damage!");
                        }
                        break;
                    case "Burn":
                        if (!target.isFainted()) {
                            statusDmg = 2*level/5; 
                            target.takeDamage(statusDmg);
                            System.out.println(target.getName() + " is burned and takes " + statusDmg + " damage!");
                        }
                        break;

                    // 20% to skip next turn
                    case "Freeze":
                        if (random.nextInt(100) < 20) {
                            System.out.println(target.getName() + " is frozen solid and can't move next turn!");
                            skipNextTurn = true;
                        }
                        break;
                    default:
                        break;
                }
                
                // checks if the target pokemon is fainted and prints a message
                if (target.isFainted()) {
                    System.out.println(target.getName() + " fainted!");
                }    
            }

            // swaps turns
            player1Turn = !player1Turn;
        }

        // checks which player has remaining pokemon and prints the winner
        if(player1.hasRemainingPokemon()){
            System.out.println("\nGame Over! " + player1.getName() + " wins the battle!");
        }else{
            System.out.println("\nGame Over! " + player2.getName() + " wins the battle!");
        }
        
    }

    // create a pool of 10 pokemon and sets deafult moves and level
    static ArrayList<Pokemon> generatePokemonPool(int level) {
        
        ArrayList<Pokemon> pool = new ArrayList<>();

        // charmander
        pool.add(new Pokemon("Charmander", level, new Move[]{
            new Move("Ember", 15, "Burn"), 
            new Move("Scratch", 10, "None")
        }));

        // squirtle
        pool.add(new Pokemon("Squirtle", level, new Move[]{
            new Move("Water Gun", 14, "None"), 
            new Move("Tackle", 9, "None")
        }));

        // bulbasaur
        pool.add(new Pokemon("Bulbasaur", level, new Move[]{
            new Move("Poison Powder", 0, "Poison"), 
            new Move("Tackle", 11, "None")
        }));

        // pikachu
        pool.add(new Pokemon("Pikachu", level, new Move[]{
            new Move("Thunder Wave", 0, "Freeze"), 
            new Move("Quick Attack", 12, "None")
        }));

        // eevee
        pool.add(new Pokemon("Eevee", level, new Move[]{
            new Move("Bite", 13, "None"), 
            new Move("Swift", 11, "None")
        }));

        // jigglypuff    
        pool.add(new Pokemon("Jigglypuff", level, new Move[]{
            new Move("Sing", 0, "Freeze"), 
            new Move("Pound", 10, "None")
        }));

        // meowth
        pool.add(new Pokemon("Meowth", level, new Move[]{
            new Move("Scratch", 12, "None"), 
            new Move("Pay Day", 14, "None")
        }));

        // machop    
        pool.add(new Pokemon("Machop", level, new Move[]{
            new Move("Karate Chop", 15, "None"), 
            new Move("Low Kick", 13, "None")
        }));

        // gastly
        pool.add(new Pokemon("Gastly", level, new Move[]{
            new Move("Lick", 12, "Freeze"), 
            new Move("Spite", 13, "Poison")
        }));

        // psyduck
        pool.add(new Pokemon("Psyduck", level, new Move[]{
            new Move("Water Pulse", 14, "None"),
            new Move("Confusion", 12, "None")
            }));

        return pool;
    }

    static void choosePokemon(Player player, ArrayList<Pokemon> pool) {
        System.out.println("\n" + player.getName() + ", choose your 3 Pokemon:");
        for (int i = 0; i < pool.size(); i++) {
            System.out.println((i + 1) + ". " + pool.get(i).getName());
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("Choose Pokemon " + (i + 1) + " by number: ");
            int choice = userInput.nextInt();
            userInput.nextLine();
            Pokemon selected = pool.get(choice - 1);
            player.addPokemon(new Pokemon(selected.getName(), selected.getHp() / 10, selected.getMoves()));
        }
    }
}
