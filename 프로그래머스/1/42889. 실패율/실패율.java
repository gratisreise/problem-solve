import java.util.*;
class Solution {
    class Pair{
        int a;
        double b;
        
        public Pair(int a, double b){
            this.a = a;
            this.b = b;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt = new int[N + 2]; // 스테이지별 도전하는 사람수
        
        for(int i : stages) cnt[i]++;
        // System.out.println(Arrays.toString(cnt));
        int[] sufSum = Arrays.copyOf(cnt, cnt.length); //스테이지별 도달한 사람수
        for(int i = N; i >= 1; i--){
            sufSum[i] = sufSum[i] + sufSum[i + 1];
        }
        // System.out.println(Arrays.toString(sufSum));
        List<Pair> l = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(sufSum[i] == 0) l.add(new Pair(i, 0));
            else l.add(new Pair(i, (double)cnt[i]/sufSum[i]));
        }
        // for(Pair p : l) System.out.println(p.a + " :: " + p.b);
        l.sort((a, b) -> {
            int ret = Double.compare(b.b, a.b);
            if(ret == 0){
                ret = Integer.compare(a.a, b.a);
            }
            return ret;
        });
        // for(Pair p : l) System.out.println(p.a + " :: " + p.b);
        for(int i = 0; i < N; i++){
            answer[i] = l.get(i).a;
        }
        return answer;
    }
}
/*
1. stages를 돌면서 각 단계의  
2. 뒤에서 하는 누적합
3. 
*/