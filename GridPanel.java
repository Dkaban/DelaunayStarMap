//***********************************************************
//  GridDriver.java
//
//  Dustin Kaban
//  August 12th, 2020
//
//  This class handles the image loading, pixel selection and placing of images
//***********************************************************

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GridPanel extends JPanel
{
    BufferedImage spaceImage;
    Image dotImage;
    private float height,width;
    private int rgba;
    private ArrayList<Point> pointArrayList = new ArrayList<Point>();

    public GridPanel()
    {
        super();
        setBackground(Color.WHITE);
        loadImage();
        getImagePixelColor();
    }

    private void loadImage()
    {
        try
        {
            spaceImage = ImageIO.read(new File("starImage.jpg"));
            dotImage = ImageIO.read(new File("8square.png"));
        }
        catch(IOException e)
        {
            //Catch the exception
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(spaceImage,0,0,this);
        //g.drawImage(dotImage,0,0,this);

        for(int i=0;i<pointArrayList.size();i++)
        {
            g.drawImage(dotImage,pointArrayList.get(i).x,pointArrayList.get(i).y,this);
        }
    }

    protected void getImagePixelColor()
    {
        height = spaceImage.getHeight();
        width = spaceImage.getWidth();
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                rgba = spaceImage.getRGB(x,y);
                int red = (rgba >> 16) & 255;
                int green = (rgba >> 8) & 255;
                int blue = rgba & 255;

                if(red >= 245 && green >= 245 && blue >= 245)
                {
                    if(!pointArrayList.contains(new Point(x,y)))
                    {
                        pointArrayList.add(new Point(x,y));
                    }
                }
            }
        }
    }
}