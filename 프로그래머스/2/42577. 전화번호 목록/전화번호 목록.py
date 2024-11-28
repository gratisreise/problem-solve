def solution(phone_book):
    phone_book.sort()
    for i in range(1, len(phone_book)):
        if phone_book[i].startswith(phone_book[i-1]):
            return False
    return True
        
"""
폰북의 번호를 돌면서
번호를 정렬한다

1. 현재가 뒤의 있는 번호의 접두어이면 
    return False
2. 아니면
    return True


"""