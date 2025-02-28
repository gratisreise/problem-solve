A, B, C = map(int, input().split())

#시간대별 트럭 대수 저장
cnt = [0]*101

# 3개의 트럭의 시간대 기록
for _ in range(3):
    a, b = map(int, input().split())
    for i in range(a, b): cnt[i] += 1

#요금계산
ret = sum([0, A, 2*B, 3*C][num] for num in cnt)
print(ret)