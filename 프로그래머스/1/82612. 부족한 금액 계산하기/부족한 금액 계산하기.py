def solution(price, money, count):
    total = count * (count + 1) // 2 *price 
    print(total)
    return 0 if money >= total else total - money