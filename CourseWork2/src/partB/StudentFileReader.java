package partB;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentFileReader {
	
	public static List<Student> read(String filename) {
		Scanner in = null;
		List<Student> clubs = new ArrayList<Student>();
		try {
			in = new Scanner(new FileReader(filename));
		} catch (IOException e) {
			System.err.println("File "+filename+"does not exist.");
		} 
		
		while(in.hasNextLine()) { //This will crash if the text file is malformed as we only check for the existence of 1 line in the text file before we try to read the next 3 lines
			String line1 = in.nextLine();
			String line2 = in.nextLine();
			String line3 = in.nextLine();
			Student s = parseStudent(line1, line2, line3);
			clubs.add(s);
		}
		in.close();
		return clubs;
	}
	
	private static Student parseStudent(String line1, String line2, String line3) {
		int exam = Integer.parseInt(line2);
		int coursework = Integer.parseInt(line3);
		return new Student(line1, exam, coursework);
	}
	
	public static void main(String[] args) {
		List<Student> students = StudentFileReader.read("marks.txt");
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
