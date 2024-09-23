import java.util.*;
class Solution {
    private boolean check(int[] arr, int n1, int n2){
        return (n1 >= arr[0]  && n2 >= arr[1]) || (n1 >= arr[1] && n2 >= arr[0]);
    }
    public int solution(int[][] sizes) {
        List<int[]> garo = new ArrayList<>();
        List<int[]> sero = new ArrayList<>();
        for(int[] i : sizes){
            garo.add(i);
            sero.add(i);
        }
        Collections.sort(garo, (a, b) -> b[0] - a[0]);
        Collections.sort(sero, (a, b) -> b[1] - a[1]);
        
        // for(int[] i : garo) System.out.println(Arrays.toString(i));
        // System.out.println("----------------");
        // for(int[] i : sero) System.out.println(Arrays.toString(i));
        
        int garoMax = garo.get(0)[0];
        int garoMin = garo.get(garo.size() - 1)[0];
        int seroMax = sero.get(0)[1];
        int seroMin = sero.get(sero.size() - 1)[1];
        for(int i = garoMin; i <= garoMax; i++){
            for(int j = seroMin; j <= seroMax; j++){
                boolean flag = false;
                for(int[] arr : sizes){
                    if(!check(arr, i, j)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) return i * j;
            }
        }
        
        return -1;
    }
}
/*
1. 가로 세로 내림차순 정렬
2. 가로회전 체크, 세로회전 체크
3. 가로쪽 회전 
    3-1. 최대 세로의 가로가 2번째 큰 세로보다 작거나 같으면
        가로max * 세로(1)
    3-2. 최대 세로의 가로가 2번째 큰 세로보다 크면
        가로max * 가로(1)
4. 세로쪽 회전 
    4-1. 최대 가로의 세로가 2번째 큰 가로보다 작거나 같으면
        세로max * 가로(1)
    4-2. 최대 가로의 세로가 2번째 큰 가로보다 크면 
        세로max * 세로(1)
5. 회전 불가능 하면 
    5-1. 가로max * 세로max
*/