# Importación de librerías necesarias para preprocesamiento, 
# división de datos, modelo de clasificación, métricas y balanceo de datos
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report
from imblearn.over_sampling import SMOTE
import numpy as np
import pandas as pd

# Cargar el conjunto de datos desde un archivo Excel
df = pd.read_excel("C:/Users/monts/OneDrive/Escritorio/UAA/Inteligencia Artificial/VIH/dataset_VIH.xlsx")

# Rellenar valores faltantes con cero
df.fillna(0, inplace=True)

# Eliminar la última columna (sumatoria)
df.drop(df.columns[-1], axis=1, inplace=True)

# Seleccionar las características excluyendo la primera (amino ácido) y la última (clasificación)
features = df.columns[1:-1]  

# Convertir columnas a tipo numérico, manejando valores no numéricos
for col in features:
    df[col] = pd.to_numeric(df[col], errors='coerce')

# Rellenar nuevamente valores faltantes con cero
df.fillna(0, inplace=True)

# Normalizar las características usando StandardScaler
scaler = StandardScaler()
df[features] = scaler.fit_transform(df[features])

# Función para convertir la variable objetivo
# Convierte 'R5X4' a 1 (positivo) y cualquier otro valor a 0 (negativo)
def target_value(x):
    if isinstance(x, str):
        return 1 if x.strip() == 'R5X4' else 0
    return 0

##### APRENDIZAJE SUPERVISADO (se muestra al entrenar con etiquetas de clase)

# Preparar características (X) y variable objetivo (y)
X = df[features]  
y = df['clase'].apply(target_value)  

# Aplicar SMOTE para balancear el conjunto de datos
# Ayuda a manejar el desbalance de clases usando sobremuestreo
smote = SMOTE(random_state=42)
X_resampled, y_resampled = smote.fit_resample(X, y)

# Dividir los datos en conjuntos de entrenamiento y prueba
# Estratificación para mantener la proporción de clases
X_train, X_test, y_train, y_test = train_test_split(X_resampled, y_resampled, 
                                                    test_size=0.2, 
                                                    random_state=42, 
                                                    stratify=y_resampled)

# Crear y entrenar un modelo de Random Forest
# 100 árboles de decisión para mejorar la precisión y reducir el sobreajuste
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Hacer predicciones en el conjunto de prueba
y_pred = model.predict(X_test)

# Imprimir métricas de clasificación (precisión, recall, f1-score)
print(classification_report(y_test, y_pred))

# Preparar nuevos datos de aminoácidos para predicción
new_amino_acids = [
    # Lista de vectores de características para diferentes aminoácidos
    [31.432432,0,3.603604,8.108108,57.657658,14.414414,44.144144,0.900901,152.252252,109.009009,22.522523,3.603604,90.09009,0,8.108108,8.108108,44.144144,72.972973,44.144144,0,57.657658,0.900901,0,0.900901,0], 
    # ... más aminoácidos ...
]

# Crear un DataFrame con los nuevos aminoácidos
new_amino_acids_df = pd.DataFrame(new_amino_acids, columns=features)

# Escalar los nuevos datos usando el mismo escalador
new_amino_acid_scaled = scaler.transform(new_amino_acids_df)

# Predecir la clasificación de los nuevos aminoácidos
prediction = model.predict(new_amino_acid_scaled)

# Imprimir resultados de las predicciones
for i, a in enumerate(new_amino_acids):
    print(f"\nAmino acid: {a}")
    if prediction[i] == 1:
        print("\tEl aminoácido es VIH positivo (R5X4).")
    else:
        print("\tEl aminoácido no es VIH positivo.")

# Mostrar de nuevo el informe de clasificación
print(classification_report(y_test, y_pred))