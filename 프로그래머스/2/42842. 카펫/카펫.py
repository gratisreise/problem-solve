def solution(brown, yellow):
    for h in range(1, 2500):
        for w in range(h, 2500):
            if (w-2)*(h-2) == yellow and 2 *(w+h-2) == brown:
                return [w, h]
"""
중앙 노란색, 테두리 갈색
카펫의 가로 크기, 세로 크기를 출력
가로의 길이는 세로보다 크거나 같다

(w - 2) * (h - 2) == yellow
2*w + 2*(h - 2) == brown
2*w + 2*h - 4 == 5000
w + h - 2 = 2500
w + h = 2502

"""