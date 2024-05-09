import java.io.*;

public class Main{
    static int[] cnt = new int[200];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        for(char c : s.toCharArray()) cnt[c]++;

        int flag = 0;
        char mid = ' ';
        String ret = "";

        for(int i = 'Z'; i >= 'A'; i--){
            if(cnt[i] % 2 == 1){ // 홀수이면
                cnt[i]--; flag++;
                mid = (char)i;
            }
            if(flag == 2) {
                bw.write("I'm Sorry Hansoo\n");
                bw.flush();
                return;
            }
            for(int j = 0; j < cnt[i]; j += 2){
                ret = (char)i + ret;
                ret += (char)i;
            }
        }
        if(mid != ' ') {
            int pos = ret.length()/2;
            ret = ret.substring(0, pos) + mid + ret.substring(pos);
        }

        bw.write(ret + '\n');
        bw.flush();
    }
}
/*
cnt배열 이용해서 출력
1. 문자열 입력받기
2. 문자열을 순회하면서 cnt에 문자별 갯수 저장
3. Z->A순으로 순회하기
    3-1.문자갯수 홀수
        3-1-1.갯수-1, 홀수갯수+1, 삽입할 문자 에넣기
        3-1-1.문자열 앞뒤에 문자넣어주기
    3-2.문자갯수 짝수
        3-2-1.문자열 앞뒤에 문자넣어주기
4.펠린드롬 불가능 -> I'm Sorry Hansoo
5.펠린드롬 가능 -> 펠린드롬 출력
 */