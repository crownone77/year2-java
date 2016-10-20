/**
 * Created by Steven on 10/20/2016.
 */
public class Ant {
    protected int height, age;

    public Ant(int h, int a){
        height = h;
        age = a;
    }

    public int getHeight(){
        return height;
    }

    public int getAge(){
        return age;
    }

    public Ant copyme(){
        Ant b = new Ant(height, age);
        return b;
    }

    public boolean equals(Ant a){
        if (a.getHeight() == height && a.getAge() == age){
            return true;
        }else{
            return false;
        }
    }


}
