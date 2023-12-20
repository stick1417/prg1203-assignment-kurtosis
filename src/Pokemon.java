
class Pokemon implements Cloneable {
    protected String name = "MissingNo.";
    protected int hp = 33;
    protected int atk = 136;
    protected int def = 0;
    /**Pokemon Special Defense Stat */
    protected int spd = 6; 
    /** Pokemon Speed Stat */
    protected int spe = 29;
    protected Type type = Type.NONE; 
    protected boolean moveIsSpecial = false;
    protected double catchRate = 4;
    protected int actionValue = 1000;


    public Pokemon(String name, int hp, int atk, int def, int spd, int spe, Type type, boolean moveIsSpecial,
            double catchRate) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.spe = spe;
        this.type = type;
        this.moveIsSpecial = moveIsSpecial;
        this.catchRate = catchRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    /** Returns pokemon special defense stat */
    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    /** Returns pokemon speed stat */
    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }

    public boolean isMoveIsSpecial() {
        return moveIsSpecial;
    }

    public void setMoveIsSpecial(boolean moveIsSpecial) {
        this.moveIsSpecial = moveIsSpecial;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }

    public int dealDamage(Pokemon attacker, Pokemon defender) {
        // Base damage
        int enemyPower = attacker.getAtk();
        // Stat modifiers
        if (attacker.moveIsSpecial) {
            enemyPower = (int) (enemyPower * ((attacker.getAtk() + 50) / (defender.getSpd() + 50)));
        } else {
            enemyPower = (int) (enemyPower * ((attacker.getAtk() + 50) / (defender.getDef() + 50)));
        }
            // RNG element
            enemyPower = (int) (enemyPower * (Math.random() * 0.15 + 0.85));
            // Ensure minimum damage of 1
            return Math.max(1, enemyPower);
    }

    public String takeDamage(int enemyPower, Type enemyType){
        return enemyPower + " Damage taken!";
    }
    
    public String healHealth(int heal){
        return "Recovered " + heal + " HP!";
    }
    
    public int getActionValue() {
        return actionValue;
    }

/**Decrease the pokemon's action value by it's speed. @param speed */
    public void decreaseActionValue(int speed) {
        this.actionValue -= speed;
    }

    public Pokemon clone() throws CloneNotSupportedException {
        return (Pokemon) super.clone();
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", def=" + def +
                ", spd=" + spd +
                ", spe=" + spe +
                ", moveSpecial=" + moveIsSpecial +
                ", catchRate=" + catchRate +
                '}';
    }
}

