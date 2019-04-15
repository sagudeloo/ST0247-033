def leer(resultados = list()):
    first_line = input().split()
    n = int(first_line[0])
    d = int(first_line[1])
    r = int(first_line[2])
    if n != 0 and d != 0 and r != 0:
        total_pay = 0
        hours_day = input().split()
        hours_night = input().split()
        for i in range(n):
            total_driver = int(hours_day[i]) + int(hours_night[i])
            total_pay += (total_driver-d)*r if total_driver-d > 0 else 0
        resultados.append(total_pay)
        return leer(resultados)
    return resultados

for i in leer():
  print(i)
