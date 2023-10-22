import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder temp = new StringBuilder(s);
        String ss = temp.reverse().toString();
        if(s.equals(ss)) System.out.println(1);
        else System.out.println(0);
    }
}
/**
 * 문자열 뒤집기
 * String Buffer 또는 StringBuilder
 객체로 선언하고 reverse() 다음 toString()으로 변환해서 
 String에 집어 넣으면 된다.
 */