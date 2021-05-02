n = int(input())
l = []
l2 = []
for i in range(n):
    l.append(int(input()))
    l.sort()

    if len(l) == 1:
        l2.append(l[0])
    elif len(l) > 1:
        if len(l)%2 == 0:
            l2.append(l[len(l)//2-1])
        elif len(l)%2 == 1:
            l2.append(l[len(l)//2])



for j in range(len(l2)):
    print(l2[j])