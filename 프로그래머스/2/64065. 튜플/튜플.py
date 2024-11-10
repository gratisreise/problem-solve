def solution(s):
    data = s[2:-2].split("},{")
    data = sorted(data, key=lambda x: len(x))
    ret = []
    for item in data:
        item = list(map(int, item.split(',')))
        for num in item:
            if num not in ret:
                ret.append(num)
    return ret
                
                