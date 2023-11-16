import java.util.*;



public class Main{
    static StringBuilder ret = new StringBuilder();
    static List<String> l = new ArrayList<>();
    static int n ;
    static void go(){
        while(ret.length() != 0 &&  ret.charAt(0) == '0'){
            ret.delete(0, 1);
        }
        if(ret.length() == 0) ret.append("0");
        l.add(ret.toString());
        ret.delete(0, ret.length());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n-- > 0){
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
        for(String i : l) System.out.println(i);
    }
}