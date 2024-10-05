import java.util.*;

class Solution {
    static Map<String, List<String>> mp1 = new HashMap<>(); //준사라:받은사람 이름 저장
    static Map<String, List<String>> mp2 = new HashMap<>(); //받은사람: 준사람 사람 이름 저장
    static Map<String, Integer> mp3 = new HashMap<>(); //받을 선물 개수
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    public int solution(String[] friends, String[] gifts) {
        int ret = -10;
        for (String s : friends) {
            mp1.put(s, new ArrayList<>());
            mp2.put(s, new ArrayList<>());
            mp3.put(s, 0);
        }
        for (String s : gifts) {
            String[] temp = s.split(" ");
            String s1 = temp[0];
            String s2 = temp[1];
            mp1.get(s1).add(s2); // 준놈 : 받은놈
            mp2.get(s2).add(s1); // 받은놈 : 준놈
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < i; j++) {
                String A = friends[i];
                String B = friends[j];
                int Agive = 0;
                int Bgive = 0;
                
                for (String s : mp1.get(A)) if (s.equals(B)) Agive++;
                for (String s : mp1.get(B)) if (s.equals(A)) Bgive++;
                
                // a가 더많이 b한테 줬으면
                if (Agive > Bgive) mp3.put(A, mp3.get(A) + 1);
                // b가 더많이 a한테 줬으면
                else if (Agive < Bgive) mp3.put(B, mp3.get(B) + 1);
                // 서로 안줬거나, 서로 같거나
                else { 
                    //선물지수
                    int Agi = mp1.get(A).size() - mp2.get(A).size();
                    int Bgi = mp1.get(B).size() - mp2.get(B).size();
                    // 선물지수 a가 더 크네
                    if (Agi > Bgi) mp3.put(A, mp3.get(A) + 1);
                    // 선물지수 b가 더 크네
                    else if (Agi < Bgi) mp3.put(B, mp3.get(B) + 1);
                }
            }
        }
        for(String s : mp3.keySet()) pq.add(mp3.get(s));
        ret = pq.peek();
        return ret;
    }
}