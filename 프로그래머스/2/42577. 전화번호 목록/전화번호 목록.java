import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook, (a, b) -> Integer.compare(a.length(), b.length()));
        Set<String> prefixes = new HashSet<>();
        for (String phone : phoneBook) {
            for (int end = 1; end < phone.length(); end++) {
                if(prefixes.contains(phone.substring(0, end))) return false;
            }
            prefixes.add(phone);
        }

        return true;
    }
}

/*
가능한 모든 접두어를 구하고 확인하기
맵 ---- 낮은애들 부터 
*/