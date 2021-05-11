n = int(input())
p = [[0]*(n+1)]+[[0]+list(map(int, input().split())) for _ in range(n)]
d = [[[0]*3 for _ in range(n+1)] for _ in range(n+1)]
print(p)
def solve():
    d[1][2][0] = 1
    for i in range(1, n+1):
        for j in range(1, n+1):
            if j < n and not p[i][j+1]:
                d[i][j+1][0] += d[i][j][0] + d[i][j][2]
            if i < n and not p[i+1][j]:
                d[i+1][j][1] += d[i][j][1] + d[i][j][2]
            if i < n and j < n and not (p[i+1][j] or p[i][j+1] or p[i+1][j+1]):
                d[i+1][j+1][2] += d[i][j][0] + d[i][j][1] + d[i][j][2]

solve()
print(d[n][n])
print(sum(d[n][n]))

