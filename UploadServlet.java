package com.panda.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获得上传文件对象
		SmartUpload su = new SmartUpload();
		//获得ServletConfig对象
		ServletConfig config = this.getServletConfig();
		//对su进行初始化
		su.initialize(config, request, response);
		su.setAllowedFilesList("doc,txt");
		try {
			su.setDeniedFilesList("exe,bat");
			//将文件进行上传
			su.upload();
			//获得上传文件
			File file = su.getFiles().getFile(0);
			//设置保存路径和方式
			file.saveAs("/"+file.getFieldName(), SmartUpload.SAVE_VIRTUAL);
				out.write("upLoad File success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void init() throws ServletException {
		System.out.println("UploadServlet正在初始化***");
	}

}
