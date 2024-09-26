import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < todo_list.length; i++){
            if(!finished[i]) ret.add(todo_list[i]);
        }
        return ret.stream().toArray(String[]::new);
    }
}