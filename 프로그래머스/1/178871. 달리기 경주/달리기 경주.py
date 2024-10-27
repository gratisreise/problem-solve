def solution(players, callings):
    # 선수 이름을 키로, 순위를 값으로 하는 딕셔너리 생성
    rank = {name: i for i, name in enumerate(players)}

    for call in callings:
        current_position = rank[call]          # 현재 순위 가져오기
        new_position = current_position - 1    # 추월 후의 새로운 순위 계산
        
        # 추월된 선수 이름과 위치 가져오기
        swapped_player = players[new_position]

        # 순위 및 players 리스트 업데이트
        players[new_position], players[current_position] = players[current_position], players[new_position]
        rank[call], rank[swapped_player] = new_position, current_position

    return players
