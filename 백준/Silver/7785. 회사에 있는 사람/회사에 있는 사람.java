import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var set = new HashSet<String>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if(cmd.equals("enter")) set.add(name);
            else set.remove(name);
        }
        List<String> names = new ArrayList<>(set);
        names.sort(Comparator.reverseOrder());
        for(String name : names) out.println(name);


        out.flush();
        out.close();
    }
}