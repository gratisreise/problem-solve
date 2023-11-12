import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[n + 4];
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String s = sc.next();
            a[i] = s;
            mp.put(s, i);
        }
        for(int i = 0; i < m; i++){
            String s = sc.next();
            char c = s.charAt(0);
            if(Character.isDigit(c)){
                System.out.println(a[Integer.parseInt(s)]);
            }else{
                System.out.println(mp.get(s));
            }
        }
    }
}