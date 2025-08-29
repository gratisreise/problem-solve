import re

n = int(input())
pattern = input().replace('*', '.*')  # *을 .*로 치환
regex = re.compile('^' + pattern + '$')  # 정규 표현식 컴파일

for _ in range(n):
    s = input()
    if regex.match(s):
        print('DA')
    else:
        print('NE')
"""
시간 3배차이??
"""