package com.su.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.su.domain.Document;
import com.su.service.DocumentService;
import com.su.util.Page;


@Controller
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	
	@RequestMapping("addDocument.action")
	public ModelAndView addDocument(String flag,Document doc,ModelAndView mav,HttpSession session)throws Exception{
		System.out.println("in DocumentController method addDocument()");
		if(flag.equals("1")){
			mav.setViewName("jsp/document/showAddDocument.jsp");
		}else{
			String fileName = doc.getFile().getOriginalFilename();
			doc.setFileName(fileName);
			String filePath = session.getServletContext().getRealPath("/upload/"+fileName);
			System.out.println("文件路径："+filePath);
			File file = new File(filePath);
			doc.getFile().transferTo(file);
			documentService.addDocument(doc);
			System.out.println("上传成功");
			mav.setViewName("redirect:findDocByPageName.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("findDocByPageName.action")
	public ModelAndView findDocByPageName(int currentPage,Document document,ModelAndView mav,HttpServletRequest request){
		System.out.println("in DocumentController method addDocument()");
		if(document.getDocumentTitle() != null){
			System.out.println("检索的标题："+document.getDocumentTitle());
			request.setAttribute("title", document.getDocumentTitle());
		}
		
		Page page = documentService.findDocByPageName(currentPage, document);
		request.setAttribute("page", page);
		mav.setViewName("jsp/document/documentList.jsp");

		return mav;
	}
	
	@RequestMapping("removeDocument.action")
	public ModelAndView removeDocument(String ids,ModelAndView mav){
		System.out.println("in DocumentController method removeDocument()");
		String[] idArray = ids.split(",");
		for(String id : idArray){
			System.out.println("要删除的文件id："+id);
			documentService.deleteDoc(Integer.parseInt(id));
		}
		mav.setViewName("redirect:findDocByPageName.action?currentPage=1");
		
		return mav;
	}
	
	@RequestMapping("downLoadDoc.action")
	public ResponseEntity<byte[]> downLoadDoc(String id,HttpSession session) throws Exception{
		System.out.println("in DocumentController method downLoadDoc()");
		// 根据id查询文档
		Document document = documentService.findDocById(Integer.parseInt(id));
		String fileName = document.getFileName();
		// 上传文件路径+文件名
		String path = session.getServletContext().getRealPath("/upload/"+fileName);
		// 获得要下载文件的File对象
		File file = new File(path);
		// 创建springframework的HttpHeaders对象
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题  
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        // 通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName); 
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 
	}

}
