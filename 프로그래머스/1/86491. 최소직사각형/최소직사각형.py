def solution(sizes):
    mx = max(max(x[0], x[1]) for x in sizes)
    mn = max(min(x[0], x[1]) for x in sizes)
    return mn * mx

# 둘중 가장 큰 부분은 고정
# 회전했을 때 들어가는지 확인
# 가로 세로 총합 큰놈들 구하고
# 작은 놈들만 모인 놈들중 가장 큰놈 구하면 끝아님??