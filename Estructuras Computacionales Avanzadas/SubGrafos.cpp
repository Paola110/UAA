/*
4 Octubre de 2024
Vanessa Reteguín  - 373355
Osorio García Paola Montserrat -
Pérez López Pablo David -

Práctica Nº3: Matriz de adyacencia

Universidad Autonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre III
Grupo 3 - E
Estructuras Computacionales Avanzadas
Luis Fernando Gutiérrez Marfileño

Instrucciones:

Crear un programa que implemente la representación del grafo de la Figura 3
mediante una matriz de adyacencia y realice algunas operaciones.

1. En las primeras líneas elabora comentarios con la siguiente información:
    i. Nombre de la institución
    ii. Nombre de la carrera
    iii. Nombre de la materia
    iv. Nombre(s) de quien(es) realiza(n) la práctica
    v. Nombre del profesor
    vi. Una descripción breve de lo que realiza el programa
2. Incluye las librerías necesarias.
3. Define la matriz de adyacencia.
4. Despliega en pantalla una descripción breve de lo que trata el programa.
5. Despliega en pantalla a la matriz de adyacencia. Implementa un
   procedimiento mediante el cual a partir de la matriz de adyacencia se genere
un subgrafo inducido y despliega en pantalla la matriz correspondiente.
7. Implementa un procedimiento mediante el cual a partir de la matriz de
   adyacencia se genere un subgrafo generador y despliega en pantalla la matriz
   correspondiente.
8. Implementa un procedimiento mediante el cual a partir de la matriz de
   adyacencia se genere un subgrafo recubridor y despliega en pantalla la matriz
   correspondiente. (Vane -> Listo!)
*/

#include <iostream>
using namespace std;

void printMatrix(int matrix[][6]) {
  int i, j;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }
}

void fillMatrix(int matrix[][6], int item) {
  int i, j;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
      matrix[i][j] = item;
    }
  }
}

void generateCoveringGraph(int inputMatrix[][6], int outputMatrix[][6]) {
  int i, j;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
      outputMatrix[i][j] = inputMatrix[i][j];
      if ((inputMatrix[i][j] == 1 && j == (i + 1)) ||
          (inputMatrix[i][j] == 1 && j == (i - 1))) {
        outputMatrix[i][j] = 1;
      } else {
        outputMatrix[i][j] = 0;
      }
    }
  }
}

void generateGenerativeGraph(int inputMatrix[][6], int outputMatrix[][6]){
	int i=0, j=0;
	bool nodo_central = false; // Verifica si puede ser el nodo al que estaran conectados los demas
		
	for (i = 0; i < 6; i++) {
		nodo_central = true;
		
	    for (j = 0; j < 6; j++) {
	    	if ( j != i && inputMatrix[i][j]!= 1){
	    		nodo_central = false;
	    		outputMatrix[i][j] = 0;
			} else {
				outputMatrix[i][j] = 1;
			}
	    }
	    
	    if (nodo_central){
	    	cout << endl << "Grafo generativo (llenado)" << endl;
  			printMatrix(outputMatrix);
  			break;
		} else {
			fillMatrix(outputMatrix,0);
		}
	}
	if (!nodo_central){
		cout <<endl<<"No tiene las condiciones para tener un subgrafo generativo"<<endl<<"Ningun nodo tiene conexion con todos los demas"<<endl;
	}
}

int main() {
  int i, j;
  int graphMatrix[6][6] = {
      {0, 1, 0, 0, 1, 1},
      {1, 0, 1, 1, 0, 0},
      {0, 1, 0, 1, 0, 0},
      {0, 1, 1, 0, 1, 0},
      {1, 0, 0, 1, 0, 1},
      {1, 0, 0, 0, 1, 0}};  // Matrìz de adyacencia del grafo original

  int coveringGraph[6][6];
  fillMatrix(coveringGraph, 0);
  
  int generativeGraph [6][6];
  fillMatrix(generativeGraph, 0);

  cout << endl << "Matriz de adyacencia (Grafo figura 3)" << endl;
  printMatrix(graphMatrix);

  cout << endl << "Grafo recubridor (llenado)" << endl;
  generateCoveringGraph(graphMatrix, coveringGraph);
  printMatrix(coveringGraph);
  
  generateGenerativeGraph(graphMatrix, generativeGraph);

  return 0;
}