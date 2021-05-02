import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    queue = deque()
    queue.append([x,y])
    while queue:
        a,b = queue[0][0], queue[0][1]
        queue.popleft()
        for i in range(4):
            q = a+dx[i]
            w = b+dy[i]
            if 0<=q<n and 0<=w<m and l[q][w] == 1:
                l[q][w] = 0
                queue.append([q,w])

for _ in range(t):
    m, n, k = map(int, input().split())
    l = [[0]*m for i in range(n)]
    cnt = 0
    for j in range(k):
        a, b = map(int, input().split())
        l[b][a] = 1
    for q in range(n):
        for w in range(m):
            if l[q][w] == 1:
                bfs(q,w)
                l[q][w] = 0
                cnt += 1
    print(cnt)
