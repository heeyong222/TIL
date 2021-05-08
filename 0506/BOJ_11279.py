import heapq
import sys
input = sys.stdin.readline
n = int(input())
heap = []
for i in range(n):
    inp = int(input())
    if inp == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    elif inp > 0:
        heapq.heappush(heap, (-inp, inp))