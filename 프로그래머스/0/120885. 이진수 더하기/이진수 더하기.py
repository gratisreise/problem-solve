def bin_to_10(s):
    ret = 0
    for i,c in enumerate(s[::-1]):
        ret +=((2**i) * int(c))
    return ret
def ten_to_2(n):
    ret = ''
    while n > 0:
        ret += str(n % 2)
        n //= 2
    return ret[::-1] if ret else '0'

def solution(bin1, bin2):
    return ten_to_2(bin_to_10(bin1) + bin_to_10(bin2))