/**
 * Created by Steven on 10/20/2016.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "Apple";

        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        String str3 = new String("Apple");
        String str4 = new String("Apple");

        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));


        //when comparing string values, should use equals()
    }
}
