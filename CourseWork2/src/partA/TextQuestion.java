package partA;

import java.io.Serializable;
import java.util.Objects;

public class TextQuestion implements Serializable {
	private static final long serialVersionUID = 1L;
	private String answer;
	private String question;

	public TextQuestion(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String toString() {
		return answer;
	}
}
