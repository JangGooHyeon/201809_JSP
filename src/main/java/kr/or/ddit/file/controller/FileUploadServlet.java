package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

// 5MB = 5 * 1024 * 1024
// 5MB = 5 * 1MB
// 1MB = 1024KB
// 1KB = 1024BYTE

//파일 업로드
// 1. form tag enctype 설정 : enctype=multipart/form-data"
// 2. @MultipartConfig (maxFileSize, maxRequestSize)

// MultipartConfig를 설정해야 파일 업로드가 가능하다.
// maxFileSize 	  : byte단위의 파일 용량(파일의 최대 사이즈)
// maxRequestSize : 전성되는 request의 최대 사이즈 (file + formData)
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=5 * 1024 * 1024, maxRequestSize=5 * 5 * 1024 * 1024)
public class FileUploadServlet extends HttpServlet {
	
	private static final String UPLOAD_PATH = "C:\\picture\\";
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String contentType = request.getContentType();
		String userId = request.getParameter("userId");
		String uploadFile = request.getParameter("uploadFile");
		
//		System.out.println("userId : " + userId);
//		System.out.println("fileUpload : " + uploadFile);
		
		//low level --> high level
		//하위 레벨은 상위 레벨을 포함하는 개념
		
		//로깅 레벨 info : logger.info(...), logger.warn(...), logger.error(...)
		//로깅 레벨 error : logger.error(...)
		
		// trace, debug, info, error
		logger.debug("contentType : " + contentType);
		logger.debug("userId : " + userId);
		logger.debug("uploadFile : " + uploadFile);
		
		//part정보 확인
		//request.getPart(name);
		//request.getPart();
//		Collection<Part> parts = request.getParts();
//		for(Part part : parts){
//			logger.debug("part.getName : {}", part.getName());
//			logger.debug("Content-Disposition : {}", part.getHeader("Content-Disposition"));
//		}
		
		Part uploadFilePart = request.getPart("uploadFile");
		String contentDisposition  = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition : {}",contentDisposition);
		
		//application
		//localhost/upload --> 물리적 경로를 확인
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload");
		logger.debug("path : {}", path);
		
		
		if(uploadFilePart.getSize() > 0){
			//첨부파일 파일명
			String fileName = PartUtil.getFileNameFromPart(contentDisposition);
			String uuidFileName = UUID.randomUUID().toString();
//			uploadFilePart.write(UPLOAD_PATH + uuidFileName);
			
			//파일 업로드 후, localhost/upload/파일명 >> 업로드한 파일 실행(이미지인 경우 이미지를 출력)
			uploadFilePart.write(path + File.separator + uuidFileName);
			uploadFilePart.delete(); //파일 업로드 후 불필요한 경로파일(실제경로가 아닌 가경로)을 삭제
		}
		
		doGet(request, response);
		
	}

}
