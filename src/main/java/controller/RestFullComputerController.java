package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(path="comAddUseMybatis", method=RequestMethod.GET)
	public ModelAndView goAddPCView(){
		return new ModelAndView("comAddUseMybatis");
	}
	
	@RequestMapping(path="comAddUseMybatis", method=RequestMethod.POST)
	public ResponseEntity<String> addPC(@RequestParam String tradeMark, @RequestParam String price, @RequestParam("pic")MultipartFile multipartFile, HttpServletRequest req) throws IOException{
		
		//得到项目的根路径
		String realPath = req.getSession().getServletContext().getRealPath("/resources/pic");
		
		String result = computerService.addComputer(tradeMark, price, multipartFile, realPath);
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
}
