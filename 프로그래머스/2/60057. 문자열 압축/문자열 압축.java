class Solution {
    public int solution(String s) {
        int ret = 10000;
        if(s.length() == 1) return 1;
        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder builder = new StringBuilder();
            int index = 0;
            int cnt = 1;
            String prev = "";
            while(index <= s.length() - i){
                String cur = s.substring(index, index + i);
                //이전이랑 같으면
                if(cur.equals(prev)) cnt++;
                else { // 같지않으면
                    //반복수 한개인경우
                    if(cnt == 1) builder.append(prev);
                    else { //반복수 여러개인경우
                        builder.append(cnt);
                        builder.append(prev);
                    }
                    cnt = 1;
                }
                index += i;
                prev = cur;
            }
            if(cnt == 1) builder.append(prev);
            else {
                builder.append(cnt);
                builder.append(prev);
            }
            if(index < s.length()) builder.append(s.substring(index));
            ret = Math.min(ret, builder.length());
        }
        
        return ret;
    }
}
/*
1. 압축 가능한 크기의 경우만큼 반복
2. 모든 문자열에 대해 반복
 2-1. 압축하는 크기만큼 문자열 체크
 2-2. 문자열의 크기가 작으면 교체
*/