import time

n = 1000
s = [0] * n
f = [0] * n

def RecursiveActivitySelector(k,n):
    m = k + 1
    while m <= n and s[m] < f[k]:
        m = m + 1
    if m <= n:
        return {m}.union(RecursiveActivitySelector(m,n))
    return {}

def GreedyActivitySelector(n):
    k = 1
    A = {0}
    for m in range(1,n):
        if s[m] >= f[k]:
            A = A.union({m})
            k = m
    return A

def InitializeArrays(n):
    for i in range(1, n):
        if (i % 2 == 0):
            s[i] = f[i-2]
            f[i] = s[i] + 2
        else:
            s[i] = f[i-1]
            f[i] = f[i-1] + 1


fo = open("output.txt", "w")
InitializeArrays(n)

for i in range(1,n):
    TimeRecursive = 0
    TimeIterative = 0

    for j in range(1,n):
        start = time.perf_counter()
        RecursiveActivitySelector(0, i-1)
        TimeRecursive += time.perf_counter() - start
        

        start = time.perf_counter()
        GreedyActivitySelector(i-1)
        TimeIterative += time.perf_counter()
    fo.write("{},{}\n".format(i, TimeRecursive/TimeIterative))
    print('Iteration...{}\r'.format(i), end='')
