from collections import Counter

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
    
    # 두 문자열의 문자 빈도 비교
    freq1 = Counter(str1)
    freq2 = Counter(str2)
    
    # 빈도 동일 여부 확인
    possible = freq1 == freq2
    
    # 결과 출력
    print("Possible" if possible else "Impossible")