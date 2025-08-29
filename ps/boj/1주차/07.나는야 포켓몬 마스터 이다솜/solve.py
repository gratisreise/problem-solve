import sys

ip, op = sys.stdin, sys.stdout

n, m = map(int, ip.readline().split())

# 이름과 번호를 모두 저장할 딕셔너리
data = {}

# 포켓몬 이름 입력 및 딕셔너리 구성
for i in range(1, n + 1):
    s = ip.readline().rstrip()
    data[s] = i  # 이름 → 번호 매핑
    data[str(i)] = s  # 번호 → 이름 매핑

# 문제 처리
for _ in range(m):
    s = ip.readline().rstrip()
    op.write(f"{data[s]}\n")  # 이름 또는 번호에 해당하는 값 출력

