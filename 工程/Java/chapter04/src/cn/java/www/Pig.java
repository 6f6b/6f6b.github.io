package cn.java.www;

import com.java.www.Animal;
import com.java.www.Dog;

public class Pig extends Animal {
    public static void main(String[] args) {


    }

    public void run(){
        System.out.println(this.protectedName);
        System.out.println(this.publicNmae);

        Pig pig = new Pig();
        System.out.println(pig.protectedName);
        System.out.println(pig.protectedName);
    }
}
