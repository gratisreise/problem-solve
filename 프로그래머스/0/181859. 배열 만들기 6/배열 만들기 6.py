def solution(arr):
    stk = []
    for num in arr:
        if not stk:
            stk.append(num)
        else:
            if stk[-1] == num:
                stk.pop()
            else:
                stk.append(num)
    return stk if stk else [-1]
    
# 빈배열 => arr[i]를 stk 추가하고 i++
# 마지막원소 == arr[i] => stk pop, i++
# 마지막원소 != arr[i] => stk push arr[i], i++