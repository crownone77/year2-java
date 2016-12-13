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

        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion)question;

        //to check whether answer is an integer
        int userAns;
        try{
            userAns = Integer.parseInt(answer);
        } catch (NumberFormatException e){
            userAns = 0;
        }

        //check whether its an integer that's in the range of the possible answers
        return (userAns > 0 && userAns <= mcq.getPossibleAnswers().size());
	}

	protected boolean isCorrectAnswer(Question question, String answer) {

        //cast to multiple choice question and check if is correct answer
        MultipleChoiceQuestion q = (MultipleChoiceQuestion)question;
        return (Integer.parseInt(answer) == q.getAnswer());
	}

	protected String invalidInput(Question question) {

        //error message for wrong input and show possible inputs
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion)question;
        int numAns = mcq.getPossibleAnswers().size();
        return "Your answer needs to be an integer between 1 - "+numAns+": ";
	}

	protected int getQuizSize() {
        System.out.println(allQuestions.size());
        return allQuestions.size();
	}

	protected ArrayList<Question> getQuestions() {
        return allQuestions;
	}

	protected String getQuestionPrefix(Question question) {

        //show number of possible answers
	    MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
        return "QUESTION ("+mcq.getPossibleAnswers().size()+" possible answers):";
	}

	protected String getQuestionSuffix(Question question) {

        //cast for multiple choice question
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
        List possibleAns = mcq.getPossibleAnswers();

	    String output = "\n";

	    //go through list of possible answers and add to final output
        for(int i = 0; i < possibleAns.size(); i++){
            Object ans = possibleAns.get(i);
            output += (i+1) + ". " + ans + "\n";
        }
        output += "Enter a number> ";

        return output;
	}

	public static void main(String[] args) {
		MultipleChoiceQuiz quiz = new MultipleChoiceQuiz();
		quiz.quiz();
	}
}
