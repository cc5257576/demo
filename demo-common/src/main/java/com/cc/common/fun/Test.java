package com.cc.common.fun;

import com.cc.common.util.ObjectUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/11 10:56
 * Description:
 */
public class Test {

    public static void main(String[] args) {
//        Predicate<String> predicate = (s) -> s.length() > 0;
//        Predicate<String> predicate2 = (s) -> s.trim().length() > 0;
//        Predicate<String> predicate3 = (s) -> s.contains("c");
//        System.out.println(predicate.test("foo"));
//        System.out.println(predicate.and(predicate2).and(predicate3).test("  c"));
//
//        Map map = new HashMap();
//        map.putIfAbsent(3, "val" + 3);
//        map.computeIfPresent(3, (num, val) -> val.toString() + num);
//        System.out.println(map.get(3));
        FileFilter fileFilter = (f) -> f.isHidden();
        FilenameFilter filenameFilter = (f, n) -> {
            return f.equals(n);
        };
        File[] files = new File(",").listFiles(File::equals);

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1552379579043
        Instant instant = clock.instant();
        System.out.println(instant);  //2019-03-12T08:46:42.588Z
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);//Tue Mar 12 16:32:59 CST 2019
        a(Test::isTest);
        TestInt c = (String b) -> System.out.println(b);
        c.out("dfdsf");
        System.out.println();
    }

    public static boolean isTest(Test test){
        return ObjectUtil.isNotEmpty(test) ? true : false;
    }

    public static boolean a(Predicate<Test> t){
        return t.test(new Test());
    }
}
