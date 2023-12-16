import java.util.Scanner;

public class Main {
    static private String info = "                                  ,'\\\r\n" + //
                    "    _.----.        ____         ,'  _\\   ___    ___     ____\r\n" + //
                    "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\r\n" + //
                    "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\r\n" + //
                    " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\r\n" + //
                    "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\r\n" + //
                    "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\r\n" + //
                    "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\r\n" + //
                    "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\r\n" + //
                    "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\r\n" + //
                    "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\r\n" + //
                    "                                `'                            '-._|"; //TODO add more info
    static Scanner sc = new Scanner(System.in);
    static int playerDecision;

    public static void main(String[] args) {
        //Generate test user, remove by submission
        User dummy = new User("Ash Ketchump", "ash123"); 
        dummy.AddPokemonIntoDeck(null);
        dummy.AddPokemonIntoDeck(null);
        User player = MainMenu();
        StartGame(player);

    }

    public static User MainMenu(){
        String[] options = {"Continue","New","Leaderboard","Quit"};
        String errorMessage = "";

        while (true) {
            System.out.println(info);
            for(int choice = 1; choice <= options.length; choice++){
                System.out.println(choice + " : " + options[choice-1]);
            }
            System.out.println("\n Choose an option!");
            System.out.println(errorMessage);
        
            try{
                playerDecision = sc.nextInt();
            } catch(Exception e){
                errorMessage = "Choose an integer!";
                continue;
            };
            if (playerDecision > options.length || playerDecision < 1){
                errorMessage = "Pick a number between 1 and " + options.length;
                continue;
            }
                break;
        }

        sc.nextLine();
        //Player chooses Continue
        if (playerDecision == 1){
           while (true) {
            System.out.println(errorMessage);
            System.out.println();
            System.out.println("Attempting login...");
            System.out.println("Enter a Username: ");
            String loginName = sc.nextLine();
            System.out.println("Enter a Password: ");
            String loginPass = sc.nextLine();
            

            for(User user : User.userList){
                System.out.println("Scanning :" + user.getUserName());
                if(user.getUserName().contains(loginName)){
                    errorMessage = "Password Incorrect!";
                    if(user.getUserPass().equals(loginPass)){
                        errorMessage = "";
                        System.out.println("Success! Logging in as " +loginName);
                        return user;
                    }
                }
            }
            errorMessage = "No user found!";
            continue;
        }
        }

        //Player chooses New
        else if (playerDecision == 2){
            System.out.println("Creating a new account...");
            System.out.println("Enter a Username: ");
            String newUserName = sc.nextLine();
            System.out.println("Enter a Password: ");
            String newUserPass = sc.nextLine();
            
            User newUser = new User(newUserName, newUserPass);
            return newUser;
        }
        //Player chooses Leaderboard

        //Player chooses Quit
        else{
            return null;
        }
    }

    public static void StartGame(User player){
        System.out.println("Starting game...");
    };

}