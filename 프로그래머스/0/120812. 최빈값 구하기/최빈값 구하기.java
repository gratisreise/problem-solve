class Solution {
    public int solution(int[] array) {
        int ret = 0;
        int mx = -1;
        int cnt = 0;
        int[] arr = new int[1004]; // 빈도수
        for(int i : array) arr[i]++;
        for(int i : arr) mx = (i > mx) ? i : mx;
        for(int i : arr) if(i == mx) cnt++;
        if(cnt > 1) ret = -1;
        else {
            for(int i = 1; i <= 1000; i++)
                if(arr[i] == mx) ret = i;
            }
        
        return ret;
    }
}