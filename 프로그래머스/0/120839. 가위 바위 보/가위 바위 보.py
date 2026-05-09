def solution(rsp):
    dic ={'2': '0', '0':'5', '5':'2'}
    return ''.join(dic[c] for c in rsp)