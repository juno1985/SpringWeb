package ComputerPackage;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.ComputerMapper;
import pojo.ComputerPojo;
import service.ComputerService;
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring的配置文件和mybatis的配置文件
@ContextConfiguration({"classpath:/spring/spring.xml",
		"classpath:/spring/spring-mybatis.xml"})
public class ComputerTest {

	@Autowired
	private ComputerService computerService;
	
	@Autowired ComputerMapper computerMapper;
	
	@Test
	public void testGetAllComputerPojo(){
		List<ComputerPojo> comList = computerService.getAllComputerPojo();
		System.out.println(comList);
	}
	
	@Test
	public void testGetById(){
		
		ComputerPojo comPojo = computerMapper.getById(1);
		
		System.out.println(comPojo);
	}
	
	@Test
	public void testGetByIdAndTradeMark(){
		ComputerPojo comPojo = computerMapper.getByIdAndTradeMark(1, "hp%");
		System.out.println(comPojo);
	}
	
	@Test
	public void testGetByIdAndTradeMarkUsingParamMap(){
		ComputerPojo comPojo = computerMapper.getByIdAndTradeMark(1, "hp%");
		System.out.println(comPojo);
	}
	
	@Test
	public void testGetByPojo(){
		ComputerPojo computerPojo = new ComputerPojo();
		computerPojo.setCid(1);
		computerPojo.setTradeMark("hp%");
		System.out.println(computerMapper.getByPojo(computerPojo));
	}
	

}
