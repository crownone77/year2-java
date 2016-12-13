import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuiz extends BaseQuiz {

    private ArrayList<Question> allQuestions;

    public MultipleChoiceQuiz(){
        super();
        allQuestions = populateList();
    }

	protected ArrayList<Question> populateList() {
		ArrayList<Question> list = new ArrayList<Question>();

		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("What is the primitive data type that starts with 'i'?", 1, "int", "INT", "Int", "Integer");
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("What is the primitive data type that starts with 'c'?", 2, "Char", "char", "Character", "CHAR");
		MultipleChoiceQuestion q3 = new MultipleChoiceQuestion("What is the value of the expression \"hello\".charAt(0) ?", 3, "o", "l", "h", "e");
		MultipleChoiceQuestion q4 = new MultipleChoiceQuestion("What is the maximum value of the byte data type?", 3, "63", "64", "127", "128", "255", "256");
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("What is the minimum value of the byte data type?", 4, "-63", "-64", "-127", "-128", "-255", "-256");
		MultipleChoiceQuestion q6 = new MultipleChoiceQuestion("What is the value of the expression \"James\".charAt(\"James\".length() - 1) ?", 3, "no value, run-time error", "e", "s");

		list.add(q1);
		list.add(q2);
		list.add(q3);
		list.add(q4);
		list.add(q5);
		list.add(q6);

		return list;
	}

	protected boolean isValidAnswer(Question question, String answer) {
        return answer.length() > 0;
	}

	protected boolean isCorrectAnswer(Question question, String answer) {
        MultipleChoiceQuestion q = (MultipleChoiceQuestion)question;
        return (Integer.parseInt(answer) == q.getAnswer());
	}

	protected String invalidInput(Question question) {
        return "Your answer cannot be blank. Try again.";
	}

	protected int getQuizSize() {
        return 6;
	}

	protected ArrayList<Question> getQuestions() {
        return allQuestions;
	}

	protected String getQuestionPrefix(Question question) {
        return "QUESTION:";
	}

	protected String getQuestionSuffix(Question question) {

        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
        List possibleAns = mcq.getPossibleAnswers();kermm
        return "";
	}

	public static void main(String[] args) {
		MultipleChoiceQuiz quiz = new MultipleChoiceQuiz();
		quiz.quiz();
	}
}
