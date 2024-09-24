class Solution {
    private int hourToMinute(String s){
        int h = Integer.parseInt(s.substring(0,2)) * 60;
        int m = Integer.parseInt(s.substring(s.length() - 2));
        return h + m;
    }
    private String minuteToHour(int n){
        String h = "00" + n / 60;
        String m = "00" + n % 60;
        return h.substring(h.length() -2) + ":" + m.substring(m.length() - 2);
    }
    
    public String solution(String video_len1, String pos1, String op_start1, String op_end1, String[] commands) {
        int videoLen = hourToMinute(video_len1);
        int pos = hourToMinute(pos1);
        int opStart = hourToMinute(op_start1);
        int opEnd = hourToMinute(op_end1);
        int total = pos;
        if(opStart <= total && total <= opEnd) total = opEnd;
        
        for(String s : commands){
            int num = s.equals("next") ? 10 : -10;
            total += num;
            total = Math.max(0, total);
            total = Math.min(videoLen, total);
            if(opStart <= total && total <= opEnd) total = opEnd;
        }
        
        return minuteToHour(total);
    }
}
/*
영상 처음위치 : 0분0초
영상 마지막위치 : 동영상의 길이
오프닝 구간 자동 오프닝 끝 구간으로
1. 오프닝 구간인지 확인
2. 더하거나 빼서 위치 확인 
    2-1. 10초 미만이면 0분 0초로
    2-2. 비디오 길이 초과이면 자동 비디오길이로 이동
3. 계산한 시간 출력

*/