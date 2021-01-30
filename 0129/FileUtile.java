
import java.io.Closeable;

public class FileUtile {

	public static void close(Closeable c) {
		if(c!=null) {
			try {
				c.close();
			}catch(Exception e) {
				
			}
		}
	}

}
