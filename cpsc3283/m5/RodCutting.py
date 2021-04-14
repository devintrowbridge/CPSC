def CutRod(p, n, c):
    r = [-1] * (n+1)
    return CutRodAux(p, n, r, c)

def CutRodAux(p, n, r, c):
    q = -1
    if r[n] >= 0:
        return r[n]
    if n == 0:
        q = 0
    else: 
        for i in range(1,n+1):
            current = p[i] + CutRodAux(p, n-i, r, c)
            if i != n:
                current -= c
            q = max(q, current)
    r[n] = q
    return q

p = [0,1,5,8,9,10,17,17,20,24,30]
n = 10
c = 0

for i in range(0,len(p)):
    print(CutRod(p, i, c))