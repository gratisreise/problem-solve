import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        StringBuilder ret = new StringBuilder();
        ret.append("<");
        for(int i = 1; i <= n; i++) q.add(i);
        while(!q.isEmpty()){
            for(int i = 0; i < k - 1; i++){
                q.add(q.poll());
            }
            ret.append(q.poll() + ", ");
        }
        ret.delete(ret.length() - 2, ret.length());
        ret.append(">");
        System.out.println(ret);
    }
}