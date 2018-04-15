package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import MyException.PCFormException;
import common.UUIDUtil;
import mapper.ComputerMapper;
import model.AjaxModel;
import model.Computer;
import pojo.ComputerPojo;
@Service
public class ComputerService {

	@Autowired
	private ComputerMapper computerMapper;
	
	public String addComputer(Computer computer){
		return "success";
	}
	
	public String addComputer(String tradeMark, String price, MultipartFile multipartFile, String realPath) throws IOException{
		ComputerPojo computerPojo = new ComputerPojo();
		computerPojo.setPrice(Float.parseFloat(price));
		computerPojo.setTradeMark(tradeMark);
		
		//判断上传文件是否为空
		if(!multipartFile.isEmpty()){
			//得到上传文件名
			String fileName = multipartFile.getOriginalFilename();
			
			//得到上传文件的扩展名
			String fileExt = FilenameUtils.getExtension(fileName);
			
			//生成新的文件名,避免上传文名重复从而发生覆盖
			String newFileName = UUIDUtil.UUIDGenerator() + '.' + fileExt;
			
			//创建本地实体文件
			//F:\git-repo\SpringWeb\src\main\webapp\resources\pic + "\" + "Logo.png" 
			File file = new File(realPath + "\\" + newFileName);
			
			//实现文件的上传拷贝
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
			
			computerPojo.setPic(newFileName);
		}
		
		computerMapper.insertComputer(computerPojo);
		
		return "success";
		
	}
	
	public List<ComputerPojo> getAllComputerPojo(){
		
		List<ComputerPojo> comList = computerMapper.getAllComputers();
		
		return comList;
	}
	
	public ComputerPojo getComputer(String cid){
		ComputerPojo computerPojo = computerMapper.getById(Integer.parseInt(cid));
		return computerPojo;
	}
	
	public void deletePC() {
		ComputerPojo comPojo = computerMapper.selectComputer("小新电脑");
		System.out.println(comPojo);
		computerMapper.deleteComputer(comPojo.getCid());
		
		/*模仿程序发生某种位置错误*/
		try {
			throw new PCFormException("程序发生了异常!");
			
			}
		catch(PCFormException pe){
			pe.printStackTrace();
		}
		
		comPojo.setPrice(7777.00f);
		computerMapper.insertComputer(comPojo);
	}
}
