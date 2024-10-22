str = input()
ret = list(str)
for i in range(len(ret)):
    if ret[i].isupper(): ret[i] = ret[i].lower()
    elif ret[i].islower(): ret[i] = ret[i].upper()
print(''.join(ret))