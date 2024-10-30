def solution(record):
    answer = []
    user_name = { }
    for s in record:
        arr = s.split()
        if arr[0] == "Leave": continue
        user_name[arr[1]] = arr[2]
    ret = []
    for s in record:
        arr = s.split()
        name = user_name[arr[1]]
        if arr[0] == "Change": continue
        elif arr[0] == "Leave":
            ret.append(f"{name}님이 나갔습니다.")
        else:
            ret.append(f"{name}님이 들어왔습니다.")
    return ret
# 채팅방 입장 메세지
# 채팅방 퇴장 메세지
# 이름변경 -> 퇴장 후 이름 변경, 방에서 이름 변경
# 방에서 변경시 기존에 출력된 메세지도 이름 변경
# 모든 처리 후 최종적으로 보게 될 메세지

# uid - 이름으로 저장 
# 입장 Enter
# 퇴장 Leave
# 이름변경 Change
# 모든 기록에 대하여 아이디에 대한 이름 저장
# 모든 기록에 대하여 아이디에 해당 문자열 저장
# 
