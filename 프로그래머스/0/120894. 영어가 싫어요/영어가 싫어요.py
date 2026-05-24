def solution(numbers):
    dic ={"zero":'0', "one":'1', "two":'2', "three":'3', "four":'4', "five":'5', "six":'6', "seven":'7', "eight":'8', "nine":'9' }
    temp = ''
    ret = ''
    for c in numbers:
        temp += c
        if temp in dic.keys():
            ret += dic[temp]
            temp = ''
    return int(ret)