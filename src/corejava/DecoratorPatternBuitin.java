package corejava;
import java.io.*;
import java.util.*;

public class DecoratorPatternBuitin {
	public static void main(String[] args) throws Exception {
		File f = new File("output.txt");
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeBoolean(true);
		oos.writeInt(3221);
		List<String> strings = new ArrayList<>();
		strings.add("One");
		strings.add("Two");

		oos.writeObject(strings);
		oos.flush();
		oos.close();
		bos.close();
		fos.close();
	}
}