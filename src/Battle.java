import java.util.Random;
import java.util.Scanner;

public class Battle {
    private User player;
    private Pokemon playerPokemon;
    private Pokemon playerPokemon2;
    private Pokemon wild;
    private Pokemon wild2;
    private Pokemon[] field; 
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();
    private boolean continueBattle = true;

    public Battle(User player, Pokemon wild, Pokemon wild2) throws CloneNotSupportedException {
        this.player = player;
        this.wild = wild;
        System.out.println("A wild " + wild.getName() + " has appeared!");
        this.wild2 = wild2;
        System.out.println("A wild " + wild2.getName() + " has appeared!");
        playerPokemon = ChoosePokemonFromLoadout(player);
        playerPokemon2 = ChoosePokemonFromLoadout(player);
        this.field = new Pokemon[]{playerPokemon,playerPokemon2,wild,wild2};

        pokemonBattle();
    }

    public void pokemonBattle() throws CloneNotSupportedException {
        while (continueBattle){
            // Check turn
            for(Pokemon pokemon : field){
                if(pokemon.getHp() < 0 ){
                    continue;
                }
                pokemon.decreaseActionValue(pokemon.getSpe());
                
                if(pokemon.equals(field[0])|| pokemon.equals(field[1])){
                    if(Main.QTE(0.01)){
                        pokemon.decreaseActionValue(1000);
                    }
                }
                if (pokemon.getActionValue() > 0){
                    continue;
                }
                pokemon.resetActionValue();
                System.out.println("\n" + pokemon.getName()+pokemon.getHp() + " is taking their turn!");
                //Player
                if (pokemon.equals(field[0]) || pokemon.equals(field[1])) {
                    System.out.println("1 : " + field[2].getName() + field[2].getHp());
                    System.out.println("2 : " + field[3].getName() + field[3].getHp());
                    System.out.println("Pick a pokemon to attack!");
                    Main.validateSelection(1,2);
                    
                    pokemon.dealDamage(field[Main.playerDecision+1]);
                }
                //Wild
                else if (pokemon.equals(field[2]) || pokemon.equals(field[3])){
                    if (rand.nextInt(1) == 1){
                        pokemon.dealDamage(field[0]);
                    }
                    else{
                        pokemon.dealDamage(field[1]);
                    }
                }
                if (pokemon.getHp() <= 0){
                    System.out.println(pokemon.getName() + " has fainted!");
                }
                if(checkGameOver() == 2){
                    System.out.println(player.getUserName() + " Won!");
                    continueBattle = false;
                    System.out.println("1 : " + field[2].getName());
                    System.out.println("2 : " + field[3].getName());
                    System.out.println("Pick a pokemon to catch!");
                    Main.validateSelection(1,2);
                    Catch idontknowwhattonamethis = new Catch(player, field[Main.playerDecision+1]);
                    break;
                }
                else if(checkGameOver() == 1){
                    System.out.println("Game Over!");
                    continueBattle = false;
                    break;
                }
            }
        }
    }

    /** Returns 1 if player lost, 2 if won */    
    private int checkGameOver(){
        if(field[0].getHp() <= 0 && field[1].getHp() <= 0){
            return 1;
        }
        if (field[2].getHp() <= 0 && field[3].getHp() <= 0){
            return 2;
        }
        else{
            return 0;
        }
    }

    private Pokemon ChoosePokemonFromLoadout(User player) throws CloneNotSupportedException{
        String errorMessage = "";
        while (true) {
            System.out.println(errorMessage);

            System.out.println("Pick a Pokemon");
            for(int choice = 1; choice <= player.getDeck().size(); choice++){
                System.out.println(choice+ ": " + player.getDeck().get(choice-1).getName());
             }         
                int choice = sc.nextInt();
                if (!player.getDeck().get(choice-1).equals(playerPokemon)) {
                    errorMessage = "";
                    System.out.println(player.getDeck().get(choice-1).getName() + ", I choose you!");
                    return player.getDeck().get(choice-1).clone();
                }
                else{
                    errorMessage = "This pokemon is already in the field!";
                    continue;
                }
            }
        }
    }
    