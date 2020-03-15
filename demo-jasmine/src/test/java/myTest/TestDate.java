package myTest;

import com.example.jasmine.demo.entity.Person;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demo-jasmine
 * @description: ${description}
 * @author: libingyao
 * @create: 2019-06-14 14:05
 **/
public class TestDate {
    @Test
    public void test() throws ParseException {
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        System.out.println("周几："+(calendar.get(Calendar.DAY_OF_WEEK)-1));

        List<Person> list = Lists.newArrayList(
                new Person("1","abc",1),
                new Person("4","abc",4),
                new Person("2","abc",2),
                new Person("6","abc",6),
                new Person("3","abc",3)
         );

        List<Person> result = list.stream().sorted((a, b) -> a.getNumber() - b.getNumber()).collect(Collectors.toList());
        result.stream().forEach(System.out::println);


    }
}
