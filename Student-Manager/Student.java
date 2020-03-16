import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.net.URL;

import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Student{
    private String name;
    private String imageFile;
    private BufferedImage PhotoImage;
    
    public Student(String name,String imageFile)
    {
        this.name = name;
        this.imageFile = imageFile;
        try {
                PhotoImage = ImageIO.read(new File(imageFile));
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    public void drawStudent(Graphics g, int x, int y)
    {
        //g.setColor(Color.red);
        g.drawImage(PhotoImage, x, y, null);
       
    }
    public String toString()
    {
        return name;
    }
}