import java.util.*;

public class Solution {
    static int[] a;
    static int ret;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 10;
        while(count-- > 0){
            ret = 0;
            int n = sc.nextInt();
            a = new int[n + 4];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            for(int i = 2; i < n - 2; i++){
                if(a[i] > a[i - 2] && a[i] > a[i - 1] && a[i] > a[i + 1] && a[i] > a[i + 2]){
                    List<Integer> l = new ArrayList<>();
                    for(int j = i - 2; j <= i + 2; j++){
                        if(j == i) continue;
                        l.add(a[i] - a[j]);
                    }
                    Collections.sort(l);
                    ret += l.get(0);
                }
            }
            System.out.println( "#" +(10-count)+" "+ ret);
        }
    }
}

