def solution(ss, spoiler_ranges):
    st = set() # 스포방지 단어
    spo_idx = []
    ttemp = list(ss)
    for ran in spoiler_ranges:
        s,e = ran
        for i in range(s, e+1):
            if ttemp[i] != " ":
                ttemp[i] = '#'
    ttemp = ''.join(ttemp)
    non_spo = set(x for x in ttemp.split())
    l = len(ss)
    ret = 0
    for spran in spoiler_ranges:
        s,e = spran
        temp = ss[s:e+1]
        flag1, flag2 = False, False
        if temp[0] != " ":
            while s > 0:
                s -= 1
                if ss[s] == " ":
                    break
                temp = ss[s] + temp
                flag1 = True
        if temp[-1] != " ":
            while e < l-1:
                e += 1
                if ss[e] == " ":
                    break
                temp += ss[e]
                flag2 = True
        temp = temp.split()
        
        for word in temp:
            if word not in st and word not in non_spo:
                ret += 1
            st.add(word)
    return ret
        
                
        
            
            
        


"""
[조건]
메세지의 일부만 가림 => 스포방지
왼 -> 오른 하나씩 클릭하면 공개되는 단어들 중 중요한 단어의 갯수
- 공백구분, 알파벳 소문자 + 숫자
- 스포 방지 구간 포함 => 스포 방지 단어,
- 한 단어가 여러 구간에 포함가능, 여러 단어 한 구간에 포함가능
- 스포방지가 풀렸을 때 다음 조건 중요한 단어
    1. 스포 방지 단어
    2. 단어의 모든 문자가 스포방지 구간
    3. 이전에 공개된 스포 방지 단어와 중복x
    4. 여러 단어 동시 공개 => 왼쪽부터 순서대로 하나씩 판단(중복되는거는 왼쪽부터 판단해라)
스포방지 단어중 중요한 단어의 수 구하기
메세지 <= 2만, 스포기간 길이 <= 천

[아이디어]
스포구간을 순회하면서 스포구간 걸친단어가 중요한 단어인지 확인하기
이게 완결된 단어인지 어떻게 판단하지??
split 한다음 모든 단어를 딕셔너리에 숫자를 넣고 이게 처음인게 다른 곳에 있는 것들은
[자료구조]
스포방지 단어 set, 중요단어 변수

[로직]
1. 스포구간을 순회한다
 1-1. 해당 구간에서 공백기준으로 나뉘는지 확인
 1-2. 맨왼쪽부터 단어 확인 
 1-3. 중요한단어 체크 후 중요한 단어에 변수에 숫자 증가시키기
 1-3. 스포방지집합에 단어를 넣기
2. 중요한 단어 
"""