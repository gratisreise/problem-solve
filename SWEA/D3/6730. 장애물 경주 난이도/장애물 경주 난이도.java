import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++){
            int n = sc.nextInt();
            int prev = 0;
            int up = Integer.MIN_VALUE;
            int down = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                int temp = sc.nextInt();
                if(prev != 0){
                    if(temp > prev) up = Math.max(temp - prev, up);
                    else if(temp < prev) down = Math.max(prev - temp, down);
                }
                prev = temp;
            }
            if(up == Integer.MIN_VALUE) up = 0;
            if(down == Integer.MIN_VALUE) down = 0;
            System.out.println("#"+ i + " " + up + " " + down);
        }
    }
}