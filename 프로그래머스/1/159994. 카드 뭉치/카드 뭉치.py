def solution(cards1, cards2, goal):
    idx1 = 0
    idx2 = 0
    for c in goal:
        flag = 0
        if idx1 < len(cards1) and cards1[idx1] == c:
            idx1 += 1
            flag = 1
        elif idx2 < len(cards2) and cards2[idx2] == c:
            idx2 += 1
            flag = 1
        if not flag: return "No"
    return "Yes"
        
# 카드를 순서대로 한 장씩 사용
# 재사용 불가
# 스킵 불가
# 순서 변경 불가
