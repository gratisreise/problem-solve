import sys

ip, op = sys.stdin, sys.stdout

n = int(ip.readline())
employees = set()  # 집합 사용

for _ in range(n):
    name, action = ip.readline().rstrip().split()
    if action == 'enter':
        employees.add(name)
    else:
        employees.discard(name)  # discard는 요소가 없어도 에러가 발생하지 않음

result = sorted(list(employees), reverse=True)  # 리스트 컴프리헨션 및 정렬 최적화
op.write('\n'.join(result) + '\n')