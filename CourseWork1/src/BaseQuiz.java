import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class BaseQuiz {
	private Scanner in;

	public BaseQuiz() {
		in = new Scanner(System.in);
	}

	public void quiz() {
		int numberOfQuestions = getQuizSize();
		ArrayList<Question> quizQuestions = getRandomQuestions(getQuestions(), numberOfQuestions);

		printGreeting(numberOfQuestions);
		ArrayList<Boolean> answers = askQuestions(quizQuestions);

		printResults(answers);
	}

	protected void printGreeting(int numberOfQuestions) {
		System.out.format("This quiz has %d questions. Good luck.%n", numberOfQuestions);
	}

	private static ArrayList<Question> getRandomQuestions(ArrayList<Question> questions, int amount) {
		if (amount > questions.size()) {
			throw new RuntimeException("A Quiz cannot have more random questions than there are questions to choose from (" + amount + " > " + questions.size() + ")");
		}
		Random r = new Random();
		ArrayList<Question> quizQuestions = new ArrayList<Question>();

		//get random questions, making sure there are no duplicates
		Question q;
		int index;
		while (quizQuestions.size() != amount) {
			index = r.nextInt(questions.size());
			q = questions.get(index);
			if(!quizQuestions.contains(q)) {
				quizQuestions.add(q);
			}
		}

		return quizQuestions;
	}

	private ArrayList<Boolean> askQuestions(ArrayList<Question> theQuestions) {
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		for (Question q : theQuestions) {
			boolean correct = getAnswerFromUser(q);
			if (correct) {
				answers.add(true);
			} else {
				answers.add(false);
			}
		}

		return answers;
	}

	private boolean getAnswerFromUser(Question question) {
		String prefix = getQuestionPrefix(question);
		String suffix = getQuestionSuffix(question);
		System.out.print(prefix + " " + question.getQuestion() + " " + suffix);

		//make sure we receive a valid answer
		String answer;
		boolean answered;
		do {
			answer = in.nextLine();
			answered = isValidAnswer(question, answer);
			if (!answered) {
				System.out.print(invalidInput(question) + " ");
			}
		} while (!answered);

		return isCorrectAnswer(question, answer);
	}

	private void printResults(ArrayList<Boolean> answers) {
		int correct = howManyCorrect(answers);
		int total = answers.size();
		double percentage = correct*(100f/total);
		String msg = encouragingMessage(percentage);

		String output = String.format("You scored %d/%d. That's %.0f%%. %s", correct, total, percentage, msg);
		System.out.println(output);
	}

	protected String encouragingMessage(double percentage) {
		if (percentage < 0) return "How have you done that?!";

		if (percentage == 0) return "Well, it'll be hard to do much worse.";

		if (percentage > 0 && percentage <= 20) return "Don't give up.";

		if (percentage > 20 && percentage <= 40) return "You'll have better days.";

		if (percentage > 40 && percentage <= 60) return "Nice work.";

		if (percentage > 60 && percentage <= 80) return "Very good.";

		return "Excellent!";
	}

	private static int howManyCorrect(ArrayList<Boolean> answers) {
		int number = 0;
		for (Boolean b : answers) {
			if (b) {
				number++;
			}
		}
		return number;
	}

	protected abstract boolean isValidAnswer(Question question, String answer); //can the user's input be interpreted as an attempt to answer the question?
	protected abstract boolean isCorrectAnswer(Question question, String answer); //did the user answer the question correctly
	protected abstract String invalidInput(Question question); //what to say to the user if you don't know what to do with their input
	protected abstract int getQuizSize(); //the number of questions to ask per quiz
	protected abstract ArrayList<Question> getQuestions(); //all of the questions

	protected abstract String getQuestionPrefix(Question question); //Text to print before the question is printed to the screen
	protected abstract String getQuestionSuffix(Question question); //Text to print after the question is printed to the screen
}
