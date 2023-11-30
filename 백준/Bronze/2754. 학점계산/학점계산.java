import java.util.*;

public class Main{
    static String ret = "";
    static int n;
    static void check1(String s){
        if(s.equals("A")) n = 4;
        else if(s.equals("B")) n = 3;
        else if(s.equals("C")) n = 2;
        else if(s.equals("D")) n = 1;
        else if(s.equals("F")) ret = "0.0";
    }
    static void check2(String s){
        if(s.equals("+")) ret += n + ".3";
        else if(s.equals("0")) ret += n + ".0";
        else if(s.equals("-")) ret += --n + ".7";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String temp1 = s.substring(0, 1);
        String temp2 = s.substring(1);
        check1(temp1);
        check2(temp2);
        System.out.println(ret);
    }
}