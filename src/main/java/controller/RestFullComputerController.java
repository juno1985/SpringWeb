package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MyException.PCFormException;
import model.AjaxModel;
import model.Computer;
import pojo.ComputerPojo;
import service.ComputerService;

@RestController
@RequestMapping(path="/RESTComputer")
public class RestFullComputerController {
	
	@Autowired
	private ComputerService computerService;

	@ResponseBody
	@RequestMapping(path="/add", method=RequestMethod.POST)
	//BindingResult一定要紧跟在@Validated Bean后面
	public AjaxModel addComputer(@RequestBody @Validated Computer computer, BindingResult result){
		
		if(result.hasErrors()){
			/*System.out.println(result.getFieldError().getDefaultMessage());*/
			throw new PCFormException(result.getFieldError().getDefaultMessage());
		}
		
/*		System.out.println(computer.getTradeMark());
		System.out.println(computer.getPrice());*/
		
		/*
		 * 进行add computer操作
		 * 。。。。。。。。。。。
		 * */
		
		computerService.addComputer(computer);
		
		AjaxModel am = new AjaxModel(200, "computer added successfully!");
		
		return am;
	}
	
	@RequestMapping(path="/getComPojos",method=RequestMethod.GET)
	@ResponseBody
	public List<ComputerPojo> getComputerPojos(){
		
		return computerService.getAllComputerPojo();
	}
}
