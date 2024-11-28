def eliminar_espacios(cadena):
    return cadena.replace(" ", "")

# Solicitar cadena al usuario
cadena = input("Ingresa una cadena: ")

# Eliminar espacios
resultado = eliminar_espacios(cadena)

# Mostrar el resultado
print("Cadena sin espacios:", resultado)
