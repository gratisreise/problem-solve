def num_to_bin(n, size):
    ret = ''
    while n > 0:
        ret += str(n % 2)
        n //= 2
    return ("0"*size + ret[::-1])[-size:]

def solution(n, arr1, arr2):
    for i in range(len(arr1)):
        arr1[i] = num_to_bin(arr1[i], n)
        arr2[i] = num_to_bin(arr2[i], n)
    ret = []
    for i in range(n):
        temp = ''
        for x1, x2 in zip(arr1[i], arr2[i]):
            if x1 == '1' or x2 == '1':
                temp += '#'
            else: temp += ' '
        ret.append(temp)
    return ret

"""
1. 둘다 이진수로 변환
2. 둘중하나라고 1이면 #으로 해서 만들기


"""