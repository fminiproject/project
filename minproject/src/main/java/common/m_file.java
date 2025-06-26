package common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class m_file {
	long filesize = 0;  //파일용량 가져옴
	String filenm = null;
	String url = null;
	
	public String file_attach(Part file, String save, HttpServletRequest req)throws IOException{
		this.filesize = file.getSize();  //파일용량 가져옴
		if(file!=null && this.filesize !=0) {  //첨부파일이 있으면 
			this.filenm = file.getSubmittedFileName();  //파일명 가져옴
			this.url = req.getServletContext().getRealPath(save);  
			System.out.println(this.url);
			//첨부파일 저장될 경로 지정 (D:\fminiproject\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\minproject\notice_file\)
			
			file.write(this.url+this.filenm);  //파일 저장
			
		}else {  //첨부파일 없으면
			this.filenm = null;
		}
		
		return this.filenm;
	}

}
