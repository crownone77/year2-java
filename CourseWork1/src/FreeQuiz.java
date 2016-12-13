import java.util.ArrayList;

public class FreeQuiz extends BaseQuiz {

	private ArrayList<Question> allQuestions; //our single instance variable

	public FreeQuiz() {//constructor
		super();//call to superclass constructor
		allQuestions = populateList();//initialise instance variable allQuestions
	}


	//What to print if the user has given us a string that we can't use as an answer
	protected String invalidInput(Question question) {
		return "Your answer cannot be blank. Try again.";
	}

	//The number of questions to ask in the quiz
	protected int getQuizSize() {
		return 5;
	}

	//What to show just before the question
	protected String getQuestionPrefix(Question question) {
		return "QUESTION:";
	}

	//What to show after the question. We don't show anything as you can see.
	protected String getQuestionSuffix(Question question) {
		return "";
	}

	//How to detect an invalid answer
	protected boolean isValidAnswer(Question question, String answer) {
		return answer.length() > 0;
	}

	//Did the user answer the question correctly?
	protected boolean isCorrectAnswer(Question question, String answer) {
		FreeQuizQuestion q = (FreeQuizQuestion)question;//see section 9.4 of the subject guide for a discussion of ArrayLists and casting
		return q.getAnswer().equalsIgnoreCase(answer.trim());
	}

	protected ArrayList<Question> getQuestions() {
			return allQuestions;
	}

	//Return the full list of questions
	protected ArrayList<Question> populateList() {
		ArrayList<Question> list = new ArrayList<Question>();

		FreeQuizQuestion q1 = new FreeQuizQuestion("Name a primitive data type that starts with 'i'", "int");
		FreeQuizQuestion q2 = new FreeQuizQuestion("Name a primitive data type that starts with 'c'", "char");
		FreeQuizQuestion q3 = new FreeQuizQuestion("What is the value of the expression \"hello\".charAt(0) ?", "h");
		FreeQuizQuestion q4 = new FreeQuizQuestion("What is the value of the expression \"James\".charAt(\"James\".length() - 1) ?", "s");
		FreeQuizQuestion q5 = new FreeQuizQuestion("Type in the number of stars (asterisks) output by for(int i=10;i>0;i=i-1) System.out.print(\"*\");", "**********");
		FreeQuizQuestion q6 = new FreeQuizQuestion("Type in the number of stars (asterisks) output by for(int i=0;i<10;i=i+3) System.out.print(\"*\");", "****");
		FreeQuizQuestion q7 = new FreeQuizQuestion("Name a primitive data type that starts with 'b'", "boolean");

		list.add(q1);
		list.add(q2);
		list.add(q3);
		list.add(q4);
		list.add(q5);
		list.add(q6);
		list.add(q7);

		return list;
	}

	public static void main(String[] args) {
		FreeQuiz quiz = new FreeQuiz();
		quiz.quiz();
	}
}
