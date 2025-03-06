s = input().strip()
i = 0
is_good = True

while i < len(s):
    if i + 2 <= len(s) and (s[i:i+2] == 'pi' or s[i:i+2] == 'ka'):
        i += 2
    elif i + 3 <= len(s) and s[i:i+3] == 'chu':
        i += 3
    else:
        is_good = False
        break

# 문자열 끝까지 도달했는지 확인
if is_good and i == len(s):
    print("YES")
else:
    print("NO")