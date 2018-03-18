package controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	//BindingResult一定要紧跟在@Validated Bean后面
	public AjaxModel addComputer(@RequestBody @Validated Computer computer, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println(result.getFieldError().getDefaultMessage());
		}
		
/*		System.out.println(computer.getTradeMark());
		System.out.println(computer.getPrice());*/
		
		/*
		 * 进行add computer操作
		 * 。。。。。。。。。。。
		 * */
		
		AjaxModel am = new AjaxModel(200, "computer added successfully!");
		
		return am;
	}
}
