import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            Map<String, Integer> mp = new HashMap<>();
            for(int j = 0; j < m; j++){
                String s = sc.next();
                String ss = sc.next();
                if(!mp.containsKey(ss)) mp.put(ss, 1);
                else mp.put(ss, mp.get(ss)+1);
            }
            long ret = 1;
            for(String key : mp.keySet()) ret *= (mp.get(key)+1);
            ret--;
            System.out.println(ret);
        }
    }
}