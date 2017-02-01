package partA;

import java.io.*;
import java.util.*;

public class TextQuestionUtils {

	/**
	 * Serialize List of Question objects to a file.
	 * handles IOException if an I/O error occurs
	*/
	public static boolean serializeToFile(String filename, List<TextQuestion> questions) {
		//some statements missing here
	}




	/**
	 * Read in and return a List of Question objects that has been serialized to a file.
	 *
	 * handles FileNotFoundException if the file to read from does not exist
	 * handles ClassNotFoundException if the class of the serialized object cannot be found
	 * handles IOException if an I/O error occurs
	 */
	public static List<TextQuestion> deserializeFromFile(String filename) {
		//some statements missing here
	}






		//if the file to read from does not exist, return an empty list
		public static List<TextQuestion> readFromFile(String filename) {
			List<TextQuestion> qns = new ArrayList<TextQuestion>();
			try {
				File myFile = new File(filename);
				FileReader fileReader = new FileReader(myFile);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = null;

				while((line = reader.readLine()) !=null) {
					TextQuestion q = parseQuestion(line);
					if (q != null) qns.add(q);
				}
				reader.close();
			}
			catch (IOException e) {
				return qns; //if the file doesn't exist, return an empty list
			}
			return qns;
	}




	//method to be used by the readFromFile(String) method in order to parse a String to a Question object
	//return null if '? ' not found in the String
	private static TextQuestion parseQuestion(String line) {
		//some statements missing here
	}




	//writes to a file using the file name given by the user.
	//Handles exceptions.
	//Uses UTF-8 encoding.
	//Uses BufferedWriter
	public static boolean writeToFile(String filename, List<TextQuestion> questions) {
		//some statements missing here
	}

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		List<TextQuestion> qs = TextQuestionUtils.readFromFile("testquestions.txt");

		System.out.println("/******* parsed from text file testquestions.txt *******/");
		for (TextQuestion q : qs) System.out.println(q.getQuestion() + " " + q.getAnswer());
		System.out.println();

		TextQuestionUtils.writeToFile("copy_of_testquestions.txt", qs);

		List<TextQuestion> qs2 = TextQuestionUtils.readFromFile("copy_of_testquestions.txt");

		System.out.println("/******* parsed from text file written by TextQuestionUtils.writeToFile() *******/");
		for (TextQuestion q2 : qs2) System.out.println(q2.getQuestion() + " " + q2.getAnswer());
		System.out.println();

		//possible to serialise as ArrayList and deserialise as List? yes
		ArrayList<TextQuestion> qs3 = new ArrayList<TextQuestion>(qs);
		TextQuestionUtils.serializeToFile("questions.ser", qs3);

		List<TextQuestion> qs4 = TextQuestionUtils.deserializeFromFile("questions.ser");
		System.out.println("/******* deserialised from a file *******/");
		for (TextQuestion q4 : qs4) System.out.println(q4.getQuestion() + " " + q4.getAnswer());
		System.out.println();
	}
}
