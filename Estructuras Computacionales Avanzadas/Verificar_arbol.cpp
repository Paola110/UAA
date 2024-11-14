/*
9 noviembre de 2024
Vanessa Reteguín - 373355
Paola Osorio - 216511
Pablo David Pérez López - 300452

Práctica #7

Universidad Aútonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre III

Grupo 2 - E
Estructuras Computacionales avanzadas
Luis Fernando Gutiérrez Marfileño  

Descripción del programa: Verificar si un grafo es un arbol segun diferentes condiciones
*/

#include <iostream>
#include <vector>
#include <stack>
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
            "\n| [3] Salir                |"
            "\n.--------------------------.\n";
}

void printMatrix(const vector<vector<int>>& matrix) {
    for (const auto& row : matrix) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }
}

bool VDiagPrin(const vector<vector<int>>& adj) {
    for (int i = 0; i < adj.size(); ++i) {
        if (adj[i][i] != 0) {
            return false;
        }
    }
    return true;
}

void DFSConectividad(const vector<vector<int>>& adj, int v, vector<bool>& visited) {
    visited[v] = true;
    for (int u = 0; u < adj.size(); ++u) {
        if (adj[v][u] == 1 && !visited[u]) {
            DFSConectividad(adj, u, visited);
        }
    }
}

bool esConexo(const vector<vector<int>>& adj) {
    vector<bool> visited(adj.size(), false);
    DFSConectividad(adj, 0, visited);  // Comienza desde el nodo 0

    // Verifica si todos los nodos han sido visitados
    for (bool visit : visited) {
        if (!visit) return false;
    }
    return true;
}

bool esArbol(vector<vector<int>>& adj, int n) {
    vector<bool> visited(adj.size(), false);
    int edgeCount = 0;

    // Verificación de la diagonal principal
    if (!VDiagPrin(adj)) {
        cout << "La diagonal principal no es cero, lo que indica la presencia de ciclos." << endl;
        return false;
    }

    // Contar aristas
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) { // Solo contar una vez por cada par
            if (adj[i][j] == 1) {
                edgeCount++;
            }
        }
    }

    // Un árbol debe tener exactamente n - 1 aristas
    if (edgeCount != n - 1) {
        cout << "El número de aristas no es correcto para un árbol (n-1 por cada n)." << endl;
        return false;
    }

    // Verificación de conectividad
    DFSConectividad(adj, 0, visited); // Comienza desde el nodo 0

    // Verifica si todos los nodos han sido visitados, es decir conectividad (que al menos exista un 1 fuera de la diagonal principal)
    for (bool visit : visited) {
        if (!visit) return false;
    }

    return true;
}

int main() {
    int n;
    int userChoice;
    bool run = true;
    bool ingresada = false;
    vector<vector<int>> adj;

    cout << "\nIngrese el numero de nodos (ma ximo pueden ser 10): ";
    cin >> n;

    while (n <= 0 || n > 10) {
        cout << "Numero de nodos no valido. Debe estar entre 1 y 10.\nIngrese nuevamente: " << endl;
        cin >> n;
    }

    adj.assign(n, vector<int>(n, 0));
    
    while (run) {

        displayMenu();
        cin >> userChoice;

        while (cin.fail() || userChoice < 1 || userChoice > 3) {
            cin.clear();
            cin.ignore();
            cout << "Opcion inválida. Intente nuevamente." << endl;
            cin >> userChoice;
        }

        switch (userChoice) {
            case 1:
                cout << "Ingrese la matriz de adyacencia (solo 0 y 1):" << endl;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        cout << "Ingrese la posicion " << i + 1 << "," << j + 1 << ": ";
                        cin >> adj[i][j];
                        if (adj[i][j] != 0 && adj[i][j] != 1) {
                            cout << "Entrada no valida. Debe ser 0 o 1." << endl;
                            j--;
                        }
                    }
                }
                cout << "\nMatriz de adyacencia ingresada: \n";
                printMatrix(adj);
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
 
/*
Es arbol

0
1
0
0
1
0
1
1
0
1
0
0
0
1
0
0

No es arbol

0
1
1
0
1
0
1
1
1
1
0
0
0
1
0
0

*/