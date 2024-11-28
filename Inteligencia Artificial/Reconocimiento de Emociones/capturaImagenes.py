import time
import os
from cv2 import imshow, imwrite, destroyWindow, cvtColor, resize, COLOR_BGR2GRAY, INTER_CUBIC
from cv2 import VideoCapture, CascadeClassifier, data

# Clasificador preentrenado de rostros frontales
faceClassifier = CascadeClassifier(data.haarcascades + 'haarcascade_frontalface_default.xml')

# Iniciar captura de webcam
# De tener más de una camara conectada, usar cam_port para especificar entrada
cam_port = 0
cam = VideoCapture(cam_port)

def obtenerRostros(emocion, count, countMax):
    while True:
        # Obtener input de webcam
        result, image = cam.read()

        # Si la captura es correcta
        if result:
            # Obtener imagen escala de grises
            gray = cvtColor(image, COLOR_BGR2GRAY)
            # Encontrar rostros
            faces = faceClassifier.detectMultiScale(gray, scaleFactor=1.3, minNeighbors=5)

            # Por cada rostro encontrado en la imagen
            for (x, y, w, h) in faces:
                print(f"Número de foto {count}")
                
                rostroEncontrado = gray[y:y+h , x:x+w]
                rostroEncontrado = resize(rostroEncontrado, (48, 48), interpolation=INTER_CUBIC)
                # Guardar imagen en la carpeta mencionada 
                
                imwrite(f"Inteligencia Artificial/Reconocimiento de Emociones/Database/{emocion}/{emocion}_{count}.png", rostroEncontrado)
                # Mostrar resultado
                imshow(f"WebcamTest_{count}", rostroEncontrado)
                time.sleep(0.0167)
                destroyWindow(f"WebcamTest_{count}")
                count = count + 1
            if count >= countMax : return

        # Si hubo un error de captura
        else: 
            print("No image detected. Please! try again")

e = {"enojo", "felicidad", "neutral", "sorpresa", "tristeza"}

for emocion in e:
    print(f"Grabando para '{emocion}'. Presiona una tecla para continuar")
    input()
    # Manejar indices de imagenes
    count = 0
    while os.path.exists(f"Inteligencia Artificial/Reconocimiento de Emociones/Database/{emocion}/{emocion}_{count}.png"):
        count += 1
    countMax = count + 200
    obtenerRostros(emocion, count, countMax)
    print("¿Deseas grabar imagenes para la siguiente emoción? [y]/n")
    k = input()
    if k == 'n':
        break
