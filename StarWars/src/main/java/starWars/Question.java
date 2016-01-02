package starWars;

import java.util.Map;

public class Question {
	
	public Question(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getFactKey() {
		return factKey;
	}
	public void setFactKey(String factKey) {
		this.factKey = factKey;
	}

	private final int id;
	private final String name;
	/**
	 * Name of fact's key.
	 */
	private String factKey;
	private Map<String, String> possiblyAnswers;
	
}
