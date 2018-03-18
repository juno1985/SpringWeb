package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ComputerMapper;
import model.Computer;
import pojo.ComputerPojo;
@Service
public class ComputerService {

	@Autowired
	private ComputerMapper computerMapper;
	
	public void addComputer(Computer computer){
		/**
		 * 连接数据库完成添加computer操作
		 */
		
		System.out.println("业务层进行添加Computer-->" + computer.toString());
	}
	
	public List<ComputerPojo> getAllComputerPojo(){
		
		List<ComputerPojo> comList = computerMapper.getAllComputers();
		
		return comList;
	}
}
