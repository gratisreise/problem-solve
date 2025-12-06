import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();

        int cnt = 0;

        if(s.length() == 1){
            int n = Integer.parseInt(s);
            System.out.println(0);
            if (n % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return;
        }

        while(true){
            char[] temp = s.toCharArray();
            int sum = 0;
            for(char c : temp){
                sum += c - '0';
            }
            cnt++;
            if(sum < 10){
                System.out.println(cnt);
                if(sum % 3 == 0){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                break;
            }
            s = String.valueOf(sum);
        }
        out.flush();
        out.close();
    }
}