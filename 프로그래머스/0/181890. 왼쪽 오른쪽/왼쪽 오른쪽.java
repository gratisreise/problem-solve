import java.util.*;
class Solution {
    public List<String> solution(String[] str_list) {
        List<String> sl = new ArrayList<>();
        boolean flag = false;
        for(String s : str_list){
            if(!flag && s.equals("l")){
                flag = true;
                break;
            }
            else if(!flag && s.equals("r")) {
                flag = true;
                sl.clear();
                continue;
            }
            sl.add(s);
        }
        if(!flag) sl.clear();
        return sl;
    }
}