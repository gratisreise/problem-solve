import java.io.*;
import java.util.*;

class A {
    int p, f, s, v, c;
    A(int p, int f, int s, int v, int c) {
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.c = c;
    }
}
public class Main {
    static final int INF = (int)1e9;
    static int n, mp, mf, ms, mv;
    static int sp, sf, ss, sv, sc, ret = INF;
    static Map<Integer, List<List<Integer>>> retV = new HashMap<>();
    static A[] a = new A[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            a[i] = new A(p, f, s, v, cost);
        }

        for (int i = 0; i < (1 << n); i++) {
            sp = sf = ss = sv = sc = 0;
            List<Integer> v = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    v.add(j + 1);
                    sp += a[j].p;
                    sf += a[j].f;
                    ss += a[j].s;
                    sv += a[j].v;
                    sc += a[j].c;
                }
            }

            if (ret >= sc && sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
                ret = sc;
                if (!retV.containsKey(ret)) {
                    retV.put(ret, new ArrayList<>());
                }
                retV.get(ret).add(v);
            }
        }

        if (ret == INF) bw.write("-1\n");
        else {
            List<List<Integer>> result = retV.get(ret);

            result.sort((l1, l2) -> {
                for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                    if((int) l1.get(i) == l2.get(i)) continue;
                    return Integer.compare(l1.get(i), l2.get(i));
                }
                return Integer.compare(l1.size(), l2.size());
            });

            bw.write(ret + "\n");
            for (int i : result.get(0)) bw.write(i + " ");
            bw.write("\n");
        }
        bw.flush();
    }
}
