package starWars;

/**
 * Class for storing all simple facts in our application.
 * @author Konrad
 *
 */
public class Fact {
	
	//constructors
	public Fact(String type, String value) {
		this.type = type;
		this.value = value;
	}
	public Fact(String type, boolean value) {
		this(type, convertBool(value));
	}
	public Fact(String type, int value) {
		this(type, Integer.toString(value));
	}
	public Fact(String type, float value) {
		this(type, Float.toString(value));
	}
	public Fact(String type, Object obj) {
		this.type = type;
		if(obj instanceof String)
			setValue((String)obj);
		if(obj instanceof Double)
			setValue((double)obj);
		if(obj instanceof Float)
			setValue((float)obj);
		if(obj instanceof Integer)
			setValue((int)obj);
		if(obj instanceof Boolean)
			setValue((boolean)obj);
	}
	
	//value getter and setters
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setValue(boolean value) {
		this.value = convertBool(value);
	}
	public void setValue(int value) {
		this.value = Integer.toString(value);
	}
	public void setValue(float value) {
		this.value = Float.toString(value);
	}
	public void setValue(double value) {
		this.value = Double.toString(value);
	}
	
	//key getter and setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	private static String convertBool(boolean value) {
		return value?"yes":"no";
	}
	
	//private fields
	private String type;
	private String value;

}
