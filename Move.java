import java.util.Random;

public class Move {
    public Random random = new Random();
    private String name;
    private int power; // same as damage
    private String statusEffect;
    private int PP; // power points

    // constructor for move with name, power and status effect
    public Move(String name, int power, String statusEffect) {
        this.name = name;
        this.power = power;
        this.statusEffect = statusEffect;
        this.PP = 10;
    }

    public int getPower() { 
        return power; 
    }
    public String getName() { 
        return name; 
    }
    public String getStatusEffect() { 
        return statusEffect; 
    }

    public int getPP() {
        return this.PP;
    }


    // use move on target pokemon
    public void use(Pokemon target, int pokemonLevel) {
        
        if(this.PP <= 0){
            System.out.println(this.name +  " can no longer be used because you are out of PP! skipped turn.");
            return;
        }

        this.PP -= 1;
        target.takeDamage(power*pokemonLevel/5); // scale damage based on level

        // if the move has a status effect, apply it with a chance of 40%
        if (!statusEffect.equals("None")) {
            if (random.nextInt(100) < 40) { // 40% chance
                target.applyStatus(statusEffect);
                System.out.println(target.getName() + " is affected by " + statusEffect + "!");
            }
        }
    }
}