import java.io.Serializable;

public class Box implements Comparable<Box>, Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String size;
	
	public Box(String name, String size){
		this.name=name;
		this.size=size;
	}
	
	@Override
	public int compareTo(Box arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object box){
		return (this.name.equals(((Box) box).getName()) && this.size.equals(((Box) box).getSize()));
	}
	public String getName(){
		return name;
	}
	
	public String getSize(){
		return size;
	}
	
	@Override
	public int hashCode(){
		return name.hashCode()+size.hashCode();
	}
}
