public class Pokemon {
    private String name;
    private int level;
    private int hp;
    private Move[] moves;
    private String statusEffect;
    public Boolean selected;

    // constructor for pokemon with name, level and moves
    public Pokemon(String name, int level, Move[] moves) {
        this.name = name;
        this.level = level;
        // scale HP based on level
        this.hp = level * 10;
        this.moves = moves;
        this.statusEffect = "None";
        this.selected = false;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
  }
    // take damage from an attack
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) hp = 0;
    }

    // apply status effect to pokemon
    public void applyStatus(String effect) {
        if (statusEffect.equals("None")) statusEffect = effect;
    }
    
    // checks if pokemon is fainted
    public boolean isFainted() {
        return hp <= 0;
    }

    // prints pokemon's stats
    public void showStats() {
        System.out.println(name + " (Lvl " + level + ") HP: " + hp + " Status: " + statusEffect);
    }

    // returns pokemon's moves
    public Move[] getMoves() { 
        return moves; 
    }

    // returns pokemon's name
    public String getName() { 
        return name; 
    }

    // returns pokemon's hp
    public int getHp() { 
        return hp; 
    }

    // returns pokemon's status effect
    public String getStatusEffect() { 
        return statusEffect; 
    }

    // clears pokemon's status effect
    public void clearStatus() { 
        statusEffect = "None"; 
    }
}