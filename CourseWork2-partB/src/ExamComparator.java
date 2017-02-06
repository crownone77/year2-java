import java.util.Comparator;

/**
 * Created by steven on 6/2/17.
 */
public class ExamComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return b.getExam() - a.getExam();
    }
}
