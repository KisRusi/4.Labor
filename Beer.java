import java.io.Serializable;
public class Beer implements Serializable{
	String name;
	String style;
	double strength;
	
	
	
	public Beer(String in1, String in2, double in3)
	{
		name = in1;
		style = in2;
		strength = in3;
	}
	
	@Override
	public String toString()
	{
		return "Beer [name: " + name + ", style: " + style + ", strength: " + strength + "]";
	}
	
	String getName()
	{
		return name;
	}
	
	String getStyle()
	{
		return style;
	}
	
	double getStrength()
	{
		return strength;
	}
	
	
}
