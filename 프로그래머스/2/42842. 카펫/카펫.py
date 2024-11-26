def solution(brown, yellow):
    for i in range(brown // 2):
        for j in range(brown // 2):
            if 2*i + 2*j - 4 == brown and (i - 2) * (j - 2) == yellow:
                return [j, i]
"""
# 테두리 1줄은 갈색
# 중앙 노란색
# brown = 2*height + 2*width - 4
# yellow = (height - 2) * (width - 2)
# 가로가 세로보다 크거나 같다
갈색 최대 5000
brown

"""