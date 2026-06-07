def solution(array, commands):
    ret = []
    for cmd in commands:
        i, j, k = cmd
        ret.append(sorted(array[i-1:j])[k-1])
        
    return ret