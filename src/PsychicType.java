import java.io.Serial;
import java.io.Serializable;

class PsychicType extends Pokemon implements Serializable {
    @Serial
    private static final long serialVersionUID = 5548433727549265126L;

    public PsychicType(String name, int hp, int atk, int def, int spd, int spe, Move move, ZMove zMove, double catchRate){
        super(name,hp,atk,def,spd,spe,Type.PSYCHIC,Move.PSYSHOCK,ZMove.ZPSY,catchRate);
    }

    @Override
    public String getName() {
        return ConsoleColours.PURPLE.text + this.name + ConsoleColours.RESET.text;
    }

    @Override
    public String takeDamage(double enemyPower, Type enemyType){
        if (this.getHp() < 0){
            return this.getName() + " has already fainted! STOP!!";
        }
        if (Type.PSYCHIC.strong.contains(enemyType)) {
            hp -= (int) (enemyPower*0.5);
            return "The attack is not very effective. \n " +this.getName() + "received " + (enemyPower*0.5) + " damage." ;
        } else if (Type.PSYCHIC.weak.contains(enemyType)) {
            hp -= enemyPower*2;
            return "The attack is super effective! \n" + (enemyPower*2) + " damage received!" ;
        }
        else {
            hp -= enemyPower;
            return "The attack is effective! \n" + (enemyPower) + "damage received!";
        }
    }   
}