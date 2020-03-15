package com.yyx.jasmine.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 24166
 *
 */
@SpringBootApplication
/*//开启缓存
@EnableCaching
//开启异步
@EnableAsync*/
public class DemoJasmineApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoJasmineApplication.class, args);
		
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        Date date = new Date();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	        String format = simpleDateFormat.format(date);
	        HttpGet httpGet = new HttpGet("http://www.easybots.cn/api/holiday.php?d="+format);
	        //---+"&ak=k459.c067409571eee28f585019d6e8eea6f3@yyxtech.com"

	        try {
	            CloseableHttpResponse response = httpclient.execute(httpGet);
	            HttpEntity entity = response.getEntity();
	            String s = EntityUtils.toString(response.getEntity());
	            System.out.print(s);
	            JSONObject jsonObject = (JSONObject) JSONObject.parse(s);
	            String o = (String) jsonObject.get(format);
	            System.out.println("结果："+o);
	            response.close();
	            httpclient.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
}
