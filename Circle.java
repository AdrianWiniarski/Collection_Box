import java.awt.Color;
import java.awt.Graphics;

public class Circle{
	private float x,y,r;
	
	private boolean isFilled;
	
	public Circle(float x, float y){
		this.x=x;
		this.y=y;
		r=10;
		isFilled=false;
	}
	
	void Draw(Graphics g){
		g.setColor(Color.GREEN);
		g.drawOval((int)(x-r), (int)(y-r),(int)(2*r), (int)(2*r));
	}
	
	void move(float dx, float dy){
		this.x+=dx;
		this.y+=dy;
	}
	
	void fill(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval((int)(x-r), (int)(y-r),(int)(2*r), (int)(2*r));
	}
	
	public void setFilled(boolean filled){
		isFilled=filled;
	}
	public boolean isCircleFilled(){
		return isFilled;
	}
}
