/**
 * Created by steven on 14/12/16.
 */
public class TrueFalseQuestion extends Question{

    private boolean answer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        super(question);
        answer = correctAnswer;
    }

    public boolean getAnswer(){
        return answer;
    }
}
