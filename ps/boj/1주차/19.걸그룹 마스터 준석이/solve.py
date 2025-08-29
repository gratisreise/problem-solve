from collections import defaultdict

n, m = map(int, input().split())
ret1 = defaultdict(list)
ret2 = {}

# 걸그룹과 멤버 정보 입력
for _ in range(n):
    team, t = input(), int(input())
    members = [input() for _ in range(t)]  # 멤버 이름 리스트 입력
    ret1[team] = sorted(members)  # 팀 이름으로 멤버 리스트 저장 (정렬)
    for member in members:
        ret2[member] = team  # 멤버 이름으로 팀 이름 저장

# 문제 처리
for _ in range(m):
    string = input()  # 팀 이름 또는 멤버 이름 입력
    num = int(input())  # 문제 유형 입력 (0: 팀 이름, 1: 멤버 이름)
    if num == 0:  # 팀 이름으로 멤버 리스트 출력
        print('\n'.join(ret1[string]))
    else:  # 멤버 이름으로 팀 이름 출력
        print(ret2[string])