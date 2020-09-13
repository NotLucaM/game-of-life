import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.lang.System;
import java.util.concurrent.Executor;

public class Main {
        public static void main(String[] Args) throws IOException, InterruptedException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is your file's name?");
            String file = "input"; // String file = scanner.next();

            BufferedReader in = new BufferedReader(new FileReader(file));

            String sizes = in.readLine();
            int length = Integer.parseInt(sizes.split(" ")[0]);
            int height = Integer.parseInt(sizes.split(" ")[1]);

            Board board = new Board(length, height);
            board.define(file);

            BoardFrame bf = board.graphicPrint();
            board.nextBoard();


            JFrame frame = new JFrame();
            frame.getContentPane().add(bf);

            frame.setSize(1000, 1000);
            frame.setLocationRelativeTo(null);
            frame.setBackground(Color.LIGHT_GRAY);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

            long time = System.currentTimeMillis();
            while (true) {
                time = System.currentTimeMillis();

                frame.invalidate();

                bf.invalidate();
                frame.repaint();

                board.nextBoard();
                Thread.sleep(1000);
            }
    }

    static void clearScreen() {
        for (int i = 0; i < 1; i++) {
            System.out.println("");
        }
    }
}