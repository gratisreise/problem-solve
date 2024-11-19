patterns = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
]

def solution(answers):
    correct = {i+1:0 for i in range(3)}
    for i, answer in enumerate(answers):
        for j,pattern in enumerate(patterns):
            if pattern[i % len(pattern)] == answer:
                correct[j+1] += 1
    mx = max([correct[i] for i in correct.keys()])
    return [i for i in correct.keys() if correct[i] == mx]
"""
# 가장 많은 문제를 맞힌 사람의 번호를 출력

1. 정답 번호에 대해 다음을 반복
    1-1. 1,2,3의 정답 패턴에 맞느지 확인
    1-2. 정답의 갯수를 저장
2. 정답 갯수의 최댓값을 찾기
3. 해당하는 정답의 갯수와 같은 번호를 담아서 리턴

"""