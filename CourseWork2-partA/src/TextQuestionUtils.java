import java.io.*;
import java.util.*;

public class TextQuestionUtils {

    /**
     * Serialize List of Question objects to a file.
     * handles IOException if an I/O error occurs
     */
    public static boolean serializeToFile(String filename, List<TextQuestion> questions) {
        try{
            // Create FileOutputStream
            FileOutputStream fos = new FileOutputStream(filename);

            // Create ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Write the object
            oos.writeObject(questions);

            // Close the stream
            oos.close();

        // Catch IOException errors
        }catch (IOException i){

            // Prints the stack trace for easier debugging of exception
            i.printStackTrace();
            return false;
        }

        return true;
    }




    /**
     * Read in and return a List of Question objects that has been serialized to a file.
     *
     * handles FileNotFoundException if the file to read from does not exist
     * handles ClassNotFoundException if the class of the serialized object cannot be found
     * handles IOException if an I/O error occurs
     */
    public static List<TextQuestion> deserializeFromFile(String filename) {
        // Initialise empty object
        
        FileInputStream fis = null;
        // Create FileInputStream
        try{
            fis = new FileInputStream(filename);

        // Catch FileNotFoundException
        }catch(FileNotFoundException f){

            // Print the stack trace for easier debugging
            f.printStackTrace();
        }

        ObjectInputStream ois = null;
        Object object = null;

        try{
            // Create ObjectInputStream
            ois = new ObjectInputStream(fis);

            // Read the object
            object = ois.readObject();

        // Catch IOException errors
        }catch(IOException i){

            // Prints the stack trace for easier debugging
            i.printStackTrace();
        }catch(ClassNotFoundException c){

            // Prints the stack trace for easier debugging
            c.printStackTrace();
        }

        // Return casted object
        return (List<TextQuestion>) object;
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

        // Check if "?" is found in line
        // If "?" found, continue
        if (line.contains("? ")){

            // Split line to an array
            String[] stringArr = line.split("\\? ");

            // Assign question and answer to their own variables
            String question = stringArr[0] + "?";
            String answer = stringArr[1];

            // Initialise a TextQuestion and return it
            TextQuestion tq = new TextQuestion(question, answer);
            return tq;

        // If "? " is not found, return null
        }else{
            return null;
        }
    }




    //writes to a file using the file name given by the user.
    //Handles exceptions.
    //Uses UTF-8 encoding.
    //Uses BufferedWriter
    public static boolean writeToFile(String filename, List<TextQuestion> questions) {

        try{
            FileOutputStream fos = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            for (TextQuestion writeThis : questions){
                bw.write(writeThis.getQuestion().toString() + " " + writeThis.getAnswer().toString() + "\n");
            }

            bw.close();
            osw.close();


        }catch (IOException i){
            i.printStackTrace();
            return false;
        }

        return true;
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
