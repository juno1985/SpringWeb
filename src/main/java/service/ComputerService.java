package service;

import org.springframework.stereotype.Service;

import model.Computer;

@Service
public class ComputerService {

	public void addComputer(Computer computer){
		/**
		 * 连接数据库完成添加computer操作
		 */
		
		System.out.println("业务层进行添加Computer-->" + computer.toString());
	}
}
