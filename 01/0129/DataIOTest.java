

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 자바의 기본 타입을 쉽게 입출력 해주는 것이 dataiostream
 * 
 */
public class DataIOTest {

	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		try {
			fos = new FileOutputStream("data.txt");
			dos = new DataOutputStream(fos);
			
			dos.writeLong(256);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			dos.writeUTF("hello~~");
			
			//출력한 순서대로 읽어야 한다
			
			fis = new FileInputStream("data.txt");
			dis = new DataInputStream(fis);
			
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			
			
//			dis.readFully(b);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			FileUtile.close(fis);
			FileUtile.close(fos);
			FileUtile.close(dis);
			FileUtile.close(dos);
		}
	}

}
