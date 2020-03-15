package myTest;

import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库连接书写
 *
 * @author libingyao
 * @create 2019-05-26-13:36
 */
public class CountTest {

    @Test
    public void test() throws ParseException {


    }

      void count(String str){

        char[] chars = str.toCharArray();

        Map<Character,Integer> hm = new HashMap<Character,Integer>();


        for(char c : chars){

            if(!hm.containsKey(c)){
                hm.put(c,1);
            }else{

                hm.put(c, hm.get(c)+1);
            }
        }
        //List list=new ArrayList();
        for(Character key: hm.keySet()){

            System.out.println(key + "====" + hm.get(key));
            //list.
        }
       // for()
    }
}