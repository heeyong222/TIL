t = int(input())

for i in range(t):
    t1 = 0
    t2 = 0
    n, m = map(int, input().split())
    l = list(map(int, input().split()))
    for j in range(m):
        t1 += l[j] # 최대값
        t2 += l[j] # 최소값
    for k in range(n-m+1):
        tmp = 0
        for hap in range(m):
            tmp += l[k+hap]
        t1 = max(tmp, t1)
        t2 = min(tmp, t2)


    print('#'+str(i+1)+' '+ str(t1-t2))