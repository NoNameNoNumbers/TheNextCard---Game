import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrayList<Players>players = new ArrayList<>();
    private static int symbol=1;
    //Each player will have up to 4 times to be picked up
    //When your symbol(number) is shown, you are bond to do a challenge
    //the previous challenged player decided
    //The game ends when all players did 4 challenges

    public static void main (String []args){

        boolean quit=false;
        int action;
        while (!quit)
        {
            System.out.println("Main Menu \n Choose Action: ");
            printInstructions();
            action=scan.nextInt();
            scan.nextLine();
            switch (action) {
                case 0 -> quit = true;
                case 1 -> {
                    System.out.println("add new player");
                    AddPlayer();
                }
                case 2 -> gameOn();
                case 3 -> {
                    System.out.println("printList was called");
                    printList();
                }
                case 4 -> printInstructions();
            }
        }
    }
    public static void printList(){
        for (Players player : players) {
            System.out.println(player.getSymbol() + "\t" + player.getName());

        }
    }
    public static void AddPlayer(){

        System.out.println("introduce player name");
        String name = scan.nextLine();
        Players player = new Players(name, symbol);
        players.add(player);
        symbol++;
    }

    public static void gameOn()
    {
        GameOn newGame = new GameOn(players);
        newGame.startGame();
    }
    public static void printInstructions ()
    {
        System.out.println(" 0-quit \n 1-add new player \n 2-start game \n 3-print list of players \n 4-print options");
    }
}
