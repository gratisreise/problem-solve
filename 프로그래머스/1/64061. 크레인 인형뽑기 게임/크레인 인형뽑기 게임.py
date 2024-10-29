def solution(board, moves):
    row = len(board)
    stk = []
    ret = 0
    for i in moves:
        i = i-1
        for j in range(row):
            if board[j][i]:
                if stk and stk[-1] == board[j][i]:
                    stk.pop()
                    ret += 2
                else: stk.append(board[j][i])
                board[j][i] = 0
                break
    return ret
# 짝 발생 -> 폭파
# 인형이 없는 곳은 제끼기
# 크레인 위치 1 ~ 5
# 사라진 인형의 갯수 -> 폭발횟수 * 2
# 모든 move에 대해
# 해당 열에 대해 행을 순회
# 인형있으면 0으로 바꾸고 stk 체크
# 인형이없으면 그냥 통과
