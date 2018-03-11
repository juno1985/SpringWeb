package controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.AjaxModel;
import model.Computer;

@RestController
@RequestMapping(path="/RESTComputer")
public class RestFullComputerController {

	@ResponseBody
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public AjaxModel addComputer(@RequestBody Computer computer){
		
		System.out.println(computer);
		
		/*
		 * 进行add computer操作
		 * 。。。。。。。。。。。
		 * */
		
		AjaxModel am = new AjaxModel(200, "computer added successfully!");
		
		return am;
	}
}
