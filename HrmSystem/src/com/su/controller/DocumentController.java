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
			System.out.println("�ļ�·����"+filePath);
			File file = new File(filePath);
			doc.getFile().transferTo(file);
			documentService.addDocument(doc);
			System.out.println("�ϴ��ɹ�");
			mav.setViewName("redirect:findDocByPageName.action?currentPage=1");
		}
		return mav;
	}
	
	@RequestMapping("findDocByPageName.action")
	public ModelAndView findDocByPageName(int currentPage,Document document,ModelAndView mav,HttpServletRequest request){
		System.out.println("in DocumentController method addDocument()");
		if(document.getDocumentTitle() != null){
			System.out.println("�����ı��⣺"+document.getDocumentTitle());
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
			System.out.println("Ҫɾ�����ļ�id��"+id);
			documentService.deleteDoc(Integer.parseInt(id));
		}
		mav.setViewName("redirect:findDocByPageName.action?currentPage=1");
		
		return mav;
	}
	
	@RequestMapping("downLoadDoc.action")
	public ResponseEntity<byte[]> downLoadDoc(String id,HttpSession session) throws Exception{
		System.out.println("in DocumentController method downLoadDoc()");
		// ����id��ѯ�ĵ�
		Document document = documentService.findDocById(Integer.parseInt(id));
		String fileName = document.getFileName();
		// �ϴ��ļ�·��+�ļ���
		String path = session.getServletContext().getRealPath("/upload/"+fileName);
		// ���Ҫ�����ļ���File����
		File file = new File(path);
		// ����springframework��HttpHeaders����
		HttpHeaders headers = new HttpHeaders();
		// ������ʾ���ļ������������������������  
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        // ֪ͨ�������attachment�����ط�ʽ����ͼƬ
        headers.setContentDispositionFormData("attachment", downloadFielName); 
        // application/octet-stream �� �����������ݣ�������ļ����أ���
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 
	}

}
