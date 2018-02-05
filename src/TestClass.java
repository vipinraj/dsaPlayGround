import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String s = br.readLine();

            String out_ = decode(s);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static String decode(String s){
        
        StringBuilder decoded = new StringBuilder();
        decoded.append(s.charAt(s.length()-1));
        
        int i = s.length() - 2, nextLen, insertPosition ;
        
        while (i > -1) {
            nextLen = decoded.length() + 1;
            insertPosition = (int) (Math.ceil(((double)nextLen/2)) - 1);
            decoded.insert(insertPosition, s.charAt(i));
            i--;
        }
        
        return decoded.toString();
    }
}