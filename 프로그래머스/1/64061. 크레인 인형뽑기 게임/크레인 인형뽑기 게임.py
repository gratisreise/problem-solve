def solution(board, moves):
    baguni = []
    row, col = len(board), len(board[0])
    ret = 0
    for m in moves:
        pos = m - 1
        for j in range(row):
            if board[j][pos] != 0:
                if baguni and baguni[-1] == board[j][pos]:
                    baguni.pop()
                    ret += 1
                else:
                    baguni.append(board[j][pos])
                board[j][pos] = 0
                break
    return ret * 2
            


"""
인형 없는 곳에서 크레인 작동 안줄거임
터트려져 사라진 인형의 갯수를 리턴

1. move의 위치에서 인형뽑기
2. 바구니 폭발
3. 폭발횟수 * 2 반환
"""