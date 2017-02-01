package partB;

import java.util.Comparator;

class TotalComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return b.getTotal() - a.getTotal();
	}
}