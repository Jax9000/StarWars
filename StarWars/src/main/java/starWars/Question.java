package starWars;


import java.util.HashMap;

import javax.swing.*;

/**
 * Class for storing our questions.
 * @author Konrad
 *
 */
public class Question {
	
	public Question(int id, String name, String factKey, String[] list) {
		this.id = id;
		this.content = name;
		this.factType = factKey;
		this.possiblyAnswers = list;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		
	public Question() {
		
	}
	
	/**
	 * Question ID.
	 */
	private int id;
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
	
	/**
	 * Show question dialog and get answer.
	 * @param questionID
	 * Question ID
	 * @return
	 * New fact.
	 */
	public Fact Ask(String questionID) {
		Question question = questionDatabase.get(questionID);
		
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
	String printAnswers() {
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

	/**
	 * Questions database.
	 */
	public static HashMap<String, Question> questionDatabase = new HashMap<String, Question>();
}
