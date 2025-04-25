import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Pokemon> team;
    
    // constructor for player with name and empty team
    public Player(String name) {
        this.name = name;
        this.team = new ArrayList<>();
    }

    public void addPokemon(Pokemon p) {
        // adds a pokemon to the team if there are less than 3 pokemon on the team
        if (team.size() < 3) team.add(p);
    }

    // returns the name of player
    public String getName() { 
        return name; 
    }

    // returns the team of player
    public ArrayList<Pokemon> getTeam() { 
        return team; 
    }

    public boolean hasRemainingPokemon() {
        // checks if there are any pokemon on the team that are not fainted otherwise returns false
        for (Pokemon p : team) {
            if (!p.isFainted()) return true;
        }

        return false;
    }

    public Pokemon getActivePokemon() {
        // loops through the team from the start and returns the first pokemon on the team that is not fainted else return null if all are fainted
        for (Pokemon p : team) {
            if (!p.isFainted()) return p;
        }
        return null;
    }

    public void showAvailablePokemon() {
        // loops through all pokemon on the team and prints their name and if their fainted or not
        for (int i = 0; i < team.size(); i++) {
            if (!team.get(i).isFainted()) {
                System.out.println((i + 1) + ". " + team.get(i).getName() + ": Active");
            }else {
                System.out.println((i + 1) + ". " + team.get(i).getName() + ": Fainted");
            }
        }
    }
    
    public void swapPokemon(int i) {
        // checks for valid choice
        if (i >= 0 && i < team.size() && !team.get(i).isFainted()) {
            // gets pokemon at the first positoin 
            Pokemon temp = team.get(0);

            // swaps the position of the first pokemon with the selected one
            team.set(0, team.get(i));
            team.set(i, temp);

            System.out.println("Swapped to " + team.get(0).getName() + "!");
        } else {
            System.out.println("Invalid choice or Pokemon is fainted. Turn skipped.");
        }
    }
}