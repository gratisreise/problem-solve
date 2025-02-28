from collections import Counter

# 입력: 두 문자열
str1, str2 = input(), input()

# 두 문자열의 문자 빈도 계산
freq1 = Counter(str1)
freq2 = Counter(str2)

# 제거해야 할 문자 수 계산
# 두 Counter의 차이와 합집합에서 빈도 차이 합산
remove_count = sum((freq1 - freq2).values()) + sum((freq2 - freq1).values())

# 결과 출력
print(remove_count)

"""
빈도수 계산 아이디어
집합의 개념으로
s1제거 갯수 + s2제거 개수
"""