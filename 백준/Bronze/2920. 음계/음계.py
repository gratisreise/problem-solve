a, b= [i+1 for i in range(8)], [8-i for i in range(8)]
case = list(map(int, input().split()))
print("ascending" if case == a else "descending" if case == b else "mixed")