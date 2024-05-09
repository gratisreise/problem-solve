import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st; // 개행으로 받을 때 유용

        rs = br.readLine();
        String ret = "";

        for(char c : rs.toCharArray()){
            if('a' <= c && c <= 'z'){
                if(c + 13 > 'z') ret += (char)(c - 13);
                else ret += (char)(c + 13);
            } else if('A' <= c && c <= 'Z'){
                if(c + 13 > 'Z') ret += (char)(c - 13);
                else ret += (char)(c + 13);
            } else ret += c;
        }

        bw.write(ret+'\n');
        bw.flush();
    }
}