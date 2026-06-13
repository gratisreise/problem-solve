def count(date, month):
    y, m, d = date.split(".")
    y, m, d = int(y), int(m), int(d)
    y += month//12
    m += month%12
    if m > 12:
        m -= 12
        y += 1
    d -= 1
    if d == 0:
        d = 28
        m -= 1
    if m == 0:
        m = 12
        y -= 1
    m = ("00" + str(m))[-2:]
    d = ("00" + str(d))[-2:]
    return f"{y}.{m}.{d}"

def solution(today, terms, privacies):
    terms = {x[0]:int(x.split(" ")[1]) for x in terms}
    ret = []
    for i,p in enumerate(privacies):
        date, term = p.split()
        due = count(date, terms[term])
        print(due, today, terms[term])
        if today > due:
            ret.append(i+1)
    return ret
        
"""
유효기간 지나면 파기
날짜기준 작은 놈들 파기
약관 종류에 따라 다름

1. 날짜계산
2. 비교 
3. 파기될 개인정보 번호 담기


"""