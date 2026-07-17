def sumar(a,b):
    return a+b

x = input("Ingresa un valor\n")

print x

x = int(x)

if x > 30:
    print "Es un gran numero"
else:
    print "No es lo suficientemente grande"

while x > 0:
    print x
    x = x - 1


print sumar(5,6)
