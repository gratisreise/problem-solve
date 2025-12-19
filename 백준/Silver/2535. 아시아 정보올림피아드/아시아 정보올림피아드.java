import java.io.*;
import java.util.*;

public class Main {
    static class Student{
        int c;
        int n;
        int s;
        Student(int c, int n, int s){
            this.c = c;
            this.n = n;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[] country = new int[101];
        List<Student> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            l.add(new Student(c, num,s));
        }

        l.sort((a, b) -> b.s -a.s);

        int cnt = 0;
        for(Student student : l){
            if(cnt == 3) break;
            int c = student.c;
            int num = student.n;
            if(country[c] == 2) continue;
            out.printf("%d %d\n", c, num);
            cnt++;
            country[c]++;
        }

        out.flush();
        out.close();
    }
}