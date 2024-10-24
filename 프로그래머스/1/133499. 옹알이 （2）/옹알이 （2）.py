import re

def solution(babbling):
    # 조카가 발음할 수 있는 단어 목록
    valid_sounds = ["aya", "ye", "woo", "ma"]
    
    # 발음할 수 있는 단어 개수를 저장할 변수
    count = 0
    
    for word in babbling:
        # 중복되는 발음이 있는지 확인
        if any(double in word for double in ["ayaaya", "yeye", "woowoo", "mama"]):
            continue
        
        # 발음할 수 있는 단어가 아니라면, 남은 문자열이 있으면 발음할 수 없음
        temp = word
        for sound in valid_sounds:
            temp = temp.replace(sound, " ")
        
        # 남은 문자열이 빈 문자열이라면 발음 가능
        if temp.strip() == "":
            count += 1
            
    return count
