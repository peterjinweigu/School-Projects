import sys
import math


def factor(num):
    num = abs(num)
    factors = [1, num]
    if num == 1:
        return factors
    elif num == 2:
        return factors
    elif num == 3:
        return factors
    for x in range(1, int(math.sqrt(num))+1):
        if x == 1:
            continue
        elif num % x == 0:
            factors.append(x)
            if num/x != x:
                factors.append(num/x)
    return factors


class Number:
    def __init__(self, degree, number):
        self.degree = degree
        self.number = number


print("Degree")

f = []
p = []
ans = []

n = int(sys.stdin.readline())

print("Coefficient from least to greatest degree; constant first")

for i in range(n+1):
    p.append(Number(i, float(sys.stdin.readline())))

coi = factor(p[-1].number)
cos = factor(p[0].number)


for j in cos:
    for k in coi:
        f.append(j/k)
        f.append(-j/k)

f = set(f)

for item in f:
    total = 0
    for var in p:
        total += (item**var.degree)*var.number
    if total == 0:
        ans.append(item)

for o in ans:
    print(o, end=' ')


