class NaiveFibonacci:
    calls = 0

    def compute(self, n):
        self.calls += 1
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.compute(n-1)  + self.compute(n-2) 

class Fibonacci:
    calls = 0
    fib = {0:0, 1:1}

    def compute(self, n):
        self.calls += 1

        if n in self.fib:
            return self.fib[n]

        n1 = self.fib[n-1] if (n-1) in self.fib else self.compute(n-1) 
        n2 = self.fib[n-2] if (n-2) in self.fib else self.compute(n-2) 

        self.fib[n] = n1 + n2

        return self.fib[n]

def FiboIterate(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    
    numbers = [0,1,1]
    for num in range(2,n+1):
        numbers[2] = numbers[0] + numbers[1]
        numbers[0] = numbers[1]
        numbers[1] = numbers[2]
    return numbers[2]

myFib = Fibonacci()
myNaiveFib = NaiveFibonacci()

print(myFib.compute(55))
print(FiboIterate(55))
print(myNaiveFib.compute(55))