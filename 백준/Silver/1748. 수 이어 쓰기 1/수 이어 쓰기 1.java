import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        long start = 1;
        long digit = 1;
        long ret = 0;
        while(start <= n){
            long end = start * 10 - 1;
            if(end > n){
                end = n;
            }

            long count = end -start + 1;
            ret += count * digit;

            start *= 10;
            digit++;
        }


        out.println(ret);



        out.flush();
        out.close();
    }
}
/*
아이디어는 자릿수 마다 갯수일치 조절


1~9    9 1의 자리 9개 
10~99  90 2의 자리 90개 
100~999 900 3의 자리 900개
자릿수++;
갯수 *= 10;
틀린 이유: 자릿수마다 갯수를 어떻게 세주지 => n보다 end가 그켠 그냥 end = n으로 처리 해버림
*/