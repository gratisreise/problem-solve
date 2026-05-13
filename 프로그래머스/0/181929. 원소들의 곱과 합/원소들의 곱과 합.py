import math
def solution(num_list):
    num1 = math.prod(x for x in num_list)
    num2 = sum(num_list) ** 2
    return 1 if num1 < num2 else 0