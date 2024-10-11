/*
 * +----------------------------------------------------------------------------+
 * | CARDUI WORKS v0.0.2
 * +----------------------------------------------------------------------------+
 * | Copyright (c) 2024 - 2024, CARDUI.COM (www.cardui.com)
 * | Vanessa Reteguín <vanessa@reteguin.com>
 * | Released under the MIT license
 * | www.cardui.com/carduiframework/license/license.txt
 * +----------------------------------------------------------------------------+
 * | Author.......: Vanessa Retegín <vanessa@reteguin.com>
 * | First release: June 7th, 2024
 * | Last update..: June 9th, 2024
 * | WhatIs.......: Binary Tree: exercise - Main
 * +----------------------------------------------------------------------------+
 * | University...: Universidad Autónoma de Aguascalientes
 * | Major........: Ingeniería en Computación Inteligente (ICI)
 * | Semester.....: Semestre II
 * | Section......: Group 2 - A
 * | College ID...: 375533
 * | Subject......: Estructuras Computacionales
 * | Professor....: María Loreto Edit López Veloz
 * | Spanish Title: Árboles Binarios: ejercicio - Main
 * +----------------------------------------------------------------------------+
 */

#include <stdlib.h>  //srand
#include <time.h>    //time

#include <iostream>
using namespace std;

struct node {
  int data;
  struct node *left;
  struct node *right;
};

int randomNum(int lower, int upper) {
  int num;
  num = (rand() % (upper - lower + 1)) + lower;
  return num;
}

void diplayMenu() {
  cout << endl
       << "\n.--------------------."
          "\n||    -{ MENU }-    ||"
          "\n.--------------------."
          "\n| [1] Agregar nodo   |"
          "\n| [2] Nodo aleatorio |"
          "\n| [3] Eliminar nodo  |"
          "\n| [4] Buscar nodo    |"
          "\n| [5] Mostrar árbol  |"
          "\n|          [6] Salir |"
          "\n.--------------------.\n";
}

void endTitle() {
  cout << "\n  ^~^  , * ------------- *"
          "\n ('Y') ) |  Hasta luego! | "
          "\n /   \\/  * ------------- *"
          "\n(\\|||/)        FIN      \n";
}

node *createNode(int n) {
  node *newNode = new (node);
  newNode->left = NULL;
  newNode->right = NULL;
  newNode->data = n;

  return newNode;
}

void newChildNode(node *&root, int n) {
  if (root == NULL) {
    root = createNode(n);
  } else {
    if (n < root->data) {
      newChildNode(root->left, n);
    } else {
      newChildNode(root->right, n);
    }
  }
}

void printTree(node *node, int level) {
  int i;

  if (node == NULL) {
    return;
  } else {
    printTree(node->right, level + 1);
    for (i = 0; i < level; i++) {
      cout << "    ";
    }
    cout << node->data << endl;
    printTree(node->left, level + 1);
  }
}

bool search(node *root, int seachedValue) {
  if (root == NULL) {
    return false;
  } else if (root->data == seachedValue) {
    return true;
  } else if (seachedValue < root->data) {
    return search(root->left, seachedValue);
  } else {
    return search(root->right, seachedValue);
  }
}

void printSeachedValue(node *node, int level, int seachedValue) {
  int i;

  if (node == NULL) {
    return;
  } else {
    printSeachedValue(node->right, level + 1, seachedValue);
    for (i = 0; i < level; i++) {
      cout << "    ";
    }
    if (node->data == seachedValue) {
      cout << "->{" << node->data << "}<-" << endl;
    } else {
      cout << node->data << endl;
    }
    printSeachedValue(node->left, level + 1, seachedValue);
  }
}

bool deleteNode(node *root, int valueToDelete) {
  if (root == NULL) {
    return false;
  } else if (root->data == valueToDelete) {
    delete root;
    return true;
  } else if (valueToDelete < root->data) {
    return search(root->left, valueToDelete);
  } else {
    return search(root->right, valueToDelete);
  }
}

int main() {
  srand(time(NULL));

  // Menu var
  int userChoice;
  bool run = true;

  // Aux var
  int n, i, cont = 0;

  // Root Node
  node *root = NULL;

  for (i = 0; i < 5; i++) {
    n = randomNum(-20, 20);
    newChildNode(root, n);
  }

  while (run == true) {
    diplayMenu();
    while (!((cin >> userChoice) && (userChoice >= 1 && userChoice <= 6))) {
      cin.clear();
      cin.ignore();
    }

    switch (userChoice) {
      case 1:
        cout << "Ingrese el valor del nodo: ";
        while (!(cin >> n)) {
          cin.clear();
          cin.ignore();
        }
        newChildNode(root, n);
        printTree(root, cont);
        break;

      case 2:
        n = randomNum(-20, 20);
        newChildNode(root, n);
        printTree(root, cont);
        break;

      case 3:
        cout << "Ingrese un valor a eliminar dentro del árbol: ";
        while (!(cin >> n)) {
          cin.clear();
          cin.ignore();
        }
        if (deleteNode(root, n) == true) {
          cout << endl << "[*] Eliminado exitosamente:" << endl;
          printTree(root, cont);
        } else {
          cout << endl << "[!] Valor no encontrado dentro del árbol" << endl;
        }
        break;

      case 4:
        cout << "Ingrese un valor a buscar dentro del árbol: ";
        while (!(cin >> n)) {
          cin.clear();
          cin.ignore();
        }
        if (search(root, n) == true) {
          cout << endl << "[*] Valor encontrado:" << endl;
          printSeachedValue(root, cont, n);
        } else {
          cout << endl << "[!] Valor no encontrado dentro del árbol" << endl;
        }
        break;

      case 5:
        cout << endl << "Árbol\n" << endl;
        printTree(root, 0);
        break;

      case 6:
        endTitle();
        run = false;
        break;
    }
  }

  return 0;
}