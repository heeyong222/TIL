import sys
from collections import deque
input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
m, n = map(int, input().strip().split())
l = []
for _ in range(n):
    l.append(list(map(int, input().strip().split())))

def bfs(m,n,l):
    day = 0

    while queue:
        day += 1
        for _ in range(len(queue)):
            x, y = queue.popleft()
            for i in range(4):
                nx = x+dx[i]
                ny = y+dy[i]

                if 0<=nx<n and 0<=ny<m and l[nx][ny] == 0:
                    l[nx][ny] = l[x][y] + 1
                    queue.append([nx,ny])
        # print(l, day)
    for l1 in l:
        if 0 in l1:
            return -1
    return day-1




queue = deque()
for i in range(n):
    for j in range(m):
        if l[i][j] == 1:
            queue.append([i, j])

print(bfs(m, n, l))
