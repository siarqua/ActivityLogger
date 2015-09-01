package org.some.pkg.service.restclient;

import org.some.pkg.entity.Detail;
import org.some.pkg.service.interfaces.Client;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lukasz Zapal (lukasz.zapal@nokia.com) on 8/11/2015.
 */
public class DetailClient implements Client<Detail> {

	public static final String HOST = "http://localhost:8080/details/api";
	private final RestTemplate restTemplate;

	public DetailClient() {
		this.restTemplate = new RestTemplate();
	}

	public Detail get(Long id) {
		return null;
	}

	public Long post(Detail detail) {
		return null;
	}

	public void put(Long id, Detail detail) {

	}

	public void delete(Long id) {

	}
}
