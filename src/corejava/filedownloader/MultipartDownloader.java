package corejava.filedownloader;

import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import javax.net.ssl.HttpsURLConnection;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

public class MultipartDownloader {
	static final int MAX_THREADS = 5;
	static final int PARTS = 10;
	static final String USER_AGENT = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";
	static final String PROXY_URL = "proxy.tcs.com";
	static final int PROXY_PORT = 8080;
	static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_URL, PROXY_PORT));
	
	public static void main(String[] args) {
		// for bigger files BigDecimal should be used
		long size;
		long start = 0;
		long end;
		long blockSize;
		String urlStr = args[0];
		URL url = null;
		Semaphore semaphore = new Semaphore(5);
		
		try {
			url = new URL(urlStr);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestProperty("User-Agent", USER_AGENT);
			boolean isResumeSupported = urlConnection.getHeaderField("Accept-Ranges").equals("bytes");
			
			if (isResumeSupported) {
				String originalFileName = urlConnection.getHeaderField("Content-Disposition");
				String fileName = "corejava" + File.separator + "filedownloader" + File.separator;

				if (originalFileName != null) {
					fileName += originalFileName.split("filename=")[1].trim();
				} else {
					fileName += urlStr.substring(urlStr.lastIndexOf('/') + 1);
				}

				List<PartDownloader> partDownloaders = new ArrayList<>();
				BlockingQueue<String> filesPaths = new PriorityBlockingQueue<>(10);
				size = urlConnection.getContentLengthLong();
				blockSize = size / PARTS;
				
				for (int i = 0; i < PARTS; i++) {
					end = start + blockSize;
					if (end > size) {
						end = size;
					}
					partDownloaders.add(new PartDownloader(urlStr, start, end, i, semaphore, MAX_THREADS, filesPaths));
					start = end + 1;
				}
				
				for (int i = 0; i < PARTS; i++) {
					partDownloaders.get(i).start();
				}
				
				for (int i = 0; i < PARTS; i++) {
					partDownloaders.get(i).join();
				}

				FileOutputStream fos = new FileOutputStream(fileName);

				System.out.println("Merging files...");
				filesPaths.forEach(filePath -> {

					try {
						FileInputStream fis = new FileInputStream(filePath);
						int singleChar;
						while ((singleChar = fis.read()) != -1) {
							fos.write(singleChar);
						}
						fis.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
				});
				
				filesPaths.forEach(filePath -> { new File(filePath).delete(); });
				fos.flush();
				fos.close();
				System.out.println("File downloaded: " + fileName);
			} else {
				System.out.println("Resume not supported. Stoping...");
			}
		} catch (Exception e) {
			System.out.println("Exeption");
			e.printStackTrace();
		}
	}
}


class PartDownloader extends Thread {
	String url;
	long start, end;
	int seqNo;
	Semaphore semaphore;
	int maxThreads;
	BlockingQueue<String> filesPaths;
	
	PartDownloader(String url, long start, long end, int seqNo, Semaphore semaphore, int maxThreads, BlockingQueue<String> filesPaths) {
		this.url = url;
		this.start = start;
		this.end = end;
		this.seqNo = seqNo;
		this.semaphore = semaphore;
		this.maxThreads = maxThreads;
		this.filesPaths = filesPaths;
	}
	
	@Override
	public void run() {
		semaphore.acquire();
		
		FileDownloaderByRange fdr = new FileDownloaderByRange();
		String partFileName = fdr.downloadRange(url, start, end, seqNo);

		try {
			filesPaths.put(partFileName);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		semaphore.release();
	}
}

class Semaphore {
	int maxCount;
	int taken = 0;

	private Semaphore() {

	}

	public Semaphore(int maxCount) {
		this.maxCount = maxCount;
	}

	public synchronized void acquire() {
		try {
			while (taken == maxCount) {
				wait();
			}
			
			taken++;
			notifyAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void release() {
		try {
			while (taken == 0) {
				wait();
			}
			
			taken--;
			notifyAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}