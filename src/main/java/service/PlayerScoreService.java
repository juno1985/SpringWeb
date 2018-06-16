package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthread.FutureClient;

@Service
public class PlayerScoreService {

	@Autowired
	private FutureClient futureClient;

	public String getSortedResult() {

		String ajaxModel = futureClient.request();
		System.out.println(ajaxModel);
		return ajaxModel;

	}

}
