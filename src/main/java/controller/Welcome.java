package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Welcome extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("收到了客户端的请求");
		
		Map<String, String> username = new HashMap<>();
		username.put("uname", "MARK");
		
		return new ModelAndView("welcome",username);
	}

}
