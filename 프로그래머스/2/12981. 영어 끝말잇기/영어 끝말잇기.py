def solution(n, words):
    st = set()
    prev = words[0][0]
    for i,x in enumerate(words):
        if prev[-1] != x[0] or x in st:
            return [i%n+1, i//n+1]
        st.add(x)
        prev = x
    return [0, 0]
    
"""
[조건]
1~n, 
1->2-> ...  차례대로 
마지막 다음 1, 마지막 문자로 시작, 이전 등장단어 사용불가, 한글자x

가장먼저 탈락하는 사람 번호, 차례
사람수, 2 <= n <=10

[아이디어]
순회하면서 조건을 어기면 해당 인덱스의 
번호 = %한후 +1
차례 = / + 1


[자료구조]

[로직]


"""