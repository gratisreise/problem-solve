import java.util.*;
class Solution {
    List<Integer>[] graph;
    int n, ret = -1;
    int[] info;
    private void go(int cur, int ship, int wolf, Set<Integer> set){
        // 양과 늑대의 정보를 업데이트
        if(info[cur] == 1) wolf++;
        else ship++;
        //종료조건
        if(ship <= wolf) return;
        ret = Math.max(ret, ship);
        
        // 새로운 정보 업데이트
        Set<Integer> nextSet = new HashSet<>(set);
        nextSet.remove(cur);
        for(int next : graph[cur]){
            nextSet.add(next);
        }
        
        for(int i : nextSet){
            go(i, ship, wolf, nextSet);    
        }
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        n = info.length;
        this.info = info;
        graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] arr : edges){
            int a = arr[0], b = arr[1];
            graph[a].add(b);
        }
        go(0, 0, 0, new HashSet<>());
        return ret;
    }
}
/*
조건
- 노드 방문하면 양과 늑대가 따라옴
- 늑대 양먹음(양수 <= 늑대) 모든 양
- 양이 잡아 먹히지 않도록 최대한 많은 양 모아서 돌아오기
- 단방향이 아니네 갑자기 다른곳으로 갔다가 다시 와서 뚫어서 갈 수 있다 이거네

전략
현재 내가 갈 수 있는 모든 방향에 대한 정보를 들고 상태를 체크하기 
1. 만약 현재 상태에서 다름으로 넘어갈 때 
그래프에서 노드의 탐색순서를 저렇게 자유롭게 변환시켜줄 수 있나??
아이디어: 탐색을 하면서 현재 탐색중 내가 갈수있는 모든 노드의 정보를 저장하면 된다


*/