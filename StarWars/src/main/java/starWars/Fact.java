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
