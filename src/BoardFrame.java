import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JPanel {
    private final Board b;

    BoardFrame(Board b) {
        this.b = b;
    }


    public void paint(Graphics g) {
        g.fillRect(0,0,50 * b.length - 50,50 * b.height - 50);
        for (int i = 0; i < b.height; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b.board[j + 1][i + 1].state != '#') {
                    g.clearRect(50 * i, 50 * j, 50, 50);
                }
            }
        }
    }
}