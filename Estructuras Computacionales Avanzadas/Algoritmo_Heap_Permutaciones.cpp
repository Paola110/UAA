// Universidad Autonoma de Aguascalientes
// Ingenieria en Computación Inteligente
// Estructuras Computacionales Avanzadas
// Osorio García Paola Montserrat
// Pérez López Pablo David
// Reteguin Vanessa
// Profesor Gutierrez Marfileño Luis Fernando
// Aplicacion del algoritmo de Heap para el desarrollo de las permutaciones de
// un conjunto de elementos

// Incluir librerias necesarias
#include <iostream>
using namespace std;
int num;

// Funcion Permutaciones

// Programa principal con el menu para solicitar el conjunto de datos a permutar

// Imprimir arreglo
void printArrayString(string arreglo_permutar[], int num) {
  int i;
  for (i = 0; i < num; i++) {
    cout << arreglo_permutar[i];
    if (i != num - 1) {
      cout << ", ";
    }
  }
}

// (Swap) Intercambiar elementos dentro del arreglo

void swapElements(string arreglo_permutar[], int n1, int n2) {
  string temp;
  temp = arreglo_permutar[n1];
  arreglo_permutar[n1] = arreglo_permutar[n2];
  arreglo_permutar[n2] = temp;
}

// Generador de permutaciones
void permutations(int nElements, string allElements[]) {
  int i, n = num;

  if (nElements == 1) {
    return;
  } else {
    for (i = 0; i < nElements - 1; i++) {
      permutations((nElements - 1), allElements);
      if (nElements % 2 == 0) {
        swapElements(allElements, i, (nElements - 1));

      } else {
        swapElements(allElements, 0, (nElements - 1));
      }
      cout << endl;
      printArrayString(allElements, n);
      cout << endl;
    }
    permutations((nElements - 1), allElements);
  }
}

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
        int i, integer;

        cout << endl << "[1] Permutar elementos numericos.\n\n";

        num = 0;  // Tamaño del arreglo
        cout << endl
             << "Ingresa el numero de elementos a permutar, es decir, la "
                "magnitud del arreglo: ";
        while (!((cin >> num) && (num >= 2 && num <= 10))) {
          cin.clear();
          cin.ignore();
        }
        string arreglo_permutar[num];  // Arreglo a permutar
        cout << endl
             << "Ingresa los " << num
             << " elementos del arreglo separados por enter:\n";
        for (i = 0; i < num; i++) {
          cout << "[" << i + 1 << "] --> ";
          while (!(cin >> integer)) {
            cin.clear();
            cin.ignore();
          }
          arreglo_permutar[i] = to_string(integer);
        }

        cout << endl << "Arreglo: ";
        printArrayString(arreglo_permutar, num);

        cout << endl << "Permutaciones: ";
        cout << endl;
        printArrayString(arreglo_permutar, num);
        cout << endl;
        permutations(num, arreglo_permutar);

        break;
      }
      case 2: {
        int i;
        cout << endl << "[2] Permutar elementos alfanumericos.\n\n";

        num = 0;  // Tamaño del arreglo
        cout << endl
             << "Ingresa el numero de elementos a permutar, es decir, la "
                "magnitud del arreglo: ";
        while (!((cin >> num) && (num >= 2 && num <= 10))) {
          cin.clear();
          cin.ignore();
        }
        string arreglo_permutar[num];  // Arreglo a permutar
        cout << endl
             << "Ingresa los " << num
             << " elementos del arreglo separados por enter:\n";
        for (i = 0; i < num; i++) {
          cout << "[" << i + 1 << "] --> ";
          while (!(cin >> arreglo_permutar[i])) {
            cin.clear();
            cin.ignore();
          }
        }

        cout << endl << "Arreglo: ";
        printArrayString(arreglo_permutar, num);

        cout << endl << "Permutaciones: ";
        cout << endl;
        printArrayString(arreglo_permutar, num);
        cout << endl;
        permutations(num, arreglo_permutar);

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