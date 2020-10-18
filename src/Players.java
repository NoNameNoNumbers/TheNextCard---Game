

public class Players {
    private String name;
    private int symbol;
    private static int lives;

    public Players(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Players() {
    }

    public String getName() {
        return name;
    }


    public int getSymbol() {
        return symbol;
    }

    public int getLives() {
        return lives;
    }

    public static void setLives(int live) {
        lives = live;
    }
}
