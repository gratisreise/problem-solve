import java.util.*;

public class Main{
    static Map<String, Integer> mp = new HashMap<>();
    static String[] a = new String[100004];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String s = sc.next();
            mp.put(s, i + 1);
            a[i + 1] = s;    
        }

        for(int i = 0; i < m; i++){
            String s = sc.next();
            if(s.matches("\\d+")){
                int index = Integer.parseInt(s);
                System.out.println(a[index]);
            } else {
                System.out.println(mp.get(s));
            }
        }
    }
}