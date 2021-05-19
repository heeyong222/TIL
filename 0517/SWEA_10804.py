n = int(input())

for j in range(n):
    l = []
    s = input()
    slist = list(s)
    slist.reverse()
    for i in slist:
        if i == 'b':
            l.append('d')
        elif i == 'd':
            l.append('b')
        elif i == 'p':
            l.append('q')
        elif i == 'q':
            l.append('p')
    ans = ''.join(l)
    print('#'+str(j+1) + ' ' +ans)