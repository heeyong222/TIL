t = int(input())

for i in range(t):
    n,m = map(int, input().split())
    l = list(map(int, input().split()))
    print('#'+str(i+1)+' ' +str(l[m % n]))

