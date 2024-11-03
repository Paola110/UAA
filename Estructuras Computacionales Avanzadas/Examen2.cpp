/*
    Paola Montserrat Osorio García
    Se implementa el algoritmo de Warshall para crear las trayectorias entre los nodos del grafo
*/

#include <iostream>
using namespace std;


void imprimir_Matriz(int matrix[][5]) {
  int i, j;
  for (i = 0; i < 5; i++) {
    for (j = 0; j < 5; j++) {
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }
}

void Warshall(int matrix[][5]){
    cout << endl << "Trayectoria de warshall " << endl;
    
    int n = 5;
    int W[4][4];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            W[i][j] = matrix[i][j];
        }
    }

    for (int k = 0; k < n; k++){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                W[i][j] = W[i][j] || (W[i][k] && W[k][j]);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                    cout << W[i][j] << " ";
                    }
                    cout << endl;
                }
            }
        }
    } 

}

int main() {
    // Matriz de adyacencia del grafo
  int Matriz_adyacencia[5][5] = {
    {0, 0, 0, 1, 0},
    {1, 0, 1, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 1, 1, 0, 0},
    {1, 0, 0, 0, 0}};

    cout<< "Descripcion del Programa: "<<endl;
    cout<< "Se crea una matriz de adyacencia y us recorridos segun el algoritmo de Warshall"<<endl;

    Warshall(Matriz_adyacencia);
  return 0;
}