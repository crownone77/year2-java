
public class FreeQuizQuestion extends Question {
	private String answer;

	public FreeQuizQuestion(String question, String answer) {
		super(question);
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}
}
