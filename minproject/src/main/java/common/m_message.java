package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class m_message {
	PrintWriter pw = null;

	public void message(String msg, HttpServletResponse response) throws IOException {
		this.pw = response.getWriter();
		
		this.pw.write("<script>"+msg+"</script>");
		this.pw.close();
	}
	
}
