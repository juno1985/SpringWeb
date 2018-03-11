package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/compUpload")
public class ComputerPicUploadController {
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String compUploadView(){
		
		return "comAddUploadPic";
	}
	

	@RequestMapping(path="/add", method = RequestMethod.POST)
	//注意!!!如果是文件上传,一定不能使用@RequestBody来转换成JSON数据,而要使用@RequestParam
	public String compUpload(@RequestParam String tradeMark, @RequestParam String price,
			@RequestParam("pic") MultipartFile fileAttach, HttpServletRequest req) throws IOException{
		
		String fileName = fileAttach.getOriginalFilename();
		
/*		System.out.println("tradeMark: " + tradeMark);
		System.out.println("price: " + price);
		System.out.println("attachment: " + fileName);*/
		//得到磁盘的物理路径
		String realPath = req.getSession().getServletContext().getRealPath("/resources/pic");
		//创建本地实体文件
		//F:\git-repo\SpringWeb\src\main\webapp\resources\pic + "\" + "Logo.png" 
		File file = new File(realPath + "\\" + fileName);
		
		//实现文件的上传拷贝
		FileUtils.copyInputStreamToFile(fileAttach.getInputStream(), file);
		
		return "redirect:/computer/list";
	}
}
