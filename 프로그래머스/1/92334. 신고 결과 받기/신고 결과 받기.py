def solution(id_list, report, k):
    dic1 = {x:set() for x in id_list} # 내가신고
    dic2 = {x:set() for x in id_list} # 나를신고
    
    for rep in report:
        name1, name2 = rep.split()
        dic1[name1].add(name2)
        dic2[name2].add(name1)
        
    ret = []
    for i in id_list:
        cnt = sum(1 for x in dic1[i] if len(dic2[x]) >= k)
        ret.append(cnt)
    return ret
                
        
"""
[조건]
신고처리, 한 번에 한명 신고
횟수제한x, 한유저 여러번 => 신고회수1회로 처리
k번이상 신고유저 => 이용정지, 신고한 유저에게 메일 발송
신고내용 취합후 이용정지 시키면서 메일 발송


[아이디어]
1.report를 돌면서 각 사람마다 누구를 신고했는지 집합에 추가
2.사랍-집합 맵을 돌면서 사람-피신고횟수를 채우기
3.사람-신고한사람집합 돌면서 사람-수신메일횟수 채우기

[자료구조]
사람-내가신고, 사람-나를 신고, 사람-수신메일회수


[로직]


"""