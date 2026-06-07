def solution(num, total):
    if num % 2 == 0:
        start = total // num - (num //2 -1)
    else:
        start = (total // num) - (num //2)
    return [x for x in range(start, start + num)]
    

"""
1부터해서
나누면 중앙이네 
짝수면 해당 숫자를 기준으로 앞 숫자부터 시작


"""