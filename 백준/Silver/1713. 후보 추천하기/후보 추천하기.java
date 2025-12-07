import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        int[] cnt1 = new int[101];//추천수
        int[] cnt2 = new int[101];//시간

        List<Integer> ret = new ArrayList<>();
        var st = new StringTokenizer(in.readLine());
        for(int i = 0; i < m; i++){
            int now = Integer.parseInt(st.nextToken());

            if(ret.contains(now)){ //있으면
                cnt1[now]++;
            } else { //없으면
                if(ret.size() < n){ // 작으면
                    cnt1[now] = 1;
                    cnt2[now] = i;
                } else { //크면
                    ret.sort((a, b) ->{ //정렬
                        if(cnt1[a] == cnt1[b]){
                            return cnt2[a] - cnt2[b];
                        } return cnt1[a] - cnt1[b];
                    });

                    //제거
                    int outed = ret.get(0);
                    cnt1[outed] = 0;
                    cnt2[outed] = 0;
                    ret.remove(0);

                    cnt1[now] = 1;
                    cnt2[now] = i;
                }
                ret.add(now);
            }

        }
        ret.sort(Comparator.naturalOrder());
        for(int i : ret){
            out.print(i + " ");
        }

        out.flush();
        out.close();
    }
}