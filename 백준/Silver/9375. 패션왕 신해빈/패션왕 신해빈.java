import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Map<String, Integer> mp = new HashMap<>();
            for(int i = 0; i < n; i++){
                String s = sc.next();
                String ss =sc.next();
                if(mp.containsKey(ss)){
                    mp.put(ss, mp.get(ss) + 1);
                } else mp.put(ss, 1);
            }
            long ret = 1;
            for(Map.Entry<String, Integer> e : mp.entrySet()){
                ret *= (e.getValue() + 1);
            }
            ret--;
            System.out.println(ret);
        }
    }
}