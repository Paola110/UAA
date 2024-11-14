#include <iostream>
#include <vector>

using namespace std;

void displayMenu() {
    cout << endl
         << "\n.--------------------------."
            "\n||       -{ MENU }-       ||"
            "\n.--------------------------."
            "\n| [1] Ingresar la matriz   |"
            "\n|     de adyacencia        |"
            "\n| [2] Determinar si el     |"
            "\n|     grafo es un arbol    |"
            "\n|               [3] Salir  |"
            "\n.--------------------------.\n";
}

void printMatrix(vector<vector<int>> matrix) {
  int i, j;
  for (i = 0; i < adj.size(); i++) {
    for (j = 0; j < adj.size(); j++) {
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }
}

bool VDiagPrin(const vector<vector<int>>& adj) {
    // Verifica que la diagonal principal sea cero para evitar ciclos o bucles.
    for (int i = 0; i < adj.size(); ++i) {
        if (adj[i][i] != 0) {
            return false;
        }
    }
    return true;
}

bool Conexion(const vector<vector<int>>& adj) {
    // Verifica que exista al menos un 1 fuera de la diagonal principal.

    printMatrix(adj);
    for (int i = 0; i < adj.size(); ++i) {
        for (int j = 0; j < adj[i].size(); ++j) {
            if (i != j && adj[i][j] == 1) {
                return true;
            }
        }
    }
    return false;
}

bool NoCircuitos(const vector<vector<int>>& adj, int n) {
    // Verifica que haya una conexión por fila y columna.(n - 1 arcos)
    for (int i = 0; i < adj.size(); ++i) {
        int countRow = 0;
        for (int j = 0; j < adj[i].size(); ++j) {
            if (adj[i][j] == 1) countRow++;
        }
        if (countRow > 2*(n-1)) {
            return false;
        }
    }
    return true;
}

bool esArbol(vector<vector<int>>& adj, int n) {
    // Verificación de la diagonal principal
    if (!VDiagPrin(adj)) {
        cout << "La diagonal principal no es cero, lo que indica la presencia de ciclos." << endl;
        return false;
    }
    // Verificación de al menos un 1 fuera de la diagonal principal
    if (!Conexion(adj)) {
        cout << "No existe conexión entre nodos fuera de la diagonal principal." << endl;
        return false;
    }
    // Verificación de una única conexión por fila y columna
    if (!NoCircuitos(adj, n)) {
        cout << "Hay más de una conexión por fila o columna, lo que indica circuitos." << endl;
        return false;
    }
    return true;
}

int main() {
    int n = 11;
    int userChoice;
    bool run = true;
    bool ingresada = false;
    
    while (run) {
        while (n > 10) {
            cout << "\nIngrese el numero de nodos (máximo pueden ser 10): ";
            cin >> n;
        }
        vector<vector<int>> adj(n, vector<int>(n, 0));
        cout << endl;

        displayMenu();

        while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 3))) {
            cin.clear();
            cin.ignore();
        }

        switch (userChoice) {
            case 1:
                cout << "Ingrese la matriz de adyacencia:" << endl;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        cout<<"Ingrese la posicion "<<i+1<<","<<j+1<<": ";
                        cin >> adj[i][j];
                    }
                }
                ingresada = true;
                break;
            case 2:
                if (ingresada) {
                    if (esArbol(adj, n)) {
                        cout << "El grafo es un arbol." << endl;
                    } else {
                        cout << "El grafo no es un arbol." << endl;
                    }
                } else {
                    cout << "Por favor, ingrese la matriz de adyacencia antes." << endl;
                }
                break;
            case 3:
                run = false;
                break;
        }
    }
    return 0;
}
