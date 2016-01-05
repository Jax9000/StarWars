package starWars;

import java.util.List;

public class Database {
	public static final String defaultSaveFilePath = "database/questionsDatabase.txt";
	
	public Database(List<Question> questions) {
		setQuestionList(questions);
	}
	public Database() {
		
	}
	
	public Question GetQuestion(String questionID) {
		for(Question question : questionList) {
			if(question.getId().equals(questionID))
				return question;
		}
		
		return null;
	}
	
	//Getters and setters
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	/**
	 * Print database questions to console.
	 * <br/>
	 * <b>#FOR DEBUG</b>
	 */
	public void PrintToConsole() {
		System.out.println("Questions loaded to database:");
		for(Question question : questionList) {
			question.PrintToConsole();
		}
	}
	
	private List<Question> questionList;	
}
