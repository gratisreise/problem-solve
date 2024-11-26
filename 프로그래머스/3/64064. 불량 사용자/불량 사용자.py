import re

def search(idx, visit, answer, ban_patterns, user_id):
    if idx == len(ban_patterns):
        answer.add(visit)
        return
    for i in range(len(user_id)):
        if (visit & (1 << i)) > 0 or not re.fullmatch(ban_patterns[idx], user_id[i]):
            continue
        search(idx + 1, visit | (1 << i), answer, ban_patterns, user_id)

def solution(user_id, banned_id):
    answer = set()
    ban_patterns = [s.replace('*','.') for s in banned_id];
    search(0, 0, answer, ban_patterns, user_id)
    return len(answer)

"""
아이디어: 비트마스킹, 모든 문자열 연결 후 정렬
1. 금지아이디별 가능한 경우를 구한다
2. 중복제거
f***f *****
ffeef abcde
feeff abcde

"""