def solution(answers):
    stu1 = [1, 2, 3, 4, 5];
    stu2 = [2, 1, 2, 3, 2, 4, 2, 5];
    stu3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    correct = [0, 0, 0];
    
    for idx, answer in enumerate(answers):
        if stu1[idx%len(stu1)] == answer:
            correct[0] += 1
        if stu2[idx%len(stu2)] == answer:
            correct[1] += 1
        if stu3[idx%len(stu3)] == answer:
            correct[2] += 1
    mx = max(correct)
    
    return [i+1 for i,n in enumerate(correct) if n == mx]
"""
1. 정답 번호에 대해 다음을 반복
    1-1. 수포자들의 패턴과 비교하여 카운팅
2. 카운팅된 숫자의 최대값을 비교하여 숫자번호저장
"""