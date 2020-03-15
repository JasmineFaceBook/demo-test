package myTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class TestAll {

	@Test
	public void test() throws ParseException {

	   /* JSON parentsJson=new JSONObject();
	    JSONObject transitCityOneJson = new JSONObject();
        transitCityOneJson.put("parentName", "zhongguo人");
        System.out.println("是不是工作日："+getWorkDayFlag ("2018-05-07"));*/
        String dateStr = "1987-6-1 20:00:00";
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //  sdf.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));
        Date date = sdf.parse(dateStr);
        System.out.println(date);

    }



































	public String getWorkDayFlag (String time){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date=null;
		try {
			date = simpleDateFormat.parse(time);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String format = simpleDateFormat.format(date);
        System.out.print("time---:"+format+"--");
        HttpGet httpGet = new HttpGet("http://api.goseek.cn/Tools/holiday?date="+format
               );

        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            System.out.print("shide:"+s);
           // JSONObject jsonObject = (JSONObject) JSONObject.parse(s);

            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> m = mapper.readValue(s, Map.class);
            System.out.println("result:"+m.get("data"));
            String o = ""+m.get("data");
            response.close();
            httpclient.close();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

	}



}
