import sys

ip, op = sys.stdin, sys.stdout

def main():
    # 입력을 읽고 공백으로 분할
    data = ip.read().split()
    N, K = int(data[0]), int(data[1])  # N: 배열 크기, K: 최소 개수 조건
    A = list(map(int, data[2:]))  # 주어진 배열 A
    
    M = max(A)  # 배열 A에서 최대값을 찾음
    
    # 배열 초기화 (M+1 크기)
    s = [0] * (M + 1)  # 각 숫자의 등장 횟수를 저장
    t = [0] * (M + 1)  # 약수 d를 가지는 수의 개수를 저장
    u = [0] * (M + 1)  # 최적의 d 값을 저장
    
    # A에 등장하는 숫자들의 빈도를 계산
    for a in A:
        s[a] += 1
    
    # 각 숫자 d가 약수로 포함된 숫자의 개수를 계산
    for d in range(1, M + 1):  # 1부터 M까지
        for n in range(d, M + 1, d):  # d의 배수인 모든 숫자에 대해
            t[d] += s[n]  # t[d]에 s[n]을 누적 (d를 약수로 가진 숫자의 개수)
    
    # 각 숫자 n에서 최적의 d 값을 찾기
    for d in range(1, M + 1):  # 1부터 M까지
        if t[d] < K:  # K개 이상 존재하지 않으면 건너뜀
            continue
        for n in range(d, M + 1, d):  # d의 배수에 대해
            u[n] = max(u[n], d)  # 현재 최댓값과 비교하여 저장
    
    # 결과 출력
    op.write('\n'.join(map(str, (u[a] for a in A))) + '\n')




"""
못푼이유:

어떤 값 x를 최대공약수(GCD)로 만들 수 있으려면 다음 조건을 만족해야한다
1. A가 x로 나누어 떨어져야한다.
2. x로 나누어 떨어지는 원소가 적어도 K개 있어야 한다.
3. 그런 x 값 중 최댓값이 정답이다.



"""