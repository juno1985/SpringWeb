package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Mobile;

@Controller
@RequestMapping("/mobiles")
public class MobileController {
	private List<Mobile> mobileList = new ArrayList<Mobile>();
	
	public MobileController() {
		mobileList.add(new Mobile("华为手机", 4000));
		mobileList.add(new Mobile("小米手机", 1000));
		mobileList.add(new Mobile("苹果手机", 7000));
		mobileList.add(new Mobile("oppo手机", 2000));
		mobileList.add(new Mobile("vivo手机", 3000));
		mobileList.add(new Mobile("锤子手机", 1500));
	
	}

	@RequestMapping(path="/list",method = RequestMethod.GET)
	public String user(Model model){
		model.addAttribute("mList", this.mobileList);
		return "welcome";
	}
}
