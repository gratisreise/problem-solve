import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs = br.readLine();
        String temp = new StringBuilder(rs).reverse().toString();
        if(rs.equals(temp)) bw.write("1\n");
        else bw.write("0\n");
        bw.flush();
    }
}