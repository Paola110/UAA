/*
11 octubre de 2024
Paola Osorio - 216511
Pablo David Pérez López - 300452
Vanessa Reteguín - 373355

Práctica #3

Universidad Aútonoma de Aguascalientes
Ingeniería en Computación Inteligente (ICI)
Semestre II
Grupo 2 - E
Estructuras Computacionales avanzadas
Luis Fernando Gutiérrez Marfileño
*/

#include <stdlib.h> //srand
#include <time.h>   //time
#include <array>    // sizeof()

#include <iostream>
using namespace std;

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

void preOrder(node *);

void inOrder(node *tree);

void postOrder(node *tree);

int aux_X = 0; // Variable auxiliar para controlar la posición horizontal de los nodos

int randomNum(int lower, int upper)
{
    int num;
    num = (rand() % (upper - lower + 1)) + lower;
    return num;
}

void diplayMenu()
{
    cout << endl
         << "\n.--------------------."
            "\n||    -{ MENU }-    ||"
            "\n.--------------------."
            "\n| [1] Agregar nodo   |"
            "\n| [2] Nodo aleatorio |"
            "\n| [3] Eliminar nodo  |"
            "\n| [4] Buscar nodo    |"
            "\n| [5] Mostrar árbol  |"
            "\n.--------------------."
            "\n| Recorrido en:      |"
            "\n|      [6] Preorden  |"
            "\n|      [7] Inorden   |"
            "\n|      [8] Postorden |"
            "\n.--------------------."
            "\n|          [9] Salir |"
            "\n.--------------------.\n";
}

void endTitle()
{
    cout << "\n  ^~^  , * ------------- *"
            "\n ('Y') ) |  Hasta luego! | "
            "\n /   \\/  * ------------- *"
            "\n(\\|||/)        FIN      \n";
}

node *createNode(int n)
{
    node *newNode = new (node);
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->data = n;

    return newNode;
}

void newChildNode(node *&root, int n)
{
    if (root == NULL)
    {
        root = createNode(n);
    }
    else
    {
        if (root->left == NULL)
        {
            root->left = createNode(n);
        }
        else if (root->right == NULL)
        {
            root->right = createNode(n);
        }
        else
        {
            if (n < root->data)
            {
                newChildNode(root->left, n);
            }
            else
            {
                newChildNode(root->right, n);
            }
        }
    }
}

void printTree(node *node, int level)
{
    int i;

    if (node == NULL)
    {
        return;
    }
    else
    {
        printTree(node->right, level + 1);
        for (i = 0; i < level; i++)
        {
            cout << "    ";
        }
        cout << node->data << endl;
        printTree(node->left, level + 1);
    }
}

void gotoxy(int x, int y)
{
    printf("%c[%d;%df", 0x1B, y, x);

    // Solución de boodahDEV
    //  https://gist.github.com/boodahDEV/7e10925c88d487cb5cd6770a23ac3f15
}

// Función para mostrar el árbol de forma gráfica. Créditos: Alan García
void showTree(node *root, int aux_Y)
{ // aux_Y representa el nivel del árbol
    if (root == nullptr)
        return;

    aux_X += 4; // Variable que permite posicionar en el eje X

    showTree(root->left, aux_Y + 2); // Se para hasta el nodo más a la izquierda del árbol (subárbol izquierdo)

    gotoxy(8 + aux_X - aux_Y, 15 + aux_Y); // Posiciona el nodo según sus coordenadas en X y en Y

    cout << root->data << endl
         << endl; // Muestra el dato del node respectivo

    showTree(root->right, aux_Y + 2); // Se para hasta el nodo más a la derecha del árbol (subárbol derecho)
}

void printTreeVertical(node *root)
{
    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    showTree(root, 6);
    aux_X = 0;
}

void printTreeHorzontal(node *node, int level)
{
    int i;

    if (node == NULL)
    {
        return;
    }
    else
    {
        printTreeHorzontal(node->right, level + 1);
        for (i = 0; i < level; i++)
        {
            cout << "    ";
        }
        cout << node->data << endl;
        printTreeHorzontal(node->left, level + 1);
    }
}

bool search(node *root, int seachedValue)
{
    if (root == NULL)
    {
        return false;
    }
    else if (root->data == seachedValue)
    {
        return true;
    }
    else if (seachedValue < root->data)
    {
        return search(root->left, seachedValue);
    }
    else
    {
        return search(root->right, seachedValue);
    }
}

void printSeachedValue(node *node, int level, int seachedValue)
{
    int i;

    if (node == NULL)
    {
        return;
    }
    else
    {
        printSeachedValue(node->right, level + 1, seachedValue);
        for (i = 0; i < level; i++)
        {
            cout << "    ";
        }
        if (node->data == seachedValue)
        {
            cout << "->{" << node->data << "}<-" << endl;
        }
        else
        {
            cout << node->data << endl;
        }
        printSeachedValue(node->left, level + 1, seachedValue);
    }
}

bool deleteNode(node *root, int valueToDelete)
{
    if (root == NULL)
    {
        return false;
    }
    else if (root->data == valueToDelete)
    {
        delete root;
        return true;
    }
    else if (valueToDelete < root->data)
    {
        return search(root->left, valueToDelete);
    }
    else
    {
        return search(root->right, valueToDelete);
    }
}

int main()
{
    srand(time(NULL));

    // Menu var
    int userChoice;
    bool run = true;

    // Aux var
    int n, i, cont = 0;

    // Root Node
    node *root = NULL;

    int numbers[] = {8, 4, 13, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 15, 13};
    int size = sizeof(numbers) / sizeof(numbers[0]);

    for (i = 0; i < size; i++)
    {
        n = numbers[i];
        newChildNode(root, n);
    }

    while (run == true)
    {
        diplayMenu();
        while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 9)))
        {
            cin.clear();
            cin.ignore();
        }

        switch (userChoice)
        {
        case 1:
            cout << "Ingrese el valor del nodo: ";
            while (!(cin >> n))
            {
                cin.clear();
                cin.ignore();
            }
            newChildNode(root, n);
            printTreeVertical(root);
            break;

        case 2:
            n = randomNum(-20, 20);
            newChildNode(root, n);
            printTreeVertical(root);
            break;

        case 3:
            cout << "Ingrese un valor a eliminar dentro del árbol: ";
            while (!(cin >> n))
            {
                cin.clear();
                cin.ignore();
            }
            if (deleteNode(root, n) == true)
            {
                cout << endl
                     << "[*] Eliminado exitosamente:" << endl;
                cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
                printTreeVertical(root);
            }
            else
            {
                cout << endl
                     << "[!] Valor no encontrado dentro del árbol" << endl;
            }
            break;

        case 4:
            cout << "Ingrese un valor a buscar dentro del árbol: ";
            while (!(cin >> n))
            {
                cin.clear();
                cin.ignore();
            }
            if (search(root, n) == true)
            {
                cout << endl
                     << "[*] Valor encontrado:" << endl;
                printSeachedValue(root, cont, n);
            }
            else
            {
                cout << endl
                     << "[!] Valor no encontrado dentro del árbol" << endl;
            }
            break;

        case 5:
            cout << endl
                 << "Árbol\n"
                 << endl;
            printTreeVertical(root);
            break;

        case 6:
            cout << endl
                 << "Preorden\n"
                 << endl;
            preOrder(root);
            break;

        case 7:
            cout << endl
                 << "Inorden\n"
                 << endl;
            inOrder(root);
            break;

        case 8:
            cout << endl
                 << "Postorden\n"
                 << endl;
            postOrder(root);
            break;

        case 9:
            endTitle();
            run = false;
            break;
        }
    }

    return 0;
}

void preOrder(node *tree){
    if(tree == NULL){
        return;
    }else{
        cout << tree -> data << " - ";
        preOrder(tree -> left);
        preOrder(tree -> right);
    }
}

void inOrder(node *tree){
    if(tree == NULL){
        return;
    }else{
        inOrder(tree -> left);
        cout << tree -> data << " - ";
        inOrder(tree -> right);
    }
}

void postOrder(node *tree){
    if(tree == NULL){
        return;
    }else{
        postOrder(tree -> left);
        postOrder(tree -> right);
        cout << tree -> data << " - ";
    }
}