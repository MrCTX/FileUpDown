package com.panda.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DownloadServlet() {
		super();
	}
	public void destroy() {
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = this.getServletContext().getMimeType("abc.zip");
		response.setContentType(type);
		InputStream in = this.getServletContext().getResourceAsStream
				("/file/gradle-1.9-all.zip");
		OutputStream out = response.getOutputStream();
		byte[] bytes = new byte[1024];
		int length = -1;
		while((length = in.read(bytes)) != -1){
			out.write(bytes, 0, length);
			out.flush();
		}
	}
	public void init() throws ServletException {
		System.out.println("DownloadServlet正在初始化***");
	}

}
