s = input()

ret = set()
for k in range(1, len(s) + 1):
    temp = []
    for i in range(len(s) - k + 1):
        ret.add(s[i:i+k])
print(len(ret))