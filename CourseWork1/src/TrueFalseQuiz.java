import java.util.ArrayList;

public class TrueFalseQuiz extends BaseQuiz {

    private ArrayList<Question> allQuestions;

    public TrueFalseQuiz() {
        super();
        allQuestions = populateList();
    }

    protected ArrayList<Question> populateList() {
        ArrayList<Question> list = new ArrayList<Question>();

        TrueFalseQuestion q1 = new TrueFalseQuestion("Java is case sensitive", true);
        TrueFalseQuestion q2 = new TrueFalseQuestion("In Java all primitive variables start with a lower case letter;", true);
        TrueFalseQuestion q3 = new TrueFalseQuestion("The following expression type checks: Integer.parseInt(\"5\");", true);
        TrueFalseQuestion q4 = new TrueFalseQuestion("The following expression type checks: \"elf\".compareTo(\"dwarf\");", true);
        TrueFalseQuestion q5 = new TrueFalseQuestion("The following expression type checks: \"elf\".compareTo(7);", false);
        TrueFalseQuestion q6 = new TrueFalseQuestion("The following expression type checks: int x = \"elf\".compareTo(\"7\")+11;", true);
        TrueFalseQuestion q7 = new TrueFalseQuestion("The following expression type checks: Integer.parseInt(888,16);", false);
        TrueFalseQuestion q8 = new TrueFalseQuestion("The following expression type checks: Math.abs(\"wizard\".compareTo(\"witch\"));", true);
        TrueFalseQuestion q9 = new TrueFalseQuestion("Static methods can be run before an instance of the class is made;", true);
        TrueFalseQuestion q10 = new TrueFalseQuestion("Static methods can operate on instance variables;", false);
        TrueFalseQuestion q11 = new TrueFalseQuestion("Static variables hold the same value for every instance of the class;", true);
        TrueFalseQuestion q12 = new TrueFalseQuestion("Instance variables hold the same value for every instance of the class;", false);
        TrueFalseQuestion q13 = new TrueFalseQuestion("Static methods are often used for utility methods;", true);

        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        list.add(q5);
        list.add(q6);
        list.add(q7);
        list.add(q8);
        list.add(q9);
        list.add(q10);
        list.add(q11);
        list.add(q12);
        list.add(q13);

        return list;
    }

    protected boolean isValidAnswer(Question question, String answer) {

        ArrayList <String> valid = new ArrayList<String>();
        valid.add("t");
        valid.add("true");
        valid.add("f");
        valid.add("false");

        return valid.contains(answer);

    }

    protected boolean isCorrectAnswer(Question question, String answer) {
        //cast to TrueFalseQuestion and find correct answer
        TrueFalseQuestion tfq = (TrueFalseQuestion) question;
        boolean correctAns = tfq.getAnswer();

        boolean output = false;

        switch (answer) {
            case "t":
                output = (correctAns);
                break;

            case "true":
                output = (correctAns);
                break;

            case "f":
                output = (!correctAns);
                break;

            case "false":
                output = (!correctAns);
                break;
        }

        return output;
    }

    protected String invalidInput(Question question) {
        //error message for wrong input and show possible inputs
        return "Your answer needs to be one of these: [t, f, true, false]";
    }

    protected int getQuizSize() {
        return allQuestions.size();
    }

    protected ArrayList<Question> getQuestions() {
        return allQuestions;
    }

    protected String getQuestionPrefix(Question question) {
        return "True of false?";
    }

    protected String getQuestionSuffix(Question question) {
        return "";
    }

    public static void main(String[] args) {
        TrueFalseQuiz quiz = new TrueFalseQuiz();
        quiz.quiz();
    }
}
