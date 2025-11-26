import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            char[] row = s.toCharArray();
            for(int j = 0; j < n; j++){
                arr[i][j] = row[j];
            }
        }
        int ret1 = 0; //가로
        int ret2 = 0; // 세로
        for(int i = 0; i < n; i++){
            boolean flag1 = false; //가로
            boolean flag2 = false; // 세로
            char prev1 = ' ';
            char prev2 = ' ';
            for(int j = 0; j < n; j++){
                if(prev1 == '.' && arr[i][j] == '.'){//가로
                    flag1 = true;
                }
                if(prev2 == '.' && arr[j][i] == '.'){ //세로
                    flag2 = true;
                }
                if(flag1 && arr[i][j] == 'X'){
                    ret1++;
                    flag1= false;
                }
                if(flag2 && arr[j][i] == 'X'){
                    ret2++;
                    flag2 = false;
                }
                prev1 = arr[i][j];
                prev2 = arr[j][i];
            }
            if(flag1) ret1++;
            if(flag2) ret2++;
        }
        out.println(ret1 +" " + ret2);

        out.flush();
        out.close();
    }
}