def solution(answers):
    num1 = [1, 2, 3, 4, 5]
    num2 = [2, 1, 2, 3, 2, 4, 2, 5]
    num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ret = [0] * 3
    for i,num in enumerate(answers):
        if num == num1[i % len(num1)]: ret[0] += 1
        if num == num2[i % len(num2)]: ret[1] += 1
        if num == num3[i % len(num3)]: ret[2] += 1
    return [i+1 for i,num in enumerate(ret) if num == max(ret)]