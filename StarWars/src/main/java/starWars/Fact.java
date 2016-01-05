package starWars;

/**
 * Class for storing all simple facts in our application.
 * @author Konrad
 *
 */
public class Fact {
	
	//constructors
	public Fact(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public Fact(String key, boolean value) {
		this(key, convertBool(value));
	}
	public Fact(String key, int value) {
		this(key, Integer.toString(value));
	}
	public Fact(String key, float value) {
		this(key, Float.toString(value));
	}
	public Fact(String key, Object obj) {
		this.key = key;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	private static String convertBool(boolean value) {
		return value?"yes":"no";
	}
	
	//private fields
	private String key;
	private String value;

}
