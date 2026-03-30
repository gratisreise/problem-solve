import java.io.*;
import java.util.*;

public class Main {
    static int convert(String time){
        String[] times = time.split(":");
        int t = Integer.parseInt(times[0]) * 60;
        int m = Integer.parseInt(times[1]);
        return t + m;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int S = convert(st.nextToken());
        int E = convert(st.nextToken());
        int Q = convert(st.nextToken());
        Map<String, int[]> mp = new HashMap<>();
        String line;
        while((line = in.readLine()) != null){ // 10만
            if(line.isEmpty()) break;
            st = new StringTokenizer(line);
            int time = convert(st.nextToken());
            String name = st.nextToken();
            if(!mp.containsKey(name)) mp.put(name, new int[]{0, 0});
            if(time >= 0 && time <= S){
                mp.get(name)[0] = 1;
            } else if(time >= E && time <= Q){
                mp.get(name)[1] = 1;
            }
        }
        int ret = 0;
        for(var entry : mp.entrySet()){
            int[] arr = entry.getValue();
            if(arr[0] == 1 && arr[1] == 1) ret++;
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}
/*
개강총회 시작전: 입장여부확인 => 시작전 대화이름으로 확인, 시작시간==채팅시간 인정
총회끝 - 스트리밍끝: 퇴장여부확인 => 끝시간자체도인정, 00:00부터는 다음 걸로 간주
입장부터 퇴장까지 모두 확인된 학회원 입장 확인 퇴장확인 된넘들
숫자변환메서드, 이걸로 대소비교
입장은 +1 퇴장은 -1
돌면서 0인놈들만 세주기
map 이름 -> 숫자 ,
*/