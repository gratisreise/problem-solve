import sys
from collections import defaultdict
ip, op = sys.stdin, sys.stdout

n, q = map(int, ip.readline().rstrip().split())

ptoi = defaultdict(int) # 비둘기 -> 위치
itop = defaultdict(set) # 위치 -> 비둘기들
for _ in range(q):
    cmd = ip.readline().rstrip().split()
    if cmd[0] == '1': # a비둘기 -> b로 둥지변경
        a, b = int(cmd[1]), int(cmd[2])
        if a not in ptoi:
            ptoi[a] = a
            itop[a].add(a)
        if b not in ptoi:
            ptoi[b] = b
            itop[b].add(b)
        ptoi[a] = b
        itop[a].discard(a)
        itop[b].add(a)
    elif cmd[0] == '2':
        a, b = int(cmd[1]), int(cmd[2])
        if a not in ptoi:
            ptoi[a] = a
            itop[a].add(a)
        if b not in ptoi:
            ptoi[b] = b
            itop[b].add(b)
        #비둘기 위치변경
        for p in list(itop[a]): ptoi[p] = b
        for p in list(itop[b]): ptoi[p] = a
        temp = itop[a]
        itop[a] = itop[b]
        itop[b] = temp
    elif cmd[0] == '3':
        a = int(cmd[1])
        if a not in ptoi:
            ptoi[a] = a
            itop[a].add(a)
        op.write(f'{ptoi[a]}\n')

"""
최대 숫자 30만개
30만번돌아서 쓰이는 숫자만 생성

N(1~100만), Q(1~30만)
반드시 하나의 타입3는 있다
1 a b: a비둘기를 b둥지로 이동
2 a b: a->b, b->a 두이동 동시에
3 a: 비둘기 a가 현재있는 둥지의 번호 출력
모든 타입3에 대한 출력을 해라

비둘기 -> 둥지
둥지 -> {}
#1
비둘기의 둥지위치 바꾸기 -> 바꾸기
기존둥지에서 비둘기 없애기 -> 차집합으로
바뀐둥지에 비둘기 넣기 -> add

#2
a에 있는 비둘기 위치변경
b에 있는 비둘기들 b로 위치변경
a -> temp
a -> b
b -> temp




"""