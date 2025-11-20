import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

public class Main {
    static class People{
        String name;
        int day;
        int month;
        int year;
        public People(String name, int day, int month, int year){
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
        @Override
        public String toString(){
            return name + " :: " + year + "년" + month + "월" + day +"일";
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        List<People> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            l.add(new People(name, day, month, year));
        }
        l.sort((a, b) -> {
            if(a.year == b.year){
                if(a.month == b.month){
                    return Integer.compare(a.day, b.day);
                }
                return Integer.compare(a.month, b.month);
            }
            return Integer.compare(a.year, b.year);
        });
        System.out.println(l.get(l.size()-1).name);
        System.out.println(l.get(0).name);
        out.flush();
        out.close();
    }
}