import sys
from collections import defaultdict
ip, op = sys.stdin, sys.stdout
def check(p, f, s, v):
    return p >= mp and f >= mf and s >= ms and v >= mv
n = int(ip.readline().rstrip())
mp, mf, ms, mv = map(int, ip.readline().rstrip().split())
data = []
for _ in range(n):
    data.append(tuple(map(int, ip.readline().rstrip().split())))

ret = 1e9
ans = defaultdict(list)
for i in range(1, 1 << n):
    sump, sumf, sums, sumv, sumc = [0]*5
    temp = []
    for j in range(n):
        if i & (1 << j):
            sump += data[j][0]
            sumf += data[j][1]
            sums += data[j][2]
            sumv += data[j][3]
            sumc += data[j][4]
            temp.append(j+1)

    if sumc <= ret and check(sump, sumf, sums, sumv) :
        ret = sumc
        ans[sumc].append(tuple(temp))
if ret == 1e9: op.write("-1\n")
else:
    ans = sorted(ans[ret])
    op.write(f'{ret}\n')
    op.write(' '.join(map(str, sorted(ans[0])))+'\n')






"""
디폴트 딕셔너리 선언방법
최소비용출력, 
최소비용일 때의 식재료 번호 공백+오름차순
같은 비용하나이상일때는 사전순으로 가장 빠른것

1. 15개 원소의 부분집합마다 -> 비트마스킹
2. 영양소기준 충족하는지확인 ->
3. 최소값 충족확인
4. 다르면 해당 값의 리스트에 저장
5. ret의 값이 초기화값과 같으면 -1반환
6. 다르면 최소값의 리스트를 정렬

"""