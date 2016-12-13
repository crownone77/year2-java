import java.util.Arrays;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
	private int answer;
	private List<String> possibleAnswers;
	
	//we are using a varargs parameter so that multiple choice questions can have an arbitrary number of potential answers
	//see https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html for more info on varargs
	public MultipleChoiceQuestion(String question, int correctAnswer, String... answers) {
		super(question);
		this.answer = correctAnswer;
		
		possibleAnswers = Arrays.asList(answers);
	}
	
	public int getAnswer() {
		return answer;
	}
	
	public List<String> getPossibleAnswers() {
		return possibleAnswers;
	}
}
