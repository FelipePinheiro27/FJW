package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileUtil {

	public static void uploadFile(InputStream uploadedInputStream, String resource, String id) {
		try {
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("uploads.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			String filePath = folder + File.separator + resource + File.separator + id;
			saveFile(uploadedInputStream, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveFile(InputStream uploadedInputStream, String serverLocation) {

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
