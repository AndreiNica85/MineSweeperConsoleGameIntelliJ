public class MineSquare extends AbstractSquare {

    @Override
    public String showOnDisplay() {
        return Color.RED + "*";
    }

    @Override
    public String clicked(){
        return Color.RED + "*";
    }
}