public class JavaTile {

    public JavaTile(String mark) {
        if(mark.equals("X")) {
            currentMark = JavaMark.Marks.X;
        }
        if(mark.equals("O")) {
            currentMark = JavaMark.Marks.O;
        }
        else{
            currentMark = null;
        }
    }
    JavaMark.Marks currentMark;

    String markString() {
        if(currentMark == JavaMark.Marks.X) {
            return ("X");
        }
        else if (currentMark == JavaMark.Marks.O) {
            return ("O");
        }
        else{
            return null;
        }
    }

}
