import math
n = int(input());

for i in range(n):
    x = int(input());
    for j in range(2, int(math.sqrt(x) + 1)):
        if x % j == 0:
            print("%d is not prime" % x);
            break;
    else:
        print("%d is prime" % x);