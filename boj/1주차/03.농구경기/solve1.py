n = int(input())

cnt = [0] * 26

for _ in range(n):
    cnt[ord(input()[0]) - ord('a')] += 1

# 결과를 리스트 컴프리헨션으로 생성
ret = [chr(i + ord('a')) for i in range(26) if cnt[i] >= 5]

print(''.join(ret) if ret else 'PREDAJA')
