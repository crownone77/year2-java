import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentServerEngine {
    private List<Student> students;

    public StudentServerEngine(List<Student> students) {
        this.students = students;
    }

    public String getAvailableCommands() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", "SHOW ALL		show all student results"));
        sb.append(String.format("%s%n", "SORT EXAM		sort student results by exam mark"));
        sb.append(String.format("%s%n", "SORT CWK		sort student results by coursework mark"));
        sb.append(String.format("%s%n", "SORT GRADE		sort student results by grade"));
        sb.append(String.format("%s%n", "SORT TOTAL		sort student results by total (final) mark"));
        sb.append(String.format("%s%n", "GRADE <grade>	show all students that achieved a grade of <grade>"));
        sb.append(String.format("%s%n", "SEARCH <name>	show all students that have <term> in their name"));
        sb.append(String.format("%s%n", "SHOW HELP		show this help"));
        return sb.toString();
    }

    public String parseCommand(String command) {
        //each command has an instruction and an argument. split the incoming string on the first whitespace character (or whitespace characterS if they are contiguous)
        String[] words = command.split("\\s+", 2);
        if (words.length < 2) {
            return "Syntax: <command> <argument>.";
        }

        //make both strings lower case and trim any excess whitespace to make comparisons easier
        String instruction = words[0].toLowerCase().trim();
        String argument = words[1].toLowerCase().trim();

        switch (instruction) {
            case "show":
                return show(argument);
            case "search":
                return search(argument);
            case "sort":
                return sort(argument);
            case "grade":
                return grade(argument);
            default: //everything that isn't a known command
                return "I don't understand '" + instruction + "'.";
        }
    }

    private String sort(String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "cwk":		return sortByCoursework();
            case "total":	return sortByTotal();
            case "exam":	return sortByExam();
            case "grade":	return sortByGrade();

            default: 			return "I don't know how to sort by that!";
        }
    }

    private String sortByExam() {
        List<Student> sorted = new ArrayList<Student>(students);

        Collections.sort(sorted, new ExamComparator());

        return buildResult(sorted);
    }

    private String sortByTotal() {
        List<Student> sorted = new ArrayList<Student>(students);

        Collections.sort(sorted, new TotalComparator());

        return buildResult(sorted);
    }

    private String sortByCoursework() {
        List<Student> sorted = new ArrayList<Student>(students);

        Collections.sort(sorted, new CourseworkComparator());

        return buildResult(sorted);
    }

    private String sortByGrade() {
        List<Student> sorted = new ArrayList<Student>(students);

        Collections.sort(sorted, new GradeComparator());

        return buildResult(sorted);
    }

    private String grade(String grade) {
        grade = grade.toUpperCase();

        List<Student> result = new ArrayList<Student>();
        for (Student s : students) {
            if (s.getGrade().equals(grade)) {
                result.add(s);
            }
        }

        if (result.size() != 0) {
            return buildResult(result);
        } else {
            return String.format("%s%n", "no results found");
        }
    }

    private String search(String searchTerm) {
        String term = searchTerm.toLowerCase();
        List<Student> result = new ArrayList<Student>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(term)) {
                result.add(s);
            }
        }

        if (result.size() != 0) {
            return buildResult(result);
        } else {
            return String.format("%s%n", "no results found");
        }
    }

    private String show(String command) {
        switch (command.toLowerCase()) {
            case "help":		return getAvailableCommands();
            case "all":			return getAll();

            default: 			return "I don't know how to show that!";
        }
    }

    private String getAll() {
        return buildResult(students);
    }

    private String buildResult(List<Student> _students) {
        StringBuilder sb = new StringBuilder();
        for (Student b : _students) {
            sb.append(String.format("%s%n", b));
        }

        return sb.toString();
    }
}
