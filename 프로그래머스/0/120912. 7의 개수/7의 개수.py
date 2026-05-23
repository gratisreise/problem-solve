
def solution(array):
    ret = 0
    for num in array:
        ret += sum(1 for x in str(num) if x == '7')
    return ret