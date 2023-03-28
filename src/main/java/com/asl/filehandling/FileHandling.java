package com.asl.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class FileHandling {
	
	private String getFileName(final Part part,String email) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return email+content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public String saveFile(String uploadPath, Part part,String email) throws Exception {
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		String fileName = getFileName(part,email);
		OutputStream out1 = new FileOutputStream(new File(uploadPath + File.separator + fileName));
		InputStream fileContent = part.getInputStream();
		int read = 0;
		final byte[] bytes = new byte[1024];
		while ((read = fileContent.read(bytes)) != -1) {
			out1.write(bytes, 0, read);
		}
		out1.flush();
		out1.close();
		fileContent.close();

		return getFileName(part,email);
	}

}
