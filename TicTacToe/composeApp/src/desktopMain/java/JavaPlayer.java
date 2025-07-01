public class JavaPlayer {

    public JavaPlayer(String mark) {
        if (mark.equals("X")) {
            playerMark = JavaMark.Marks.X;
        }
        else if (mark.equals("X")) {
            playerMark = JavaMark.Marks.X;
        }
        else {
            playerMark = null;
        }
    }

    JavaMark.Marks playermark;

    void mark(JavaTile tile) {
        tile.currentMark = playerMark;
    }
}
