public class EmptySquare extends AbstractSquare{
    @Override
    public String showOnDisplay() {
        return Color.BLUE + "-";
    }

    @Override
    public String clicked(){
        return Color.RED + "*";
    }
}