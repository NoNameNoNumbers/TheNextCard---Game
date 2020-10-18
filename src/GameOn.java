import java.util.ArrayList;
import java.util.Scanner;

public class GameOn {
    private ArrayList<Players> gameList;
    private Scanner scan = new Scanner(System.in);
    private int challenges;
    private int []arr;
    private boolean flag;


    public GameOn(ArrayList<Players> gameList) {
        arr = new int[gameList.size()];
        this.gameList = gameList;
    }

    public ArrayList<Players> getGameList() {
        return gameList;
    }

    public void startGame()
    {
        System.out.println("Enter number of challenges per player");
        challenges = scan.nextInt();
        flag = false;
        int action;
        while (!flag)
        {
            System.out.println("Game Menu \n -> Options: 0-quit; \t 1-next round; \t 2-printList");
            action = scan.nextInt();
            scan.nextLine();
            int x;
            switch (action) {
                case 0 -> flag = true;
                case 1 -> {
                    x = numGen();
                    if (x >= 0)
                        System.out.println(x + " " + gameList.get(x).getName());
                }
                case 2 -> printList();
            }
        }
    }

    public int numGen ()
    {
        int x =(int) (Math.random()* gameList.size());
        if (sumTotal()==gameList.size()*challenges)
        {
            flag=true;
            System.out.println("All players have done the selected number of challenges");
            return -1;
        }
        else if (arr[x]==challenges)
        {
            return numGen();
        }
        else
        {
            arr[x]++;
            return x;
        }
    }

    public void printList()
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(i+1+"\t"+gameList.get(i).getName()+"\t has done "+arr[i]+" challenges");
        }
    }

    public int sumTotal()
    {
        int total=0;
        for (int j : arr) {
            total += j;
        }
        return total;
    }
}
