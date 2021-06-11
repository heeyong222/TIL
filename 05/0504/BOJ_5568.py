from itertools import permutations
n = int(input())
k = int(input())
l = []
ans = []
for i in range(n):
    l.append(str(input()))
ans = list(permutations(l, k))
res = []
for i in range (len(ans)):
    tmp = ""
    for j in range(k):
        tmp += ans[i][j]
    if tmp not in res:

        res.append(tmp)

print(len(res))