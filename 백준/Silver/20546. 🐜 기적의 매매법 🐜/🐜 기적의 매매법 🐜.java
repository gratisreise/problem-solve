import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        // 0:장투, 1:단타
        int[] cash = new int[2];
        int[] stock = new int[2];
        Arrays.fill(cash, n);
        String[] nums = in.readLine().split(" ");
        List<Integer> l = new ArrayList<>();
        for(String num : nums){
            l.add(Integer.parseInt(num));
        }

        int cnt = 0;
        int prev = l.get(0);
        for(int price : l){
            if(price > prev){
                if(cnt >= 0) cnt++;
                else cnt = 1;
            } else if(price < prev){
                if(cnt <= 0) cnt--;
                else cnt = -1;
            } else {
                cnt = 0;
            }
            if(cnt >= 3){//전량매도
                cash[1] += price * stock[1];
                stock[1] = 0;
            } else if(cnt <= -3){ // 전량매수
                stock[1] += cash[1]/price;
                cash[1] %= price;
            }
            stock[0] += cash[0] / price;
            cash[0] %= price;
            prev = price;
        }
        int last = l.get(l.size() -1);
        int bnp = stock[0] * last + cash[0];
        int timing = stock[1]*last + cash[1];
        if(bnp > timing){
            out.println("BNP");
        } else if(bnp < timing){
            out.println("TIMING");
        } else {
            out.println("SAMESAME");
        }
        out.flush();
        out.close();
    }
}