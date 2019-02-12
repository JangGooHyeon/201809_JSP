package kr.or.ddit.util;

public class PartUtil {

	public static String getFileNameFromPart(String contentDisposition) {
		
//		form-data; name="uploadFile"; filename="cogi.jpg";
		
//		String[] splits = contentDisposition.split("; ");
//		//splits[0] = form-data; 
//		//splits[1] = name="uploadFile";
//		//splits[2] = filename="cogi.jpg";
//		String fileName = null;
//		for(String split : splits){
//			if(split.startsWith("fileName")){
//				fileName = split.substring(split.indexOf("\"")+1, split.lastIndexOf("\""));
//			}
//		}
		
		String[] str_part = contentDisposition.split("; ");
		String fileName = str_part[2].substring(str_part[2].indexOf("\"")+1, str_part[2].length()-1);
		
		return fileName;
	}
	
}
