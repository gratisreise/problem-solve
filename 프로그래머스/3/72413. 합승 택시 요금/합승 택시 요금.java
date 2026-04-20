import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        //초기화
        int[][] dist = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], 200 * 100000 +1);
            dist[i][i] = 0;
        }
        for(int[] arr : fares){
            int c = arr[0], d = arr[1], f = arr[2];
            dist[c][d] = f;
            dist[d][c] = f;
        }
        
        // 플로이드 워셜
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int ret = dist[s][a] + dist[s][b];
        for(int i = 1; i <= n; i++){
            ret = Math.min(ret, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        
        return ret;
    }
}
/*
목표, 조건
- 택시비 아까기, 택시합승으로 절약,
- A출발지:a, B출발지: b,
- 귀가시 소용되는 최저 택시 요금
- n(1~n) 지점, 간선: 택시요금, 두지점사이 시작에 상관없이 동일,
- 혼용구간 + 각자 떨어지는 구간 존재
- 합승안해도 됨
- 최저 택시요금 = A와 B의 합 
전략, 복잡도 
- 서로 따로 갈때를 구해서 더하기
질문1. 같이 어디까지 동행해야하는지 어떻게 구하지?
질문2. 서로 헤어지는 지점부터 다시 최단경로 해서 하면되나?? 
질문3. 그냥 시작부터 각지점 최단경로로 비용구하고 거기서부터 시작해서 최단경로로 A와B를 최단경로 시작하면되지않나??
*/