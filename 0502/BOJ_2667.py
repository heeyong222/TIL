import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
dx = [-1,1,0,0]
dy = [0,0,1,-1]
total = 0
l = []
answer = []
# 배열 입력
for _ in range(n):
    l.append(list(map(int, input().strip())))

# BFS
def bfs(x,y):
    queue = deque()
    queue.append([x,y])
    l[x][y] = 0
    cnt = 1
    while queue:
        a = queue[0][0]
        b = queue[0][1]
        queue.popleft()
        for i in range(4):
            startx = a+dx[i]
            starty = b+dy[i]
            if 0<=startx<n and 0<=starty<n and l[startx][starty] == 1:
                cnt += 1
                l[startx][starty] = 0
                queue.append([startx, starty])
    answer.append(cnt)

for i in range(n):
    for j in range(n):
        if l[i][j] == 1:
            bfs(i,j)
            total += 1

print(total)
answer.sort()
for ans in answer:
    print(ans)