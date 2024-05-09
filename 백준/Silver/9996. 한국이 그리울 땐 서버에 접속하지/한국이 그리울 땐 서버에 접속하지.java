import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int pos = s.indexOf('*');
        String preS = s.substring(0, pos);
        String sufS = s.substring(pos + 1);

        for(int i = 0; i < n; i++){
            s = br.readLine();
            int pre = preS.length();
            int suf = sufS.length();
            if(s.length() < pre + suf) bw.write("NE\n");
            else {
                String temp1 = s.substring(0, pre);
                String temp2 = s.substring(s.length() - suf);
                if(temp1.equals(preS) && temp2.equals(sufS)){
                    bw.write("DA\n");
                } else bw.write("NE\n");
            }
        }

        bw.flush();
    }
}
/*
1. 파일의 갯수 n 입력 받기
2. 패턴 입력받고 앞 뒤 패턴 문자열에 저장
3. n번만큼 문자열 입력받기
    3-1. 문자열 길이가 앞 + 뒤 길이보다 작을때 NE
    3-2. 문자열 길이가 앞 + 뒤 길이보다 길때
        3-2-1. 패턴맞으면 DA
        3-2-2. 안맞으면 NE
 */