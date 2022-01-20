import java.util.Scanner;

/** You can choose game grid dimension and also the difficulty level in the start of the game. Click -1 to quit faster.
 * Just run and start the game and ENJOY! */

public class Main {
    private final static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        System.out.println(Color.PURPLE + "Welcome to " + Color.CYAN +  "MineSweeper " + Color.RED + "\n======================");
        Display display = new Display();
        System.out.println(display);
        while(!quit){
            System.out.println(Color.BLUE + "===============================================");
            System.out.println(Color.PURPLE + "Click on Square: ");
            System.out.print(Color.PURPLE + "Enter" + Color.CYAN + " row" + Color.PURPLE +" (from 1 to n): ");
            int row = console.nextInt();
            if(row == -1){
                return;
            }
            System.out.print(Color.PURPLE + "Enter" + Color.CYAN + " col" + Color.PURPLE +" (from 1 to n): ");
            int col = console.nextInt();
            Status onClick = display.click(row-1,col-1);
            System.out.println();
            System.out.println(display);
            System.out.println("" + Color.BLUE + "You clicked on row "+ Color.RED + row +  Color.BLUE + " and column " + Color.RED + col);
            quit = onClick.playTurn();
        }
    }
}
