

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
/*
 * char 계열은 2byte 단위로 입출력 해서 문자 처리 하므로 문자 데이터가 아닌 경우
 * 원본 손상이 일어날 수 있음.
 * 
 */
public class FileCopyTest3 {
	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fos = null;
//		String readFile =  "C:/SSAFY/eclipse-jee-2018-09-win32-x86_64.zip";
//		String wFile = "d:/copy2.zip";
//		String readFile = "res/증명사진.jpg";
//		String wFile = "res/copy1.jpg";
		String readFile = "res/BaseStation1.txt";
		String wFile = "res/copy2.txt";
		
		try {
			fis = new FileReader(readFile);
			fos = new FileWriter(wFile);
			
			int len=0;
			char[] buf = new char[1024];
			
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
