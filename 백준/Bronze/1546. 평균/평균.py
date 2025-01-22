n, scores = int(input()), list(map(int, input().split()))
scores = list(map(lambda x: (x*100/max(scores)), scores))
print(sum(scores)/n)