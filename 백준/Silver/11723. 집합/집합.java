import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("all") || s.equals("empty")) {
                if (s.equals("all")) {
                    List<Integer> temp = new ArrayList<>();
                    for (int j = 1; j <= 20; j++) temp.add(j);
                    l = temp;
                } else if (s.equals("empty")) l.clear();
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (s.equals("add")) {
                    if (l.contains(x)) continue;
                    l.add(x);
                } else if (s.equals("remove")) {
                    if (!l.contains(x)) continue;
                    l.remove(l.indexOf(x));
                } else if (s.equals("check")) {
                    if (l.contains(x)) bw.write("1\n");
                    else bw.write("0\n");
                } else if (s.equals("toggle")) {
                    if (l.contains(x)) l.remove(l.indexOf(x));
                    else l.add(x);
                }
            }
        }
        bw.flush();
    }
}