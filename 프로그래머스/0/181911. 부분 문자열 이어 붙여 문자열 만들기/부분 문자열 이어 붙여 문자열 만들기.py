def solution(my_strings, parts):
    return ''.join(x[parts[i][0]:parts[i][1]+1] for i,x in enumerate(my_strings))