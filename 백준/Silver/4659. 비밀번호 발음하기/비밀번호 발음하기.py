def isMo(c):
    return c == 'a' or c == 'e' or c =='o' or c=='i' or c == 'u'
while True:
    s = input()
    if s == 'end': break
    cnt_j, cnt_m, prev, cnt = 0, 0, '', 0
    flag = 0
    for c  in s:
        if isMo(c): 
            cnt_m += 1 
            cnt += 1
            cnt_j = 0
        else: 
            cnt_j += 1
            cnt_m = 0
        if cnt_j >= 3 or cnt_m >= 3:
            flag = 1
            break
        if prev != '' and c != 'e' and c != 'o' and prev == c:
            flag = 1
            break
        prev = c
    if flag:
        print(f"<{s}> is not acceptable.")
    else:
        if cnt == 0:
            print(f"<{s}> is not acceptable.")
        else:
            print(f'<{s}> is acceptable.')