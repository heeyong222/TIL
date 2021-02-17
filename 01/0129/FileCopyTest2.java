

import java.io.FileInputStream;
import java.io.FileOutputStream;


/*
 * byte계열은 byte단위로 입출력 하므로 원본 손상없이 모든 파일을 입출력 가능
 */
public class FileCopyTest2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		String readFile =  "C:/SSAFY/eclipse-jee-2018-09-win32-x86_64.zip";
//		String wFile = "d:/copy1.zip";
		String readFile = "res/증명사진.jpg";
		String wFile = "res/copy1.jpg";
		
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(wFile);
			
			int len=0;
			while((len=fis.read()) != -1) {
				fos.write(len);
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
