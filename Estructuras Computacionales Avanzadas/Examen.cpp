
/*
    Paola Montserrat Osorio García
    Creacion de un arbol que representa la estructura de directorios en Unix
*/

#include <stdlib.h>
#include <iostream>
using namespace std;

struct nodo{
    string carpeta;
    struct nodo *uno;
    struct nodo *dos;
    struct nodo *tres;
    struct nodo *cuatro;
    struct nodo *cinco;
    struct nodo *seis;
    struct nodo *siete;
};

nodo* nuevoNodo(string nombre_carpeta){
    nodo* nuevoNodo = new (nodo);
    nuevoNodo->uno = NULL;
    nuevoNodo->dos = NULL;
    nuevoNodo->tres = NULL;
    nuevoNodo->cuatro = NULL;
    nuevoNodo->cinco = NULL;
    nuevoNodo->seis = NULL;
    nuevoNodo->siete = NULL;
    nuevoNodo->carpeta = nombre_carpeta;

    return nuevoNodo;
};

void NuevoNodoHijo(nodo *&nodo_padre, string nombre_etiqueta){
    if (nodo_padre == NULL)
    {
        nodo_padre = nuevoNodo(nombre_etiqueta);
    }
    else
    {
        if (nodo_padre->uno == NULL)
        {
            nodo_padre->uno = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->dos == NULL)
        {
            nodo_padre->dos = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->tres == NULL)
        {
            nodo_padre->tres = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->cuatro == NULL)
        {
            nodo_padre->cuatro = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->cinco == NULL)
        {
            nodo_padre->cinco = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->seis == NULL)
        {
            nodo_padre->seis = nuevoNodo(nombre_etiqueta);
        }
        else if (nodo_padre->siete == NULL)
        {
            nodo_padre->siete = nuevoNodo(nombre_etiqueta);
        }
    }
}

//Impresion del arbol
void imprimir_Arbol(nodo* Arbol){
    string niveles[]= { "","","","",""};
    nodo* aux = Arbol;

    if(Arbol->uno == NULL){
        niveles[0]+= Arbol->carpeta;
        niveles[0]+= " ";
        Arbol = aux;
    } else {
        niveles[1]+= Arbol->uno->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->dos->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->tres->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->cuatro->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->cinco->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->seis->carpeta;
        niveles[1]+= " ";
        niveles[1]+= Arbol->siete->carpeta;
        niveles[1]+= " ";
    }
    Arbol = Arbol->uno;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->dos;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->tres;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->cuatro;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->cinco;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->seis;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }
    Arbol = Arbol->siete;
        if(Arbol->uno != NULL){
            niveles[2]+= Arbol->uno->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->dos->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->tres->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cuatro->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->cinco->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->seis->carpeta;
            niveles[2]+= " ";
            niveles[2]+= Arbol->siete->carpeta;
            niveles[2]+= " ";
        } else {
            Arbol = aux;
        }

    cout<<endl;
    cout<<"ARBOL";
    cout<<endl;

    for(int i=0; i<3; i++){
        cout<<"Nivel "<< i+1<<": "<<niveles[i]<<endl;
    }
    cout<<endl;
}

int main(){

    //Inicializacion de etiquetas para preguntar
    string etiquetas[] = { "/",
                        "dev/",
                        "etc/","cups/","httpd/","init.d/","postPx/",
                        "sbin/",
                        "tmp/",
                        "Users/","bmiller/","jmiller/","mysql/",
                        "usr/","bin/","lib/","local/",
                        "var/","log/","spool/","yp/" };

    cout<<endl<<"Descripcion de lo que trata el programa: "<<endl;
    cout<<endl<<"El programa crea un arbol que representa la estructura de directorios en Unix\nesto usando nodos y apuntadores para cada elemento del arbol"<<"\n\n\n";

    //Creacion del arbol
    nodo* raiz = nuevoNodo(etiquetas[0]); // Definimos el nodo raiz

    nodo* Arbol = raiz;

    cout<<"Se ha creado el arbol con la raiz: "<<(Arbol->carpeta)<<endl<<endl;
        
    nodo* aux = raiz;

    int tam_arbol = size(etiquetas);

    int opcion = 0;

    for(int i=1; i<tam_arbol; i++){
        
        if(i==3){
            Arbol = Arbol->dos;
        }
        else if(i==7){
            Arbol = aux;
        }
        else if(i==10){
            Arbol = Arbol->cinco;
        }
        else if (i==13){
            Arbol = aux;
        }
        else if(i==14){
            Arbol = Arbol->seis;
        }
        else if (i==17){
            Arbol = aux;
        }
        else if(i==18){
            Arbol = Arbol->siete;
        }
        
        cout<<"Quieres agregar la etiqueta '"<<etiquetas[i]<<"' al nodo '" <<Arbol->carpeta<<"' ? (si/no)"<<endl;
        string respuesta1;
        cin>>respuesta1;
        if(respuesta1 == "si" || respuesta1 == "Si" || respuesta1 == "SI"|| respuesta1 == "s" ||respuesta1 == "S"){
            NuevoNodoHijo(Arbol, etiquetas[i]);
            cout<<"Se ha agregado la etiqueta '"<<etiquetas[i]<<"' al arbol"<<endl;
        } else {
            cout<<"Quieres llamarla de otra manera? (si/no), elige no para NO insertar el nuevo nodo en el arbol"<<endl;
            string respuesta2;
            string nuevo_nombre;
            cin>>respuesta2;
            if (respuesta2 == "si" || respuesta2 == "Si" || respuesta2 == "SI"|| respuesta2 == "s" ||respuesta2 == "S"){
                cout<<"Ingresa el nombre de la etiqueta: ";
                cin>>nuevo_nombre;
                NuevoNodoHijo(Arbol, nuevo_nombre);
                cout<<"Se ha agregado la etiqueta '"<<nuevo_nombre<<"' al arbol"<<endl;
            } else {
               cout<<"No se ha agregado la etiqueta al arbol"<<endl;
            }
        }

        cout<<endl<<i<<" "<<Arbol->carpeta<<endl;


    }

    // imprimir_Arbol(raiz);
    // Se implemento la logica para imprimir pero no funciono correctamente asi que lo quite para que viera el resto del proceso

    return 0;

}