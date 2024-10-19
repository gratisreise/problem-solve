def solution(arr, delete_list):
    ret = []
    for i in arr:
        flag = 0
        for j in delete_list:
            if(j == i): flag = 1
        
        if(flag): continue
        ret.append(i)
    return ret