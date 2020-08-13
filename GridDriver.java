//***********************************************************
//  GridDriver.java
//
//  Dustin Kaban
//  August 12th, 2020
//
//  This class handles the creation of the frame display functionality
//***********************************************************
import javax.swing.*;
import java.awt.*;

public class GridDriver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Delaunay Space Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1041,962);
        Container pane = frame.getContentPane();
        GridPanel p1 = new GridPanel();
        pane.add(p1);
        frame.setVisible(true);
    }
}
