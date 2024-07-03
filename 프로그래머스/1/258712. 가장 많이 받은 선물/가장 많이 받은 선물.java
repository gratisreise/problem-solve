import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<String> frs = Arrays.asList(friends);
        int ret = 0;
        int[][] arr = new int[frs.size()][frs.size()];
        for(String s : gifts){
            String[] sArr = s.split(" ");
            int y = frs.indexOf(sArr[0]);
            int x = frs.indexOf(sArr[1]);
            arr[y][x] += 1;
        }
        
        Map<String, Integer> gisu = new HashMap<>();
        Map<String, Integer> give = new HashMap<>();
        
        //선물지수
        for(int i = 0; i < frs.size(); i++){
            int sum = 0;
            int jisu = 0;
            for(int j = 0; j < frs.size(); j++){
                if(i == j) continue;
                jisu += arr[i][j] - arr[j][i];
                sum += arr[i][j];
            }
            give.put(frs.get(i), sum);
            gisu.put(frs.get(i), jisu);
        }
        
        for(int i = 0; i < frs.size(); i++){
            int temp = 0;
            for(int j = 0; j < frs.size(); j++){
                if(i == j) continue;
                String y = frs.get(i);
                String x = frs.get(j);
                if(arr[i][j] > arr[j][i]){
                    temp++;
                } else if(arr[i][j] == arr[j][i]){
                    if(gisu.get(y) > gisu.get(x)) temp++;
                }
            }
            
            ret = Math.max(temp, ret);       
        }
        return ret;  
            
    } 
}