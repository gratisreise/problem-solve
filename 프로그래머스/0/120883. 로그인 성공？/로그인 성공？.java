class Solution {
    public String solution(String[] id_pw, String[][] db) {
        boolean flag1 = false;
        boolean flag2 = false;
        String ret = "";
        for(String[] srr : db){
            if(id_pw[0].equals(srr[0]) && id_pw[1].equals(srr[1])) return "login";
            else if(id_pw[0].equals(srr[0]) && !id_pw[1].equals(srr[1])) ret = "wrong pw";
            else if(!id_pw[0].equals(srr[0]) && !ret.equals("wrong pw")) ret = "fail";
        }
        return ret;
    }
}
/*
로그인 성공 -> 아이디 비밀번호 일치 -> login
로그인 실패 -> 아이디 일치x -> fail
         -> 아이디 일치O && 비밀번호 x -> wrong pw;
*/