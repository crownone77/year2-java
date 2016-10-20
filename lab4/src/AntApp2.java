/**
 * Created by Steven on 10/20/2016.
 */
public class AntApp2 {
    public static void main(String[] args) {
        Ant ant1 = new Ant(15, 5);

        increaseHeight1(ant1);
        System.out.println(ant1.getHeight());

        increaseHeight2(ant1.getHeight());
        System.out.println(ant1.getHeight());
    }

    public static void increaseHeight1(Ant a){
        int h = a.getHeight();
        h += 5;
        a.height = h;
    }

    public static void increaseHeight2 (int height){
        height++;
    }
}
