import java.io.Serial;
import java.io.Serializable;

class FightingType extends Pokemon implements Serializable {
    @Serial
    private static final long serialVersionUID = 2116565707887814863L;

    public FightingType(String name, int hp, int atk, int def, int spd, int spe, Move move, ZMove zMove, double catchRate){
        super(name,hp,atk,def,spd,spe,Type.FIGHTING,Move.KARATECHOP,ZMove.ZFIGHT,catchRate);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String takeDamage(double enemyPower, Type enemyType){
        if (this.getHp() < 0){
            return this.getName() + " has already fainted! STOP!!";
        }
        if (Type.FIGHTING.strong.contains(enemyType)) {
            hp -= enemyPower*0.5;
            return "The attack is not very effective. \n " +this.getName() + "received " + (enemyPower*0.5) + " damage." ;
        } else if (Type.FIGHTING.weak.contains(enemyType)) {
            hp -= enemyPower*2;
            return "The attack is super effective! \n" + (enemyPower*2) + " damage received!" ;
        }
        else {
            hp -= enemyPower;
            return "The attack is effective!";
        }
    }   
}