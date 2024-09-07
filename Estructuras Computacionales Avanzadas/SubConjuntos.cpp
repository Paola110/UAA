/*
6 septiembre de 2024
Paola Osorio - 216511
Pablo David Pérez López - 300452
Vanessa Reteguín - 373355

Práctica #2

Universidad Aútonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre II
Grupo 2 - E
Estructuras Computacionales avanzadas
Luis Fernando Gutiérrez Marfileño

*/

#include <iostream>
#include <bitset>
#include <cstring>
#include <math.h>
#include <vector>
using namespace std;

void conjuntoPotencia() {

  cout << endl << "Funcion para generar conjunto potencia"<< endl;

    string conjunto="";
    int contador = 0;
    cout<< endl << "Ingrese su conjunto separado por espacios: ";
    getline(cin, conjunto);

    cout<< "#     Binario     Conjunto"<<endl;

    int n = conjunto.size();

    for (int i = 0; i < n; ++i) {
        if (conjunto[i] != ' ') { // Se cuentan los caracteres
            contador++;
        }
    }

    char separados[contador+1];
    int indice = 0;

    for (int i = 0; i < n; ++i) {
        if (conjunto[i] != ' ') {
            separados[indice] = conjunto[i]; // Se separan ignorando el espacio
            indice++;
        }
    }

    separados[contador] = '\0';  // Añadir el carácter nulo al final

    for (int i=0; i<(1<<contador); i++){ // (1<<contador) es 2^n

      cout << i+1 << "     ";
        bitset<32> binario(i);
        cout<<binario.to_string().substr(32 - contador)<<" --->   { ";

        for (int j=0; j < contador; ++j){
          if(i&(1<<j)){ // Verifica si el elemento esta en el subconjunto
            cout<<separados[j];
          }
        }

        cout<<" }"<<endl;

    }
}

void endTitle() {
  cout << "\n  ^~^  , * ------------- *"
          "\n ('Y') ) |  Hasta luego! | "
          "\n /   \\/  * ------------- *"
          "\n(\\|||/)        FIN      \n";
}

int main() {
  string choice;
  bool run = true;

  while (run == true) {

    conjuntoPotencia();

    cout << "Desea ver el conjunto podencia de un conjunto de elementos? (yes/no)";

    cin>>choice;
    cin.ignore();

    while (choice != "yes" && choice != "no") {
        cin.clear();
        cin.ignore();
        cout << "Entrada no válida. Por favor, ingrese 'yes' o 'no': ";
        cin >> choice;
        cin.ignore();
    }

    if (choice == "no") {
      endTitle();
      run = false;
    }
  }

  return 0;
}