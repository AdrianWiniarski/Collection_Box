import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Program extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -8676022778238066112L;
	
	private Picture picture;
	private JTextField textArea,name,size;
	private JLabel label;
	private Thread thread;
	private Timer timer;
	private JButton author, reset, add, delete, clear;
	private HashSet<Box> hashSet;
	private CollectionView view;
	private final String AUTHOR="Imiê i nazwisko:\n"+
			"Adrian W.\n"+"kierunek:\n"+
			"Informatyka\n"+"Numer indeksu:\n"+
			"";
	public static void main(String[] args) {
		new Program();
	}
	
	public Program(){
		
		super("Adrian W.");
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		picture=new Picture();
		
		add=new JButton("Dodaj pude³ko");
		add.addActionListener(this);
		delete=new JButton("Usuñ pude³ko");
		delete.addActionListener(this);
		clear=new JButton("Wyczyœæ listê");
		clear.addActionListener(this);



		textArea=new JTextField(2);
		name=new JTextField(10);
		size=new JTextField(10);
		textArea.setEditable(false);
		label=new JLabel("Czas, przez który dzia³a program:");
		author=new JButton("Informacje o autorze");
		author.addActionListener(this);
		picture.add(author);
		picture.add(label);
		picture.add(textArea);
		reset=new JButton("Resetuj stoper");
		reset.addActionListener(this);
		picture.add(reset);
		picture.add(name);
		picture.add(size);
		picture.add(add);
		picture.add(delete);
		picture.add(clear);
		hashSet=new HashSet<Box>();
		view=new CollectionView(hashSet,400,300,"Widok");
		picture.add(view);
		picture.addMouseListener(picture);
		picture.addMouseMotionListener(picture);
		this.setContentPane(picture);
		timer=new Timer(this);
		thread=new Thread(timer);
		thread.start();
		this.setVisible(true);
	}
	
	public void setTextArea(int text){
		StringBuilder sb=new StringBuilder();
		sb.append(text);
		this.textArea.setText(sb.toString());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source=arg0.getSource();
		if(source==author){
			JOptionPane.showMessageDialog(null, AUTHOR);
		}
		if(source==reset){
			timer.stopWorking();
			timer=new Timer(this);
			thread=new Thread(timer);
			thread.start();
		}
		if(source==add){
			hashSet.add(new Box(name.getText(),size.getText()));
		}
		if(source==delete){
			hashSet.remove(new Box(name.getText(),size.getText()));
		}
		if(source==clear){
			hashSet.clear();
		}
		
		view.refresh();
	}
	
	
}
