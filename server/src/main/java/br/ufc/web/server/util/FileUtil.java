package br.ufc.web.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	public void uploadFile(InputStream uploadedInputStream, String folder, String resource, String id) {
		try {
			String filePath = folder + File.separator + resource + File.separator + id + ".pdf";
			System.out.println(id);
			saveFile(uploadedInputStream, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			File file = new File(serverLocation);
			File parent = file.getParentFile();
			if (!parent.exists() && !parent.mkdirs()) {
			    throw new IllegalStateException("Couldn't create dir: " + parent);
			}
			
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}