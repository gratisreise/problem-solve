S = list(input())

for i,c in enumerate(S):
    if c.isupper():
        S[i] = chr((ord(c) - ord('A') + 13)%26 + ord('A'))
    elif c.islower():
        S[i] = chr((ord(c) - ord('a') + 13)%26 + ord('a'))
print(''.join(S))