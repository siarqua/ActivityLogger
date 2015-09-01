package org.some.pkg.service.restclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.some.pkg.entity.Activity;
import org.some.pkg.service.interfaces.Client;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz Zapal (lukasz.zapal@nokia.com) on 8/11/2015.
 */
public class ActivityClient implements Client<Activity> {

	public static final String HOST = "http://localhost:8080/activities/api";
	private final RestTemplate restTemplate;

	public ActivityClient() {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		restTemplate = new RestTemplate(requestFactory);
	}

	public Activity get(Long id) {
		Map<String, String> params = prepareParameters(id);
		Activity activity = restTemplate.getForObject(HOST + "/{id}", Activity.class, params);
		return activity;
	}

	public Long post(Activity activity) {
        Long id = restTemplate.postForObject(HOST, activity, Long.class);
        System.out.println("id = " + Long.valueOf(id));
        return id;
	}

	public void put(Long id, Activity activity) {
		Map<String, String> params = prepareParameters(id);
		restTemplate.put(HOST + "/{id}", activity, params);
	}

	public void delete(Long id){
		Map<String, String> params = prepareParameters(id);
		restTemplate.delete(HOST, params);
	}

	private Map<String, String> prepareParameters(Long id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(id));
		return params;
	}
}
