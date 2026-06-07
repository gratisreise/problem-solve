def solution(cards1, cards2, goal):
    len1, len2, leng = len(cards1), len(cards2), len(goal)
    i1, i2, ig = 0, 0, 0
    while ig < leng:
        if i1 < len1 and goal[ig] == cards1[i1]:
            i1 += 1
        elif i2 < len2 and goal[ig] == cards2[i2]:
            i2 += 1
        else:
            return "No"
        ig += 1
    return "Yes"

"""
카드 순서대로 한 장씩 사용, 재사용 불가, 
1.둘의 요소 합친게 같은 갯수인지 확인
2.만들 수 있는지는 어떻게 확인하지??

"""