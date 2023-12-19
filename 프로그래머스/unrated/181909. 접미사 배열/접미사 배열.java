import java.util.*;
class Solution {
    public List<String> stringArraySort(List<String> words){
        for(int i = 0; i < words.size() - 1; i++){
            for(int j = i + 1; j < words.size(); j++){
                if(words.get(i).compareTo(words.get(j)) > 0){
                    String temp = words.get(j);
                    words.set(j, words.get(i));
                    words.set(i, temp);
                }
            }
        }
        return words;
    }
    public List<String> solution(String my_string) {
        StringBuilder temp = new StringBuilder(my_string);
        String s = temp.reverse().toString();
        List<String> ret = new ArrayList<>();
        String temp1 = "";
        for(char c : s.toCharArray()){
            temp1 = c + temp1;
            ret.add(temp1);
        }
        stringArraySort(ret);
        return ret;
    }
}