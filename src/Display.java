import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Display {
    private final static Scanner console = new Scanner(System.in);
    private final AbstractSquare[][] displayOfGame;

    public Display() {
        System.out.print(Color.RED + "Enter number \""+ Color.CYAN + "n"+ Color.RED + "\" for "+ Color.CYAN + "rows "+ Color.RED +"and " + Color.CYAN +"columns" + Color.RED +" for grid (n x n): ");
        int n = console.nextInt();
        this.displayOfGame = new AbstractSquare[n][n];
        System.out.println();
        populateMatrix();
        System.out.print(Color.RED + "Enter difficulty - number of " +Color.CYAN + "mines " + Color.RED +"(more mines means bigger difficulty): ");
        int m = console.nextInt();

        System.out.println("=========================================================================");
        for(int i = 1; i <= m; i++){
            addMine(n);
        }
        addNumbers();
    }

    public void populateMatrix(){
        for(int i = 0; i < this.displayOfGame.length; i++){
            for(int j = 0; j < this.displayOfGame[i].length; j++){
                this.displayOfGame[i][j] = new EmptySquare();
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(AbstractSquare[] abs : this.displayOfGame){
            for(AbstractSquare element : abs){
                s = s.concat(element.showInMatrice());
            }
            s = s.concat("\n");
        }
        return s;
    }

    public void addMine (int squareLenght){
        Random random = new Random();
        int x = random.nextInt(squareLenght);
        int y = random.nextInt(squareLenght);
        MineSquare mineSquare = new MineSquare();

        while(!(this.displayOfGame[x][y] instanceof EmptySquare)){
            x = random.nextInt(squareLenght);
            y = random.nextInt(squareLenght);
        }
        this.displayOfGame[x][y] = mineSquare;
    }


    public void addNumbers(){

        int countMines = 0;

        for(int x = 0; x < this.displayOfGame.length; x++){
            for(int y = 0; y < this.displayOfGame[x].length; y++){
                if(this.displayOfGame[x][y] instanceof EmptySquare){
                    int[] xDirections = new int[]{-1,0,1,-1,1,1,0,-1};
                    int[] yDirections = new int[]{-1,-1,-1,0,0,1,1,1};

                    for(int i = 0; i < 8; i++){
                        int newX = x + xDirections[i];
                        int newY = y + yDirections[i];

                        if (newX >= 0 && newX < displayOfGame.length && newY >= 0 && newY < displayOfGame[0].length && displayOfGame[newX][newY] instanceof MineSquare) {
                            countMines++;
                        }
                    }
                    if(countMines != 0){
                        displayOfGame[x][y] = new NumberSquare(countMines);
                    }
                    countMines = 0;
                }
            }
        }
    }

    public Status click(int x, int y) {
        if(x < 0 || y < 0 || x > displayOfGame.length-1 || y > displayOfGame[0].length-1) {
            return Status.WRONG_INPUT;
        }else if(displayOfGame[x][y] instanceof NumberSquare){
            displayOfGame[x][y].wasClicked(true);
            NumberSquare num = (NumberSquare) displayOfGame[x][y];
            System.out.println(Color.PURPLE + "===============================================");
            System.out.println(Color.BLUE + num.printWarningMessage());
            return Status.NUMBER;
        }else if(displayOfGame[x][y] instanceof MineSquare){
            displayOfGame[x][y].setVisible(true);
            return Status.EXIT;
        }else{
            displayOfGame[x][y].setVisible(true);
            displayOfGame[x][y].wasClicked(true);
            Queue<int[]> queue = new LinkedList<>();
            int[] xDirections = new int[]{-1,0,1,-1,1,1,0,-1};
            int[] yDirections = new int[]{-1,-1,-1,0,0,1,1,1};
            queue.add(new int[]{x,y});
            while(!queue.isEmpty()){
                int[] pos = queue.poll();

                for(int i = 0; i < 8; i++) {
                    int newX = pos[0] + xDirections[i];
                    int newY = pos[1] + yDirections[i];

                    if (newX >= 0 && newX < displayOfGame.length && newY >= 0 && newY < displayOfGame[0].length && !displayOfGame[newX][newY].isVisible()) {
                        displayOfGame[newX][newY].setVisible(true);
                        if (displayOfGame[newX][newY] instanceof EmptySquare) {
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            return Status.EMPTY;
        }
    }
}