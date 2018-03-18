package MyException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import model.AjaxModel;

@ControllerAdvice
public class MyFormExceptionHander {

	@ExceptionHandler(PCFormException.class)
	@ResponseBody
	public AjaxModel pcFormExpHandler(PCFormException pcFormException){
		System.out.println("捕获接到了PCFormException异常");
		System.out.println("异常信息为:" + pcFormException.getMessage());
		
		return new AjaxModel(500, pcFormException.getMessage());
		
	}
	
	@ExceptionHandler(MobileFormException.class)
	public void mobileFormExpHandler(MobileFormException mobileFormException){
		/*
		 * 
		 * 
		 * */
		
	}
	
}
