import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] str_list) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")) break;
            ret.add(str_list[i]);
            if(str_list[i].equals("r")) {
                ret.clear();
                for(int j = i + 1; j < str_list.length; j++){
                    ret.add(str_list[j]);
                }
                break;
            }
        }
        if(ret.size() == str_list.length) return new String[]{};
        return ret.stream().toArray(String[]::new);
    }
}


/*


자꾸 틀리네 다시 생각해보자!!


*/