// Universidad Autonoma de Aguascalientes
// Ingenieria en Computación Inteligente
// Estructuras Computacionales Avanzadas
// Osorio García Paola Montserrat
// Pérez López Pablo David
// Reteguin Vanessa
// Profesor Gutierrez Marfileño Luis Fernando
// Aplicacion del algoritmo de Heap para el desarrollo de las permutaciones de un conjunto de elementos

// Incluir librerias necesarias
#include <iostream>
using namespace std;

// Funcion Permutaciones

// Programa principal con el menu para solicitar el conjunto de datos a permutar

// Menú de opciones
void diplayMenu() {
  cout << endl
       << "\n.----------------------------------------."
          "\n||           ----{ MENU }----           ||"
          "\n.----------------------------------------."
          "\n| [1] Permutar elementos numericos.      |"
          "\n| [2] Permutar elementos alfanumericos.  |"
          "\n| [3] Salir                              |"
          "\n.----------------------------------------.\n";
}

// Fin del programa
void endTitle() {
  cout << "\n  ^~^  , * ------------- *"
          "\n ('Y') ) |  Hasta luego! | "
          "\n /   \\/  * ------------- *"
          "\n(\\|||/)        FIN      \n";
}

int main() {
  int userChoice;
  bool run = true;
  while (run == true) {
    diplayMenu();
    while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 3))) {
      cin.clear();
      cin.ignore();
    }


    switch (userChoice) {
    case 1: {

      cout << endl << "[1] Permutar elementos numericos.\n\n";

      int num = 0; // Tamaño del arreglo
      cout << endl << "Ingresa el numero de elementos a permutar, es decir, la magnitud del arreglo: ";
      while ((!(cin >> num)) && (num <= 10)) {
          cin.clear();
          cin.ignore();
      }
      int arreglo_permutar[num]; // Arreglo a permutar
      cout << endl << "Ingresa los "<< num <<" elementos del arreglo separados por enter:\n";
      for (int i=0 ; i<num ; i++){
        cout <<"["<< i+1 << "] --> ";
        while (!(cin >> arreglo_permutar[i])) {
            cin.clear();
            cin.ignore();
        }
      }

      break;
    }
    case 2:
      {

      cout << endl << "[2] Permutar elementos alfanumericos.\n\n";

      int num = 0; // Tamaño del arreglo
      cout << endl << "Ingresa el numero de elementos a permutar, es decir, la magnitud del arreglo: ";
      while ((!(cin >> num)) && (num <= 10)) {
          cin.clear();
          cin.ignore();
      }
      char arreglo_permutar[num]; // Arreglo a permutar
      cout << endl << "Ingresa los "<< num <<" elementos del arreglo separados por enter:\n";
      for (int i=0 ; i<num ; i++){
        cout <<"["<< i+1 << "] --> ";
        while (!(cin >> arreglo_permutar[i])) {
            cin.clear();
            cin.ignore();
        }
      }

      break;
    }

    case 3:
      endTitle();
      run = false;
      break;
    }
  }

  return 0;
}
