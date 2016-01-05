package starWars;

import java.util.List;

public class Database {
	public static final String defaultSaveFilePath = "database/questionsDatabase.txt";
	
	public Database(List<Question> questions) {
		setQuestionList(questions);
	}
	
	public Database() {
		
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public void PrintToConsole() {
		System.out.println("Questions loaded to database:");
		for(Question question : questionList) {
			question.PrintToConsole();
		}
	}
	
	private List<Question> questionList;
	
}
