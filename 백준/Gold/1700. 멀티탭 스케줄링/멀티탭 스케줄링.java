import java.io.*;
import java.util.*;

public class Main {
    static int n, k, ret;
    static int[] a;
    static Set<Integer> visited = new HashSet<>();
    static List<Integer> v = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            if(!visited.contains(a[i])){
                if(v.size() == k){
                    int lastIdx = 0;
                    int pos = 0;
                    for(int _a : v){
                        int herePick = Integer.MAX_VALUE;
                        for(int j = i + 1; j < n; j++){
                            if(_a == a[j]){
                                herePick = j;
                                break;
                            }
                        }
                        if(lastIdx < herePick){
                            lastIdx = herePick;
                            pos = _a;
                        }
                    }
                    visited.remove(pos);
                    ret++;
                    v.remove((Integer)pos);
                }
                v.add(a[i]);
                visited.add(a[i]);
            }
        }
        bw.write("" + ret +'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}