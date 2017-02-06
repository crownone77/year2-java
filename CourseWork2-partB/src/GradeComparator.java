import java.util.Comparator;

/**
 * Created by steven on 6/2/17.
 */
public class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.getGrade().compareTo(b.getGrade());
    }
}
