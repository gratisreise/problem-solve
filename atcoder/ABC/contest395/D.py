import sys

input = sys.stdin.readline
print = sys.stdout.write

# 입력: 비둘기/둥지 수 N, 연산 수 Q
N, Q = map(int, input().split())

# 둥지 -> 논리적 라벨 매핑 (초기: 둥지 i -> 라벨 i)
box_to_label = list(range(N))  # 0-based
# 라벨 -> 물리적 둥지 매핑 (초기: 라벨 i -> 둥지 i)
label_to_box = list(range(N))  # 0-based
# 비둘기 -> 물리적 둥지 매핑 (초기: 비둘기 i -> 둥지 i)
pigeon_to_box = list(range(N))  # 0-based

# 연산 처리
for _ in range(Q):
    op = list(map(int, input().split()))
    op_type = op[0]
    
    if op_type == 1:  # Type 1: 비둘기 a를 둥지 b로 이동
        a, b = op[1] - 1, op[2] - 1  # 1-based -> 0-based
        pigeon_to_box[a] = label_to_box[b]  # 비둘기 a를 b의 논리적 둥지로
    
    elif op_type == 2:  # Type 2: 둥지 a와 b 교환
        a, b = op[1] - 1, op[2] - 1  # 1-based -> 0-based
        # 라벨 -> 둥지 매핑 교환
        label_to_box[a], label_to_box[b] = label_to_box[b], label_to_box[a]
        # 둥지 -> 라벨 매핑 갱신
        box_to_label[label_to_box[a]], box_to_label[label_to_box[b]] = a, b
    
    elif op_type == 3:  # Type 3: 비둘기 a의 현재 둥지 출력
        a = op[1] - 1  # 1-based -> 0-based
        current_nest = box_to_label[pigeon_to_box[a]] + 1  # 0-based -> 1-based
        
        print(f"{current_nest}\n")


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


a  -> a' | b  -> b'
a' -> a  | b' -> b
------------------
a' -> b  | b' -> a
a  -> b' | b  -> a'
"""