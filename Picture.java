import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;

public class Picture extends JPanel implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private ArrayList<Circle> circles=new ArrayList<Circle>();
	private float lastMouseY, lastMouseX;
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Circle c : circles){
			if(c.isCircleFilled()){
				c.fill(g);
			}
			else
			{
				c.Draw(g);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		for(Circle c :circles){
			if(c.isCircleFilled()){
				c.setFilled(false);
			}
			else
			{
				c.setFilled(true);
			}
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		circles.add(new Circle(arg0.getX(),arg0.getY()));
		lastMouseX=arg0.getX();
		lastMouseY=arg0.getY();
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		circles.clear();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		for(Circle c : circles){
			c.move(arg0.getX()-lastMouseX,arg0.getY()-lastMouseY);
		}
		lastMouseX=arg0.getX();
		lastMouseY=arg0.getY();
		repaint();
	}

}
