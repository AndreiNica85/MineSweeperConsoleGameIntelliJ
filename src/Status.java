public enum Status {
    EXIT{
        @Override
        boolean playTurn() {
            System.out.println("" + Color.RED + "MINE! You LOST! Game OVER! Bye...");
            return true;
        }
    },
    WRONG_INPUT{
        @Override
        boolean playTurn() {
            System.out.println("" + Color.RED + "Try a valid number of row and column.");
            return false;
        }
    },
    NUMBER{
        @Override
        boolean playTurn() {
            System.out.println("" + Color.RED + "MINES!");
            return false;
        }
    },
    EMPTY{
        @Override
        boolean playTurn() {
            System.out.println("" + Color.BLUE + "NOTHING there. Try again..");
            return false;
        }
    };

    abstract boolean playTurn();
}