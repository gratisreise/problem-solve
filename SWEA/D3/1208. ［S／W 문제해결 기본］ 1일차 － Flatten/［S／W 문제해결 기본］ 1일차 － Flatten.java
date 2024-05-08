import java.util.*;

public class Solution {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++){
            cnt = sc.nextInt();
            PriorityQueue<Integer> aspq = new PriorityQueue<>();
            PriorityQueue<Integer> dspq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for(int i = 0; i < 100 ; i++){
                int temp = sc.nextInt();
                dspq.add(temp);
                aspq.add(temp);
            }
            while(cnt-- > 0 && dspq.peek() - aspq.peek() > 1){
//                System.out.println(dspq.peek()+ " :: "+ aspq.peek());
                dspq.add(dspq.poll() - 1);
                aspq.add(aspq.poll() + 1);
            }
            int ret = dspq.peek() - aspq.peek();
            System.out.println("#" + t + " "+ret);
        }
    }
}