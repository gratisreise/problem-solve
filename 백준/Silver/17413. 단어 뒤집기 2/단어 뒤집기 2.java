import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        char[] crr = in.readLine().toCharArray();

        StringBuilder ret = new StringBuilder();
        boolean flag = false;
        Stack<Character> stk = new Stack<>();
        for(char c : crr){
            if(c == '<') {
                flag = true;
                while(!stk.isEmpty()){
                    ret.append(stk.pop());
                }
            }
            if(c == ' '){
                while(!stk.isEmpty()){
                    ret.append(stk.pop());
                }
                ret.append(c);
                continue;
            }
            if(flag) ret.append(c);
            else stk.add(c);
            if(c == '>') {
                flag = false;
            }
        }
        while(!stk.isEmpty()){
            ret.append(stk.pop());
        }
        System.out.println(ret);



        out.flush();
        out.close();
    }
}