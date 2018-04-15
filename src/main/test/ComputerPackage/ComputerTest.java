package ComputerPackage;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MyException.PCFormException;
import mapper.ComputerMapper;
import pojo.ComputerComment;
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
		ComputerPojo comPojo = computerMapper.getByIdAndTradeMark(1, "\"hp\"" + "or 1 = 1");
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
	
	@Test
	public void testGetAllComputersByTabName(){
		List<ComputerPojo> comList = computerMapper.getAllComputersByTabName("computer");
		System.out.println(comList);
	}
	
	@Test
	public void testInsertComputer(){
		ComputerPojo computerPojo = new ComputerPojo();
		computerPojo.setTradeMark("axus电脑");
		computerPojo.setPrice(8888.99f);
		//作业: 完成电脑添加功能,要求完成JSP/controller/service
		/**提示
		 * JSP:要有form传tradeMark/price/pic
		 * Controller:要得到来自JSP的参数
		 * Service:要调用ComputerMapper的insertComputer方法
		 * 最好使用异步,即页面jsp能收到添加成功或失败的返回
		 * 尝试引入BOOTSTRAP
		 */
		computerPojo.setPic("xxxxxxxx.png");
		computerMapper.insertComputer(computerPojo);
	}
	
	@Test
	public void testDeleteComputer(){
		computerMapper.deleteComputer(6);
	}
	
	@Test
	public void testUpdateComputerPrice(){
		ComputerPojo computerPojo = computerMapper.getById(3);
		computerPojo.setPrice(6666.66f);
		computerMapper.updateComputerPrice(computerPojo);
	}
	
	@Test
	public void deleteAndAddPC() {
		computerService.deletePC();
	}
	
	@Test
	public void getDynamicPC() {
		ComputerPojo comPojo = new ComputerPojo();
		
//		comPojo.setPrice(1200.01f);
		
		comPojo.setTradeMark("MAC电脑");
		
		System.out.println(computerMapper.getDynamicComputer(comPojo));
	}
	
	@Test
	public void updateDynamicPC() {
		ComputerPojo comPojo = computerMapper.getById(6);
		
		comPojo.setTradeMark("MAC Book");
		
		computerMapper.updateDynamicComputer(comPojo);
	}
	
	@Test
	public void getComputerCommentsById() {
		List<ComputerComment> CCs = computerMapper.getComputerCommentById(1);
		System.out.println(CCs);
	}

}
