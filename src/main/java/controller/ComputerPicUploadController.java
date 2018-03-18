package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.UUIDUtil;
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
			@RequestParam("pic") MultipartFile[] fileAttach, HttpServletRequest req) throws IOException{
		
		
		for(MultipartFile multipartFile : fileAttach){

			//判断上传文件是否为空
			if(!multipartFile.isEmpty()){
				//得到上传文件名
				String fileName = multipartFile.getOriginalFilename();
				
				//得到上传文件的扩展名
				String fileExt = FilenameUtils.getExtension(fileName);
				
				//生成新的文件名,避免上传文名重复从而发生覆盖
				String newFileName = UUIDUtil.UUIDGenerator() + '.' + fileExt;
				
		/*		System.out.println("tradeMark: " + tradeMark);
				System.out.println("price: " + price);
				System.out.println("attachment: " + fileName);*/
				//得到磁盘的物理路径
				String realPath = req.getSession().getServletContext().getRealPath("/resources/pic");
				//创建本地实体文件
				//F:\git-repo\SpringWeb\src\main\webapp\resources\pic + "\" + "Logo.png" 
				File file = new File(realPath + "\\" + newFileName);
				
				//实现文件的上传拷贝
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);

			}
						
		}
		
		return "redirect:/computer/list";
	}
}
