package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Computer;

@Controller
@RequestMapping("/computer")
public class ComputerController {

	private Map<Integer, Computer> computerList = new HashMap<Integer, Computer>();
	public ComputerController() {
		computerList.put(1, new Computer(1, "lenovo电脑", 5000));
		computerList.put(2, new Computer(2, "dell电脑", 2000));
		computerList.put(3, new Computer(3, "hp电脑", 4000));
		computerList.put(4, new Computer(4, "axus电脑", 3000));
		computerList.put(5, new Computer(5, "sumsung电脑", 7000));
		computerList.put(6, new Computer(6, "mi电脑", 6000));
		computerList.put(7, new Computer(7, "mac电脑", 12000));
	}

	@RequestMapping(path="list",method = RequestMethod.GET)
	public String listComputers(Model model){
		model.addAttribute("comList", computerList);
		return "comList";
	}
	
	@RequestMapping(path="delete/{id}",method = RequestMethod.GET)
	public String deleteComputer(@PathVariable String id, Model model){
		
		System.out.println("----->"+id);
		
		computerList.remove(Integer.parseInt(id));
		
		return "redirect:/computer/list";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String goComputerView(){
		return "comAdd";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String addComputer(@RequestParam String tradeMark, 
				@RequestParam String price){
		
		System.out.println(tradeMark + "  " + price);
		
		int index = computerList.size();
		
		Computer computer = new Computer(index+1, tradeMark, Integer.parseInt(price));
		
		computerList.put(index+1, computer);
		
		return "redirect:/computer/list";
	}
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.GET)
	public String updateComputerView(@PathVariable String id, Model model){
		Computer computer = computerList.get(Integer.parseInt(id));
		
	/*	System.out.println(computer);*/
		
		model.addAttribute("comp", computer);
		return "comUpdate";
	}
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.POST)
	public String updateComputer(@PathVariable String id, @RequestParam String tradeMark, @RequestParam String price){
		
		System.out.println("id: "+id+" tradeMark: "+tradeMark+" price: "+price);
		
		Integer comId = Integer.parseInt(id);
		
		Computer computer = new Computer(comId, tradeMark, Integer.parseInt(price));
		
		computerList.put(comId, computer);
		
		return "redirect:/computer/list";
	}
	
	@RequestMapping(path="/add2", method = RequestMethod.GET)
	public String goComputerView2(){
		return "comAdd2";
	}
	
}
