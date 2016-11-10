package Task2;

/**
 * Created by Steven on 10/11/2016.
 */
public class EnhancedLoop {
    public static void main(String[] args) {
        String [] strArr = new String[50];

        strArr[0] = "GERMANY";
        strArr[1] = "RUSSIA";
        strArr[2] = "JAPAN";
        strArr[3] = "KOREA";
        strArr[4] = "UNITEDSTATESOFAMERICA";
        strArr[5] = "AUSTRIA";

        for (String e : strArr){

            if (e.length() > 5){
                System.out.println(e);
            }

            if (e.equals("AUSTRIA")){
                break;
            }
        }
    }
}

/*
null exception pointer because there is no condition to stop the loop and the other 'spaces' have null in them thus cannot get the length
 */