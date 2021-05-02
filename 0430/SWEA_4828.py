t = int(input())

for i in range(t):
    l = []
    n = int(input())
    l = list(map(int, input().split()))
    l.sort()
    ans = l[n-1] - l[0]
    print('#'+str(i+1)+' '+str(ans))
