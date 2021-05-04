import sys

input = sys.stdin.readline

computer = int(input())
network = int(input())
virus = [[0 for _ in range(computer+1)] for _ in range(computer+1)]

for _ in range(network):
    x, y = map(int, input().split())
    virus[x][y] = 1
    virus[y][x] = 1

def bfs(virus, start):
    queue = [start]
    visited = []

    while queue:
        temp = queue.pop(0)
        visited.append(temp)

        for i in range(len(virus)):
            if virus[temp][i] and i not in visited and i not in queue:
                queue.append(i)

    return len(visited) -1

print(bfs(virus, 1))