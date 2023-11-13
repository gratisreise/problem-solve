import java.util.*;

public class Main{
    static List<String> l = new ArrayList<>();
    static StringBuilder ret = new StringBuilder();
    public static void go(){
        while(ret.length() != 0 && ret.charAt(0) == '0'){
            ret = ret.delete(0, 1);
        }
        if(ret.length() == 0){
            ret.append("0");
        }
        l.add(ret.toString());
        ret.delete(0, ret.length());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(char c : s.toCharArray()){
                if('0' <= c && c <= '9') ret.append(c);
                else if(ret.length() != 0) go();
            }
            if(ret.length() != 0) go();
        }

        Collections.sort(l, (a, b) ->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });
        for(String ss : l) System.out.println(ss);
    }
}