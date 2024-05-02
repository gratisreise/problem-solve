import java.util.*;

class Solution {
    static List<List<Integer>> l = new ArrayList<>();
    static int[] cnt = new int[100004];

    public List<Integer> solution(String s) {
        List<Integer> ret = new ArrayList<>();
        char prev = ' ';
        String temp = "";
        List<Integer> temp1 = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') temp += c;
            else if (c == ',') {
                if (temp.length() != 0) temp1.add(Integer.parseInt(temp));
                temp = "";
            } else if (c == '}') {
                if (temp.length() != 0) {
                    temp1.add(Integer.parseInt(temp));
                    l.add(new ArrayList<Integer>(temp1));
                    temp1.clear();
                    temp = "";
                }
            }
        }
        // for (List ll : l) System.out.println(ll);
        Collections.sort(l, (a, b) -> Integer.compare(a.size(), b.size()));
        for (List<Integer> ll : l) {
            for (int i : ll) {
                if (cnt[i] != 0) continue;
                cnt[i]++;
                ret.add(i);
            }
        }

        return ret;
    }
}