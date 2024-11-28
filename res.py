# Inicializar lista para almacenar los datos de entrada
data = []

print("Ingresa 25 líneas:")

# Solicitar las 26 líneas de entrada
for _ in range(25):
    line = input().strip()
    data.append(line)

# Procesar los datos de entrada
results = []

for line in data:
    #parts = line.split("	")  # Dividir la línea por tabulaciones
    parts = line.split(",")  # Dividir la línea por tabulaciones
    letter = parts[0]
    col2 = float(parts[1])
    col3 = float(parts[2])
    result = col2 * col3  # Multiplicar segunda y tercera columnas
    results.append(result)

# Generar y mostrar los resultados
output = ",".join(f"{r:.6f}" for r in results)
print("\nResultados:")
print(output)
