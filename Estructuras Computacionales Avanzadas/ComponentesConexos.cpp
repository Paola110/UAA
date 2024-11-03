/*
18 octubre de 2024
Vanessa Reteguín - 373355
Paola Osorio - 216511
Pablo David Pérez López - 300452

Práctica #5

Universidad Aútonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre III

Grupo 2 - E
Estructuras Computacionales avanzadas
Luis Fernando Gutiérrez Marfileño  

Descripción del programa: TO DO
*/

#include <iostream>
using namespace std;

void diplayMenu() {
  cout << endl
       << "\n.--------------------------."
          "\n||       -{ MENU }-       ||"
          "\n.--------------------------."
          "\n| [1] Ingresar grafo       |"
          "\n| [2] Imprimir grafo       |"
          "\n| [3] Calcular componentes |"
          "\n|     conexas              |"
          "\n|               [4] Salir  |"
          "\n.--------------------------.\n";
}

void endTitle() {
  cout << "\n  ^~^  , * ------------- *"
          "\n ('Y') ) |  Hasta luego! | "
          "\n /   \\/  * ------------- *"
          "\n(\\|||/)        FIN      \n";
}

void enterMatrix(int matrix[][6]) {
  int i, j, num;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
        cout << "Ingrese el valor de [" << i << "][" << j << "] : ";
        while (!((cin >> num) && (num >= 0 && num <= 1))) {
            cin.clear();
            cin.ignore();
        }
        matrix[i][j] = num;
    }
    cout << endl;
  }
}

void printMatrix(int matrix[][6]) {
  int i, j;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }
}

void calculateConnectionComponents(int matrix[][6]){
    cout << endl << "Calcular componentes conexas" << endl;
    
    int n = 6;
    int W[6][6];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            W[i][j] = matrix[i][j];
        }
    }

    for (int k = 0; k < n; k++){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                W[i][j] = W[i][j] || (W[i][k] && W[k][j]);
            }
        }
    } 

    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
        cout << W[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    // Matriz de adyacencia del grafo
  int graphMatrix[6][6] = {
    {0, 0, 1, 0, 0, 0},
    {1, 0, 0, 1, 0, 1},
    {0, 1, 0, 0, 1, 0},
    {0, 0, 0, 0, 0, 0},
    {0, 0, 0, 1, 0, 0},
    {0, 0, 1, 0, 0, 0}};

  int userChoice;
  bool run = true;

  while (run == true) {
    diplayMenu();
    while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 4))) {
      cin.clear();
      cin.ignore();
    }

    switch (userChoice) {
      case 1:
        enterMatrix(graphMatrix);
        printMatrix(graphMatrix);
        break;

      case 2:
        printMatrix(graphMatrix);
        break;

      case 3:
        calculateConnectionComponents(graphMatrix);
        break;

      case 4:
        endTitle();
        run = false;
        break;
    }
  }

  return 0;
}