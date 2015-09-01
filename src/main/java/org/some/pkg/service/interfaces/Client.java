package org.some.pkg.service.interfaces;

import org.some.pkg.entity.Activity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz Zapal (lukasz.zapal@nokia.com) on 8/11/2015.
 */
public interface Client<T> {

	T get(Long id);
	Long post(T t);
	void put(Long id, T t);
	void delete(Long id);
}
