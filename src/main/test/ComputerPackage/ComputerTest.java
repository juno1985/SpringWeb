package ComputerPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.softcits.pc.mapper.MbgCommentMapper;
import org.softcits.pc.mapper.MbgComputerMapper;
import org.softcits.pc.model.MbgComment;
import org.softcits.pc.model.MbgCommentExample;
import org.softcits.pc.model.MbgComputer;
import org.softcits.pc.model.MbgComputerExample;
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
	
	@Autowired
	MbgComputerMapper mbgComputerMapper; 
	
	@Autowired
	MbgCommentMapper mbgCommentMapper;
	
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
	
	//mybatis逆向工程
	@Test
	public void testMbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(".\\src\\main\\resources\\mgb.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	@Test
	public void testSelectMyBatisGenerator() {
		MbgComputerExample computerExa = new MbgComputerExample();
		MbgComputerExample.Criteria computerCri = computerExa.createCriteria();
		//查詢id是1的
		computerCri.andIdEqualTo(1);
		
		List<MbgComputer> mbgComList = mbgComputerMapper.selectByExample(computerExa);
		for(MbgComputer mbgC : mbgComList)
		{
			System.out.println(mbgC.getTrademark());
		}
	
	}
	
	@Test
	public void testSelectMutiByIdMyBatisGenerator() {
		MbgComputerExample computerExa = new MbgComputerExample();
		MbgComputerExample.Criteria computerCri = computerExa.createCriteria();
		//查詢價格在1000~5000之間
		computerCri.andPriceBetween(1000.00f, 5000.00f);
		
		List<MbgComputer> mbgComList = mbgComputerMapper.selectByExample(computerExa);
		for(MbgComputer mbgC : mbgComList)
		{
			System.out.println(mbgC.getTrademark() + ' ' + mbgC.getPrice());
		}
	}
	
	@Test
	public void testSelectMutiTableMyBatisGenerator() {
		MbgComputerExample computerExa = new MbgComputerExample();
		MbgComputerExample.Criteria computerCri = computerExa.createCriteria();
		//查詢id是1的
		computerCri.andIdEqualTo(1);
		
		List<MbgComputer> mbgComList = mbgComputerMapper.selectByExample(computerExa);
		
		MbgComputer mgbComputer = mbgComList.get(0);
		
		Integer cid = mgbComputer.getId();
		
		MbgCommentExample commentExa = new MbgCommentExample();
		MbgCommentExample.Criteria commentCri = commentExa.createCriteria();
		
		commentCri.andFkEqualTo(1);
		
		List<MbgComment> mbgCommentList = mbgCommentMapper.selectByExample(commentExa);
		
		for(MbgComment mbgC : mbgCommentList) {
			System.out.println(mbgC.getPcComment());
		}
	}

}
