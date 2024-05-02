import java.util.*;
class Solution {
    static Queue<String> q = new LinkedList<>();
    static boolean check(String s){
        boolean flag = false;
        int n = q.size();
        while(n-- > 0){
            if(q.peek().equals(s)) {
                q.poll();
                flag = true;
                continue;
            }
            q.add(q.poll());
        }
        return flag;
    }
    public int solution(int cacheSize, String[] cities) {
        int ret = 0;
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        if(cacheSize == 0) return cities.length * 5;
        for(String s : cities){
            if(q.isEmpty()){
                q.add(s); ret += 5;
            } else {
                if(q.size() < cacheSize){
                    if(check(s)){ // 안에있어 
                        ret += 1;
                        q.add(s);
                    } else { //안에 없어
                        ret += 5;
                        q.add(s);
                    }
                } else{ //안에 있어
                    if(check(s)){
                        ret += 1;
                        q.add(s);
                        if(q.size() > cacheSize) q.poll();
                    } else { // 안에 없어
                        ret += 5;
                        q.add(s);
                        q.poll();
                    }
                }
            }
        }
        return ret;
    }
        
    }