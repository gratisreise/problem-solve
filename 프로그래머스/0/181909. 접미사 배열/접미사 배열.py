def solution(my_string):
    return sorted(my_string[-(i+1):] for i,x in enumerate(my_string))
    