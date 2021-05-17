t = int(input())

for i in range(t):
    l = list(input())
    a1 = int(''.join(l[:2]))
    a2 = int(''.join(l[2:]))
    if a1 > 12 and a2 <= 12:
        print(f'#{i+1} YYMM')
    elif a1 <= 12 and a2 > 12:
        print(f'#{i+1} MMYY')
    elif a1 <= 12 and a2 <= 12:
        print(f'#{i+1} AMBIGUOUS')
    elif a1 > 12 and a2 > 12:
        print(f'#{i+1} NA')