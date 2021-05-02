n = int(input())

for i in range(1,n+1):
    tmp = str(i)

    cnt = 0
    for j in tmp:
        if j == '3' or j == '6' or j == '9':
            cnt += 1
    if cnt == 0:
        print(i,end=" ")
    elif cnt > 0:
        print('-'*cnt, end=" ")

