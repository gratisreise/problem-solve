# 테스트 케이스 수 입력
n = int(input())

# 각 테스트 케이스 처리
for _ in range(n):
    # 두 문자열 입력
    str1, str2 = input().split()
    
    # 길이 다르면 불가능
    if len(str1) != len(str2):
        print("Impossible")
        continue
    
    # 각 문자의 빈도 저장 (소문자 a~z)
    freq1 = [0] * 26
    freq2 = [0] * 26
    
    # 두 문자열의 문자 빈도 계산
    for c1, c2 in zip(str1, str2):
        freq1[ord(c1) - ord('a')] += 1
        freq2[ord(c2) - ord('a')] += 1
    
    # 빈도 비교
    possible = all(freq1[i] == freq2[i] for i in range(26))
    
    # 결과 출력
    print("Possible" if possible else "Impossible")
    
    """
    zip함수 이용 동시 순회
    all이용 동시 비교
    
    """