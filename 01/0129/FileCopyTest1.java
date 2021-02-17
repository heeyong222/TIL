

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String readFile =  "C:/SSAFY/eclipse-jee-2018-09-win32-x86_64.zip";
		String wFile = "d:/copy2.zip";
		
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(wFile);
			
			int len=0;
			byte[] buf = new byte[1024];
			
			while((len=fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			System.out.println("IO 종료");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			FileUtile.close(fis);
			FileUtile.close(fos);
		}
		
	}
}
