package corejava.filedownloader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FileDownloader {
	public static void main(String[] args) {
		
		try {
			URL url = new URL(args[0]);
			BigDecimal size = new BigDecimal(0);
			int singleChar;
			int count = 1;
			int percentage = 0;
			int prevPercentage = 0;
			
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.tcs.com", 8080));
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(proxy);
			urlConnection.connect();
			size = BigDecimal.valueOf(urlConnection.getContentLength());
			System.out.println("Size: " + size);
			InputStream inputStream = urlConnection.getInputStream();
			FileOutputStream fos = new FileOutputStream("doc.pdf");

			while ((singleChar = inputStream.read()) != -1) {
				fos.write(singleChar);
				percentage = new BigDecimal(count).divide(size, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue();
				
				if (percentage != prevPercentage) {
					System.out.println("Progress: " + percentage);
					prevPercentage = percentage;
				}
				count++;
			}
			
			inputStream.close();
			fos.close();
			System.out.println(count/1024/1024 + " MB copied!");
			
		} catch (Exception e) {
			System.out.println("Exection");
			e.printStackTrace();
		}
		
	}
	
	public static void clearScreen() {
		final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
	}
}

// https://www.gocit.vn/files/Spring.in.Action.3rd.Edition-www.gocit.vn.pdf