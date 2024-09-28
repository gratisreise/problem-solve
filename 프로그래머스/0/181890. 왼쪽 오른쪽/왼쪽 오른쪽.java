import java.util.*;
import java.util.stream.*;
class Solution {
    private String[] makeL(int idx, String[] str_list){
        String[] ans = new String[idx];
        for(int i = 0; i < idx; i++) ans[i] = str_list[i];
        return ans == null ? new String[]{} : ans;
    }
    private String[] makeR(int idx, String[] str_list){
        String[] ans = new String[str_list.length-idx-1];
        System.out.println(ans.length);
        for(int i = idx + 1; i < str_list.length; i++){
            ans[i - idx - 1] = str_list[i];
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(ans.length);
        return ans == null ? new String[]{} : ans;
    }
    public String[] solution(String[] str_list) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")) return makeL(i, str_list);
            if(str_list[i].equals("r")) return makeR(i, str_list);
        }
        return new String[]{};
    }
}


/*


자꾸 틀리네 다시 생각해보자!!


*/