def solution(numbers):
    ret = set()
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            ret.add(numbers[i] + numbers[j])
    return sorted(list(ret))