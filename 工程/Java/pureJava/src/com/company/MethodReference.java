package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
    public class InnerClass{

    }

    static public class Person {
        private int age;
        private String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    static public class PersonComparator implements Comparator<Person>{
        public int compare(Person o1, Person o2) {
            return o1.age > o2.age ? -1 : 1;
        }
    }

    public static void main(String[] args){
        Person person1 = new Person(1,"feng1");
        Person person2 = new Person(2,"feng2");
        Person person3 = new Person(3,"feng3");
        Person person4 = new Person(4,"feng4");
        Person person5 = new Person(5,"feng5");

        List<Person> personList = new ArrayList<Person>();
        personList.add(person3);
        personList.add(person1);
        personList.add(person2);
        personList.add(person5);
        personList.add(person4);

//        personList.sort(new PersonComparator()); //通过内部类实现排序
//        PersonComparator comparator = new PersonComparator();
//        personList.sort(comparator::compare); //通过函数引用实现排序
        personList.sort((o1,o2)->{return o1.age > o2.age ? -1 : 1;});   //通过lambda表达式实现
//        personList.sort(String::replaceAll);
        for (Person person : personList){
            System.out.println(person.name);
        }
    }
}
