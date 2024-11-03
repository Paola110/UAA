/*
31 octubre de 2024
Vanessa Reteguín - 373355
Paola Osorio - 216511
Pablo David Pérez López - 300452

Práctica #6

Universidad Aútonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre III

Grupo 2 - E
Estructuras Computacionales avanzadas
Luis Fernando Gutiérrez Marfileño  

Descripción del programa: El programa calculara la distancia mas corta entre el vertice A y H 
            mediante el algoritmo de Dijkstra de un grafo dado.
*/

#include <iostream>
#include <bits/stdc++.h>
#include <vector>
#include <limits.h>
using namespace std;

const int INF = INT_MAX;

void diplayMenu() {
  cout << endl
       << "\n.--------------------------."
          "\n||       -{ MENU }-       ||"
          "\n.--------------------------."
          "\n| [1] Calcular la distancia|"
          "\n|     mas corta entre el   |"
          "\n|     vertice A y H del    |"
          "\n|     grafo                |"
          "\n|               [2] Salir  |"
          "\n.--------------------------.\n";
}

void endTitle() {
  cout << "\n  ^~^  , * ------------- *"
          "\n ('Y') ) |  Hasta luego! | "
          "\n /   \\/  * ------------- *"
          "\n(\\|||/)        FIN      \n";
}

void printMatrix(vector<vector<int>> matrix) {
  int i, j;
  for (i = 0; i < 6; i++) {
    for (j = 0; j < 6; j++) {
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }
}

int Dijkstra(vector<vector<int>>& matrix, int inicio, int fin, vector<int>& camino){
    cout << endl << "Aplicacion del algoritmo de Dijkstra" << endl;
    
    int num_nodos = 8;
    vector<int> distancia (num_nodos, INF);
    vector<bool> visitado (num_nodos, false);
    camino.resize(num_nodos,-1);

    distancia[inicio] = 0;

    for (int i = 0; i < num_nodos-1; ++i){
        int Distancia_men = INF, u = -1;
        for (int j = 0; j < num_nodos; ++j){
            if (!visitado[j] && distancia[j] < Distancia_men){
                Distancia_men = distancia[j];
                u = j;
            }
        }
        if (u == -1){
            break;
        }

        if (u == fin){
            return distancia[u];
        }

        visitado[u] = true;

        for (int x = 0; x < num_nodos; ++x){
            if (!visitado[x] && matrix[u][x] && distancia[u] != INF && distancia[u] + matrix[u][x] < distancia[x]){
                distancia[x] = distancia[u] + matrix[u][x];
                camino[x] = u;
            }
        }
   }

    return(distancia[fin] == INF ? -1 : distancia[fin]);

}

void print_ruta(int fin, const vector<int>& camino){
    vector<char> ruta;
    char nodos[8] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
    
    for (int i = fin; i != -1; i = camino[i]) {
        ruta.push_back(nodos[i]);
    }

    reverse(ruta.begin(), ruta.end());

    for (char nodo : ruta) {
        cout << nodo << " ";
    }
    cout << endl;
}


int main() {
    // Matriz de adyacencia del grafo
    vector<vector<int>> graphMatrix = {
    {0,3,1,0,0,0,0,0},
    {3,0,0,1,0,0,5,0},
    {1,0,0,2,0,5,0,0},
    {0,1,2,0,4,2,0,0},
    {0,0,0,4,0,0,2,1},
    {0,0,5,2,0,0,0,3},
    {0,5,0,0,2,0,0,0},
    {0,0,0,0,1,3,0,0}
    };

  int userChoice;
  bool run = true;
  int inicio = 0;
  int fin = 7; 
  int distancia = -1;
  vector<int> camino;

  cout<<"Matriz de pesos para el grafo dado: "<<endl;
  printMatrix(graphMatrix);
  
  while (run == true) {
    diplayMenu();
    while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 4))) {
      cin.clear();
      cin.ignore();
    }

    switch (userChoice) {
      case 1:
        distancia = Dijkstra(graphMatrix, inicio, fin, camino);
        if (distancia == -1) {
          cout <<endl<<endl<< "No existe camimno desde el nodo A al nodo H"<<endl;
        } else { 
          cout<<endl<<endl<< "La ruta mas corta es: ";
          print_ruta(fin, camino);
          cout <<endl<<endl<< "La distancia mas corta es: " << distancia<<endl; 
        }
        break;

      case 2:
        endTitle();
        run = false;
        break;
    }
  }

  return 0;
}
