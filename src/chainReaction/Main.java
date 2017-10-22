package chainReaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main{
    public static int X;
    public static int Y;
    public static int flag=90;
    public static int chanceOf=1;

    public static void main(String[] f){

        JLabel labelBoard = new JLabel();
        labelBoard.setBounds(0,0,500, 600);
        //labelBoard.setIcon(greenBoard);
        JPanel panelBoard = new JPanel();
        panelBoard.setBounds(0, 0, 500 ,600);
        panelBoard.add(labelBoard);










        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(10,10,500,600);
        frame.setResizable(false);
        frame.setTitle("OOPM Mini Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Graphics graphics = null;
        Board board=new Board();
        board.allNull();

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chanceOf++;
                X=e.getX();
                Y=e.getY();
                flag=1;
                //board.move();
                board.getxy();
                board.print();
                board.something();
                board.something1();
                board.display(board.numberOfBalls);
                board.repaint();
            }
        });
        frame.add(board);
    }
}
