t = int(input())


def bus(k, n, m):
    cnt = 0
    now = 0
    charge = [False] * (int(n) + 1)
    tmp = list(map(int, input().split()))
    for s in tmp:
        charge[s] = True
    while True:
        if now+k <= n and charge[now+k] == True:
            now = now+k
            cnt += 1
        elif now+k == n:
            break;
        else:
            for j in range(1, k):
                if now+k-j <= n and charge[now+k-j] == True:
                    now = now+k-j
                    cnt += 1
                    break;
                elif now+k-j == n:
                    return cnt
                elif j == k-1 and charge[now+k-j] != True:
                    return 0



    return cnt

for i in range(t):
    k, n, m = map(int, input().split())

    ans = bus(k, n, m)
    print('#'+str(i+1)+' '+ str(ans))
