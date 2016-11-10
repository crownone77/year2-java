/**
 * Created by Steven on 10/20/2016.
 */
public class Yale extends Character implements GreetInterface{

    public void greet(Object obj){
        System.out.println("I am Yale. " + obj);
    }

    public void greet(String str){
        System.out.println("I am Yale. Good to see you! " + str);
    }
}
