import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Screen extends JPanel implements ActionListener {
    
    private ArrayList<Pair<Student,Schedule>> studentList;
	private ArrayList<Pair<Student,Schedule>> studentListStorage;
	
	private JTextArea textArea;
    private String text = "";
    
    private Schedule AllenGao;
	private Schedule KevinGuan;
	private Schedule TonyYao;
    
    private int xStringPos;
	private int yStringPos;
	
	private JTextField searchField;
	private JButton searchName;
	private JButton addSchedule;
	private JButton doneSchedule;
	
	private JTextField pField;
	private JTextField cField;
	private JButton addClass;

	private JButton addStudent;
	private JTextField createField;
	
    public Screen() {
        this.setLayout(null); 
		this.setFocusable(true);
		
        studentList = new ArrayList<Pair<Student,Schedule>>();
		studentListStorage = new ArrayList<Pair<Student,Schedule>>();
		
		AllenGao = new Schedule();
		KevinGuan = new Schedule();
		TonyYao = new Schedule();
		
		AllenGao.addClass(0,"AP Calculus BC");
		AllenGao.addClass(3,"AP Computer Science");
		AllenGao.addClass(2,"AP Physics C");
		
		KevinGuan.addClass(3,"AP Calculus AB");
		KevinGuan.addClass(1,"AP Computer Science");
		KevinGuan.addClass(5,"PE");
		
		TonyYao.addClass(3,"AP Calculus AB");
		TonyYao.addClass(1,"AP Chinese");
		TonyYao.addClass(7,"Golf practice");
		
		studentList.add(new Pair<Student,Schedule>(new Student("Allen Gao","AllenGao.jpg"),AllenGao));
		studentList.add(new Pair<Student,Schedule>(new Student("Kevin Guan","KevinGuan.png"),KevinGuan));
		studentList.add(new Pair<Student,Schedule>(new Student("Tony Yao","TonyYao.jpg"),TonyYao));
        
        //TextArea
		/*textArea = new JTextArea(); //sets the location and size
		textArea.setBounds(xStringPos,yStringPos,xStringPos+50,yStringPos+100);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.ITALIC, 16));
		textArea.setText(text);
		this.add(textArea);*/
		searchField = new JTextField();
		searchField.setBounds(552,546,200,24);
		this.add(searchField);
		
		searchName = new JButton("Search Name");
		searchName.setBounds(552,572,200,24);
		searchName.addActionListener(this);
		this.add(searchName);
		searchName.setBackground(Color.white);
		
		addSchedule = new JButton("Add");
		addSchedule.setBounds(764,600,100,24);
		addSchedule.addActionListener(this);
		this.add(addSchedule);
		addSchedule.setBackground(Color.white);
		addSchedule.setVisible(false);
		
		doneSchedule = new JButton("Done");
		doneSchedule.setBounds(764,572,100,24);
		doneSchedule.addActionListener(this);
		this.add(doneSchedule);
		doneSchedule.setBackground(Color.white);
		doneSchedule.setVisible(false);
		
		pField = new JTextField();
		pField.setBounds(796,546,20,24);
		this.add(pField);
		pField.setVisible(false);
	
		cField = new JTextField();
		cField.setBounds(816,546,80,24);
		this.add(cField);
		cField.setVisible(false);
		
		addClass = new JButton("Add Class");
		addClass.setBounds(796,572,100,24);
		addClass.addActionListener(this);
		this.add(addClass);
		addClass.setBackground(Color.green);
		addClass.setVisible(false);
		
		createField = new JTextField();
		createField.setBounds(74,546,200,24);
		this.add(createField);
		
		addStudent = new JButton("Add Student");
		addStudent.setBounds(74,572,200,24);
		addStudent.addActionListener(this);
		this.add(addStudent);
		addStudent.setBackground(Color.white);
        
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1400,700);
    }
 
   public void paintComponent(Graphics g) {
        //draw background
        super.paintComponent(g);
		Font fontLarge = new Font("Courier New",Font.BOLD,27);
		Font fontSmall = new Font("Courier New",Font.BOLD,11);
		
        g.setColor(Color.black);
        g.fillRect(0,0,1400,700);
        g.setColor(Color.blue);
        g.fillRect(50,50,1300,600);
        g.drawLine(0,0,50,50);
        g.drawLine(0,700,50,650);
        g.drawLine(1400,0,1350,50);
        g.drawLine(1400,700,1350,650);
        g.setFont(fontLarge);
        g.setColor(Color.black);
        g.drawString("Student Manager",70,70);
		g.setFont(fontSmall);
		
		
        
        
        /*for(int i =0;i<studentList.size();i++){
            g.setColor(Color.black);
            
            Schedule sd = pair.getValue();
            g.drawString(st.toString(),x1+55,y1+30);
            System.out.println("Studen " + st.toString());
            g.drawString(sd.toString(),x1+100,y1+100);
            
            st.drawStudent(g, x1, y1);
            
        }*/
        xStringPos = 60;
		yStringPos = 75;
		
		for(Pair<Student,Schedule> each : studentList){
			each.getKey().drawStudent(g,xStringPos,yStringPos);
			g.drawString(each.toString(),xStringPos+70,yStringPos+17);
			//text = each.toString();
			yStringPos += 70;
		}
        }
    
 
    public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == searchName){
			String input = searchField.getText();
			for(int i = 0; i < studentList.size(); i++){
				System.out.println(i);
				if(!studentList.get(i).getKey().toString().equals(input)){
					studentListStorage.add(studentList.get(i));
					studentList.remove(i);	
					i--;	
				}
			}	
			//for now >>
			//studentList.add(studentListStorage.get(0));
			//studentListStorage.remove(0);
			//for now >>
			addSchedule.setVisible(true);
			doneSchedule.setVisible(true);
		}
		if(e.getSource() == addSchedule){
			addSchedule.setVisible(false);
			doneSchedule.setVisible(false);
			addClass.setVisible(true);
			pField.setVisible(true);
			cField.setVisible(true);
		}
		if(e.getSource() == doneSchedule){
			addSchedule.setVisible(false);
			doneSchedule.setVisible(false);
			//Refresh
			for(int i = 0; i < studentListStorage.size(); i++){
				studentList.add(studentListStorage.get(i));
				studentListStorage.remove(i);
				i--;
			}
		}
		if(e.getSource() == addClass){
			int p = Integer.parseInt(pField.getText());
			String c = cField.getText();
			studentList.get(0).getValue().addClass(p,c);
			pField.setVisible(false);
			cField.setVisible(false);
			addClass.setVisible(false);
			//Refresh
			for(int i = 0; i < studentListStorage.size(); i++){
				studentList.add(studentListStorage.get(i));
				studentListStorage.remove(i);
				i--;
			}
		}
		if(e.getSource() == addStudent){
			studentList.add(new Pair<Student,Schedule>(new Student(createField.getText(),"Custom.png"),new Schedule()));
		}
			
		repaint();
    }
}

    
 
 
