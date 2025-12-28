import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        int[] arr  = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        char[] crr1 = in.readLine().toCharArray();
        char[] crr2 = in.readLine().toCharArray();
        int[] hap = new int[crr1.length + crr2.length];

        for(int i = 0; i < crr1.length; i++){
            hap[i*2] = arr[crr1[i]-'A'];
            hap[i*2+1] = arr[crr2[i]-'A'];
        }

        int lim = hap.length-1;
        for(int i = 0; i < hap.length -2; i++){
            for(int j = 0; j < lim; j++){
                hap[j] = (hap[j] + hap[j+1])%10;
            }
            lim--;
        }
        out.printf("%d%d\n",hap[0], hap[1]);


        out.flush();
        out.close();
    }
}