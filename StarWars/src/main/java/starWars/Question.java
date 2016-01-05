package starWars;

import javax.swing.*;

/**
 * Class for storing our questions.
 * @author Konrad
 *
 */
public class Question {
	
	//Constructors
	public Question(String id, String name, String factKey, String[] list) {
		this.id = id;
		this.content = name;
		this.factType = factKey;
		this.possiblyAnswers = list;
	}
	public Question() {
	}
	
	//Getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFactType() {
		return factType;
	}
	public void setFactType(String factType) {
		this.factType = factType;
	}
	
	public String[] getPossiblyAnswers() {
		return possiblyAnswers;
	}
	public void setPossiblyAnswers(String[] possiblyAnswers) {
		this.possiblyAnswers = possiblyAnswers;
	}
	
	public static void setDatabase(Database database) {
		Question.database = database;
	}
	
	//Usefull methods
	/**
	 * Show question dialog and get answer.
	 * @param questionID
	 * Question ID
	 * @return
	 * New fact.
	 */
	public Fact Ask(String questionID) {
		Question question = database.GetQuestion(questionID);
		
		if(question == null) {
			JOptionPane.showMessageDialog(null, "Question \"" + questionID + "\" not exists.");
			return null;
		}
		
		Object answer = JOptionPane.showInputDialog(
				null,
				question.content,
				questionID,
				JOptionPane.QUESTION_MESSAGE,
				null,
				question.getPossiblyAnswers(),
				question.getPossiblyAnswers()[0]);
		
				
		return new Fact(question.factType, answer);
	}
	
	public void PrintToConsole() {
		System.out.println("Question >> Content: " + this.content +
				"; ID: " + this.id + "; FactType: " + factType + "; Answers: " + printAnswers());;
	}	
	
	private String printAnswers() {
		String result = "[";
		boolean putComma = false;
		for(String str : possiblyAnswers) {
			result+= putComma ? ", " : "";
			result += str;
			putComma = true;
		}
		result += "]";
		return result;
	}

	//Database
	private static Database database = new Database();
	
	//Private fields
	/**
	 * Question ID.
	 */
	private String id;
	/**
	 * Question.
	 */
	public String content;
	/**
	 * Fact's type.
	 */
	public String factType;
	/**
	 * Answers array.
	 */
	public String[] possiblyAnswers;
}
