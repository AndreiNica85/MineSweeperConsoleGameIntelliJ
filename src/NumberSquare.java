public class NumberSquare extends AbstractSquare{
    private final int number;

    public NumberSquare(int number) {
        this.number = number;
    }

    @Override
    public String clicked() {
        return "" + Color.RED + this.number;
    }

    @Override
    public String showOnDisplay() {
        return ""+ Color.GREEN + this.number;
    }

    public int getNumber() {
        return number;
    }

    public String printWarningMessage (){
        if(this.getNumber() == 1){
            return "1 mine is Close. You are stepping on mine field..";
        }else if(("" + this.getNumber()).equals("2")){
            return "2 mines in the Area. Careful now..";
        }else if(("" + this.getNumber()).equals("3")){
            return "3 mines in the Area. Let's see your next move..";
        }else if(("" + this.number).equals("4")){
            return "4 mines in the Area. Can you escape?";
        }else{
            return "5 + mines in the Area. You are kinda screwed!";
        }
    }
}