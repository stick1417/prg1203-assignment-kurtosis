import java.util.ArrayList;

public class User {
    static ArrayList userIDList = new ArrayList<String>();
    static ArrayList userNameList = new ArrayList<String>();
    static ArrayList userPassList = new ArrayList<String>();

    private String userID;
    private String userName;
    private String userPass;

    private int Playcount;
    ArrayList deck = new ArrayList<Pokemon>();

    public void GeneratePokemon(String name, int HP, int ATK, int DEF, int SPD, int SPE, char type, int movePower, Boolean moveIsSpecial){
        // TODO figure this part out thanks
    }
    
    public void AddPokemonIntoDeck(Pokemon name){
        deck.add(name);
    }

    
}
