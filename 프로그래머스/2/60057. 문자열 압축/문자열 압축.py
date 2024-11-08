def press(n, s):
    ans, prev, cnt = [], "", 1
    for i in range(0, len(s), n):
        temp = s[i:min((i+n), len(s))]
        if prev == temp: cnt += 1
        else:
            if cnt > 1: ans.append(str(cnt))
            ans.append(prev)
            prev = temp
            cnt = 1
    if cnt > 1: ans.append(str(cnt))
    ans.append(prev)
    return len(''.join(ans))

def solution(s):
    ret = int(1e4)
    if len(s) == 1: return 1
    for i in range(1, len(s)//2+1):
        ret = min(ret, press(i, s))
    return ret 
"""
문자열을 쪼개서 저장
단위, 압축
가장짧은 것의 길이를 반환
단위 1 ~ 문자열길이 / 2 만큼 다음을 반복
  1. 단위만큼 쪼갠게 이전문자열과 같은지 확인
    1-1. 같으면 카운팅
    1-2. 다르면 결과문자열에 카우팅한숫자와 같이 append
 2.결과 문자열의 길이를 최소비교
최소길이 문자열의 길이 반환
"""