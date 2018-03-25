package ComputerPackage;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.ComputerPojo;
import service.ComputerService;
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring的配置文件和mybatis的配置文件
@ContextConfiguration({"classpath:/spring/spring.xml",
		"classpath:/spring/spring-mybatis.xml"})
public class ComputerTest {

	@Autowired
	private ComputerService computerService;
	
	@Test
	public void testGetAllComputerPojo(){
		List<ComputerPojo> comList = computerService.getAllComputerPojo();
		System.out.println(comList);
	}
}
