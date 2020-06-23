package com.cc.common.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2020/6/9 17:46
 * Description:
 */
public class MeaningOfThis {
    public final int value = 4;


    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
        System.out.println(this.value);
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
        List<Student> list = Arrays.asList(new Student("cc", 0));
        List<Student> list1 = new ArrayList<>();
        Predicate<Student> p = s -> list1.add(s);
        Consumer<Student> c = s -> list1.add(s);
        System.out.println(p.test(new Student("tt", 10)));
        c.accept(new Student("tc", 15));
        System.out.println(JSON.toJSONString(list1));
        a(list, (Student s) -> s.age == 0);
    }

    public static void a(List list, Predicate<Student> p){
        Object c = list.get(0);
        System.out.println(p.test((Student) c));
    }

   public static class Student{
        private String name;
        private Integer age;

       public Student(String name, Integer age) {
           this.name = name;
           this.age = age;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Integer getAge() {
           return age;
       }

       public void setAge(Integer age) {
           this.age = age;
       }
   }

}
