import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int k = Integer.parseInt(in.readLine());

        int[] dir = new int[6];
        int[] lens = new int[6];

        for(int i = 0; i < 6; i++){
            var st = new StringTokenizer(in.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            lens[i] = Integer.parseInt(st.nextToken());
        }

        int mxH = -1;
        int mxHIdx = -1;
        int mxW = -1;
        int mxWIdx = -1;
        for(int i = 0; i < 6; i++){
            int d = dir[i];
            int l = lens[i];
            if(d == 1 || d == 2){
                if(l > mxW){
                    mxW = l;
                    mxWIdx = i;
                }
            } else {
                if(l > mxH){
                    mxH = l;
                    mxHIdx = i;
                }
            }
        }

        int mxArea = mxH*mxW;

        int mnW = lens[(mxHIdx+3)%6];
        int mnH = lens[(mxWIdx+3)%6];

        int mnArea = mnW*mnH;
        int area = mxArea - mnArea;
        System.out.println(area * k);

        out.flush();
        out.close();
    }
}