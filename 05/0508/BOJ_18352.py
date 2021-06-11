import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)
n, m, k, start= map(int, input().split())


graph = [[] for i in range(n+1)]

distance = [INF] * (n+1)

for _ in range(m):
    a, b= map(int, input().split())
    graph[a].append((b,1))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)
cnt = 0
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        cnt += 1
    else:
        pass
if cnt == 0:
    print(-1)
