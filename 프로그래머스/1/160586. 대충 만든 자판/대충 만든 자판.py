def solution(keymap, targets):
    INF = 1000
    cnt = [INF for _ in range(26)]
    for key in keymap:
        for i,c  in enumerate(list(key)):
            idx = ord(c) - ord('A')
            cnt[idx] = min(i+1, cnt[idx])
    ret = []
    for t in targets:
        ans = 0
        flag = False
        for c in t:
            if cnt[ord(c) - ord('A')] == 1000:
                flag = True
                break
        if flag:
            ret.append(-1)
        else:
            for c in t:
                ans += cnt[ord(c) - ord('A')]
            ret.append(ans)
    return ret
            
            
    
"""

키 최대 100개
다른 자판 같은 문자 가능, 중복 문자 할당 가능, 할당x 가능, 
문자열 작성 불가도 있음
최소 몇번 눌러야 문자 작성 가능한지 출력
작성불가능은 -1
알파벳 대문자만 

문자열마다 최소 버튼클릭 구하고 타겟돌면서 확인하기
1만 + 100 = 100만


"""
