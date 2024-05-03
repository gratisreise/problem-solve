import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int n = str1.length();
        int m = str2.length();
        Map<String, Integer> mp1 = new HashMap<>(); // str1의 문자별 숫자
        Map<String, Integer> mp2 = new HashMap<>(); // str2의 문자별 숫자
        Map<String, Integer> mp3 = new HashMap<>(); // 합집합
        Map<String, Integer> mp4 = new HashMap<>(); // 교집합
        
        for(int i = 0; i < n - 1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if(c1 < 'a' || c1 > 'z') continue;
            if(c2 < 'a' || c2 > 'z') continue;
            String temp = str1.substring(i, i + 2);
            if(mp1.containsKey(temp)) mp1.put(temp, mp1.get(temp) + 1);
            else mp1.put(temp, 1);
        }
        
        for(int i = 0; i < m - 1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if(c1 < 'a' || c1 > 'z') continue;
            if(c2 < 'a' || c2 > 'z') continue;
            String temp = str2.substring(i, i + 2);
            if(mp2.containsKey(temp)) mp2.put(temp, mp2.get(temp) + 1);
            else mp2.put(temp, 1);
        }
        // System.out.println(mp1);
        // System.out.println(mp2);
        
        //합집합
        for(String s : mp1.keySet()) mp3.put(s, mp1.get(s));
        for(String s : mp2.keySet()){
            if(mp3.containsKey(s)) {
                mp3.put(s, Math.max(mp1.get(s), mp2.get(s)));
                mp4.put(s, Math.min(mp1.get(s), mp2.get(s)));
            }
            else mp3.put(s, mp2.get(s));
        }
        // System.out.println(mp3);
        // System.out.println(mp4);
        
        double temp1 = 0.0; double temp2 = 0.0;
        
        for(String s : mp3.keySet()) temp1 += mp3.get(s);
        for(String s : mp4.keySet()) temp2 += mp4.get(s);
        // System.out.println(temp1);
        // System.out.println(temp2);
        if((int)temp1 == 0) return 65536;
        answer = (int)(temp2 * 65536 / temp1);
        
        return answer;
    }
}