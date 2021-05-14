tc = int(input())
l = ['0000','0001','0010','0011','0100','0101','0110','0111','1000',
     '1001','1010','1011','1100','1101','1110','1111']
for i in range(tc):
    answer = ''
    n, m = input().split()
    for j in m:
        if j.isdigit() == True and int(j) < 10:
            answer += l[int(j)]
        elif j == 'A':
            answer += l[10]
        elif j == 'B':
            answer += l[11]
        elif j == 'C':
            answer += l[12]
        elif j == 'D':
            answer += l[13]
        elif j == 'E':
            answer += l[14]
        elif j == 'F':
            answer += l[15]
    print('#{} {}'.format(i+1, answer))