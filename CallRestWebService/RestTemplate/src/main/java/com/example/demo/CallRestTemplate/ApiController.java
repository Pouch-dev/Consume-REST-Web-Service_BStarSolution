package com.example.demo.CallRestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


@RestController
@RequestMapping("/consume-api")
public class ApiController {
	
	private static String url="http://localhost:9090/rest/";
	
	@GetMapping("/book")
	public ResponseEntity<List<Object>> getBook(){
		Object[] book = null;
		CloseableHttpClient client = createClient();
		HttpUriRequest httpRequest = buildGetRequest(url);
		try {
			try (CloseableHttpResponse response = client.execute(httpRequest)) {
				HttpEntity responseEntity = response.getEntity();
				String responseString = EntityUtils.toString(responseEntity);
				book = new Gson().fromJson(responseString, Object[].class);
			} catch (JsonSyntaxException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return ResponseEntity.ok().body(Arrays.asList(book)); 
	}
	
	private HttpUriRequest buildGetRequest(String url) {
		try {
			HttpGet req = new HttpGet(url);
			RequestConfig config = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000).build();
			req.setHeader("Content-type", "application/json;charset=utf-8");
			req.setHeader("Accept","application/json");
			req.setConfig(config);
			return req;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return null;
		}
	}
	
	private CloseableHttpClient createClient() {
		PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        pool.setDefaultMaxPerRoute(1);
        pool.setMaxTotal(1);
        final CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(pool).build();
        return httpclient;
	}
}
