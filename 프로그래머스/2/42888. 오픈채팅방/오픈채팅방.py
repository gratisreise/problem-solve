def solution(record):
    answer = []
    uid = {}
    
    for line in record: # record의 각 줄을 하나씩 처리
        cmd = line.split(" ")
        
        if cmd[0] != "Leave": # Enter 또는 Change인 경우
            uid[cmd[1]] = cmd[2]
    for line in record: #record의 각 줄을 하나씩 처리
        cmd = line.split(" ")
        # 각 상태에 맞느 메세지를 answer에 저장
        if cmd[0] == "Enter":
            answer.append("%s님이 들어왔습니다." %uid[cmd[1]])
        elif cmd[0] == "Change":
            pass
        else:
            answer.append("%s님이 나갔습니다." %uid[cmd[1]])
    return answer
    
# 1.최종적으로 구하고자 하는 건 뭐지? -> 최종메세지
# 2.입력값 중 수정되지 않는 건 뭐지? -> 유저 아이디
# 3.입력값 중 수정되는 건 뭐지? -> 닉네임
#   3-1.입력값이 수정될 때 어디가 영향받지? -> 오픈 채팅방의 내용 변경
#   3-2.입력값은 어느 조건에서 수정되지? -> Enter와 Change인 경우