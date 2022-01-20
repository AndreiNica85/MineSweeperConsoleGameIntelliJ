public abstract class AbstractSquare {
    boolean visible;
    boolean clicked;

    public String showInMatrice(){
        String show = "";
        if(isVisible()) {
            show = showOnDisplay();
        }
        if(isClicked()){
            show = clicked();
        }else if(!isVisible()){
            show = Color.CYAN + "#";
        }
        return show;
    }

    public abstract String showOnDisplay();

    public abstract String clicked();

    public boolean isVisible() {
        return visible;
    }

    public boolean isClicked(){
        return clicked;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void wasClicked(boolean click){
        this.clicked = click;
    }
}

