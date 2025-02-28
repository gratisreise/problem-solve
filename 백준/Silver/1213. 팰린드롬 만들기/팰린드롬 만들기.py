s = input()
counts = [0] * 26
for char in s:
    counts[ord(char) - ord('A')] += 1

odd_count = 0
odd_char = ''
for i in range(26):
    if counts[i] % 2 != 0:
        odd_count += 1
        odd_char = chr(i + ord('A'))
        counts[i] -= 1

if odd_count > 1:
    print("I'm Sorry Hansoo")
else:
    result = ''
    for i in range(26):
        result += chr(i + ord('A')) * (counts[i] // 2)
    
    if odd_char:
        print(result + odd_char + result[::-1])
    else:
        print(result + result[::-1])