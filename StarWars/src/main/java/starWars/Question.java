package starWars;


import java.util.HashMap;

import javax.swing.*;

import org.yaml.snakeyaml.Yaml;

/**
 * Class for storing our questions.
 * @author Konrad
 *
 */
public class Question {
	
	public Question(int id, String name, String factKey, String[] list) {
		this.id = id;
		this.content = name;
		this.factKey = factKey;
		this.possiblyAnswers = list;
	}
	
	public int getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public String getFactKey() {
		return factKey;
	}
		public String[] getPossiblyAnswers() {
		return possiblyAnswers;
	}
	
	/**
	 * Question ID.
	 */
	public final int id;
	/**
	 * Question.
	 */
	public final String content;
	/**
	 * Fact's key.
	 */
	public final String factKey;
	/**
	 * Answers array.
	 */
	public final String[] possiblyAnswers;
	
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
		
				
		return new Fact(question.factKey, answer);
	}
	
	public void PrintYAML() {
		System.out.println(new Yaml().dump(this));
	}

	/**
	 * Questions database.
	 */
	public static HashMap<String, Question> questionDatabase = new HashMap<String, Question>();
}
