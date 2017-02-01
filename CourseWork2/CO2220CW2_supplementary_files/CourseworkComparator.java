import java.util.Comparator;

class CourseworkComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return b.getCwk() - a.getCwk();
	}
}