def solution(id_pw, db):
    db = {x[0] : x[1] for x in db}
    if id_pw[0] not in db.keys():
        return "fail"
    elif db[id_pw[0]] != id_pw[1]:
        return "wrong pw"
    else:
        return "login"
    
    
"""
1. 아이디 비밀번호 일치는 로그인
2. 로그인 실패
    2-1. 아이디 불일치: fail
    2-2. 아이디 일치 & 비밀번호 불일치: wron pw 
"""