package corejava.filedownloader;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FileDownloaderByRange {
	static final String USER_AGENT = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";
	static final String PROXY_URL = "proxy.tcs.com";
	static final int PROXY_PORT = 8080;
	static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_URL, PROXY_PORT));
	static final String TEMP_FILE_PREFIX = "temp-file-";
	
	public static void main(String[] args) {
		
		
		
		new FileDownloaderByRange().downloadRange("https://www.gocit.vn/files/Spring.in.Action.3rd.Edition-www.gocit.vn.pdf", 0, 1000000, 2);
		
		
		/*try {
			URL url = new URL(args[0]);
			BigDecimal size = new BigDecimal(0);
			int singleChar;
			int count = 1;
			int percentage = 0;
			int prevPercentage = 0;
			System.out.println("URL: " + args[0]);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.tcs.com", 8080));
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection(proxy);
			urlConnection.setRequestProperty("User-Agent", USER_AGENT);
			boolean isResumeSupported = urlConnection.getHeaderField("Accept-Ranges").equals("bytes");
			
			if (isResumeSupported) {
				
				size = BigDecimal.valueOf(urlConnection.getContentLength());
				System.out.println("Size: " + size);
				
				int mid = size.intValue() / 2;
				int start = 0;
				int end = mid;
				
				for (int i = 0; i < 2; i++) {
					System.out.println("Start: " + start + " End: " + end);
					urlConnection = (HttpsURLConnection) url.openConnection(proxy);
					urlConnection.setRequestProperty("Range", "bytes=" + start + "-" + end);
					urlConnection.setRequestProperty("User-Agent", USER_AGENT);
					urlConnection.connect();
					System.out.println("Respnse Code: " + urlConnection.getResponseCode());
					InputStream inputStream = urlConnection.getInputStream();
					FileOutputStream fos = new FileOutputStream("doc.pdf-" + i);
					start = end + 1;
					end = size.intValue();
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
				}
				
				

				System.out.println(count/1024/1024 + " MB copied!");
			} else {
				System.out.println("Resume not supported. Stoping...");
			}
			
			
		} catch (Exception e) {
			System.out.println("Exection");
			e.printStackTrace();
		}*/
		
	}
	
	public String downloadRange(String urlStr, long start, long end, int seqNo) {
		
		String fileName = "corejava" + File.separator + "filedownloader" + File.separator + TEMP_FILE_PREFIX + seqNo;
		try {
			URL url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestProperty("User-Agent", USER_AGENT);
			urlConnection.setRequestProperty("Range", "bytes=" + start + "-" + end);
			urlConnection.connect();
			FileOutputStream fos = new FileOutputStream(fileName);
			InputStream inputStream = urlConnection.getInputStream();
			
			int singleChar;
			int count = 1;
			int percentage = 0;
			int prevPercentage = 0;
			System.out.println();
			while ((singleChar = inputStream.read()) != -1) {
				fos.write(singleChar);
				percentage = (int)(((double)count / (end - start)) * 100);
				
				if (percentage != prevPercentage) {
					System.out.print("\rPart " + seqNo + ": Progress: " + percentage);
					prevPercentage = percentage;
				}
				count++;
			}
			fos.flush();
			fos.close();
			System.out.print("Part " + seqNo + " downloded (" + (double)count/1024/1024 + "MB).\n");
			
		} catch (Exception e) {
			System.out.println("Exection");
			e.printStackTrace();
		}
		
		return fileName;
	}
	
	public static void clearScreen() {
		final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
	}
}

// https://www.gocit.vn/files/Spring.in.Action.3rd.Edition-www.gocit.vn.pdf