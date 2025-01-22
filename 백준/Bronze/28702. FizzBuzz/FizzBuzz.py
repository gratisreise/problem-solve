data = []
for _ in range(3):
    data.append(input())
for i,s in enumerate(data):
    if ord(s[0]) < ord('A'):
        k = int(s) + (3 - i)
if k % 3 == 0 and k % 5 == 0:
    print("FizzBuzz")
elif k % 3 == 0 and k % 5 != 0:
    print("Fizz")
elif k % 3 != 0 and k % 5 == 0:
    print("Buzz")
else: print(k)