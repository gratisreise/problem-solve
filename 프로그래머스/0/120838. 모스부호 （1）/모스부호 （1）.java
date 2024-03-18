import java.util.*;
class Solution {
    public String solution(String letter) {
        Map<String, Character> morseToChar = new HashMap<>();
        
        // 주어진 모스 부호를 Map에 저장
        morseToChar.put(".-", 'a');
        morseToChar.put("-...", 'b');
        morseToChar.put("-.-.", 'c');
        morseToChar.put("-..", 'd');
        morseToChar.put(".", 'e');
        morseToChar.put("..-.", 'f');
        morseToChar.put("--.", 'g');
        morseToChar.put("....", 'h');
        morseToChar.put("..", 'i');
        morseToChar.put(".---", 'j');
        morseToChar.put("-.-", 'k');
        morseToChar.put(".-..", 'l');
        morseToChar.put("--", 'm');
        morseToChar.put("-.", 'n');
        morseToChar.put("---", 'o');
        morseToChar.put(".--.", 'p');
        morseToChar.put("--.-", 'q');
        morseToChar.put(".-.", 'r');
        morseToChar.put("...", 's');
        morseToChar.put("-", 't');
        morseToChar.put("..-", 'u');
        morseToChar.put("...-", 'v');
        morseToChar.put(".--", 'w');
        morseToChar.put("-..-", 'x');
        morseToChar.put("-.--", 'y');
        morseToChar.put("--..", 'z');
        
        String ret = "";
        String[] s = letter.split(" ");
        for(String ss : s){
            ret += morseToChar.get(ss);
        }
        
        return ret;
    }
}