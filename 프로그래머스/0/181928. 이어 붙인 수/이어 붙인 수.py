def solution(num_list):
    num1 = ''
    num2 = ''
    for x in num_list:
        if x % 2 == 0:
            num1 += str(x)
        else: num2 += str(x)
    return int(num1) + int(num2)