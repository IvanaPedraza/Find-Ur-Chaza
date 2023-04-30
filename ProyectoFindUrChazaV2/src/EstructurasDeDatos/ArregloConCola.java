/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author kelly
 */
public class ArregloConCola <T>{
    private int[] arrayInicial;
    private int tamano;
    private int capacidad;
    
    public ArregloConCola(int capacidad){
        this.capacidad = capacidad;
        this.arrayInicial = new int[capacidad];
        this.tamano = 0;
    }
    
    public void pushBack(int key){
        if(estaLleno()){
            System.out.println("Esta lleno");
        }else{
            arrayInicial[this.tamano++] = key;
        }
    }
    
    public void pushFront(int key){
        int[] nuevaLista;
        if(estaLleno()){
            System.out.println("Esta lleno");
        }else{
            this.tamano++;
            nuevaLista = new int[this.capacidad];
            nuevaLista[0] = key;
            for(int i = 1; i < tamano;i++){
                nuevaLista[i] = arrayInicial[i - 1];
            }
            arrayInicial = nuevaLista;
        }
    }
    
    public void popBack(){
        int[] nuevaLista;
        if(estaVacio()){
            System.out.println("Esta vacio");
        }else{
            this.tamano--;
            nuevaLista = new int[this.capacidad];
            for(int i = 0;i < this.tamano;i++){
                nuevaLista[i] = arrayInicial[i];
            }
            arrayInicial = nuevaLista;
            
        }
    }
    
    public boolean find(int key){
        boolean seEncuentra = false;
        for(int i = 0; i < tamano;i++){
            if(arrayInicial[i] == key){
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }
    
    
    public void delete(int key){
        int[] nuevaLista = new int[this.capacidad];
        int i = 0;
        while(i < tamano){
            if(arrayInicial[i] == key){
                for(int k = i; k < tamano - 1; k++){
                    nuevaLista[k] = arrayInicial[k + 1];
                }
                break;
            }else{
                nuevaLista[i] = arrayInicial[i];
            }
            i++;
        }
        arrayInicial = nuevaLista;
        tamano--;
        
        
    }

    /*
    public void delete(int clave){
      int[] relist;
      relist=new int[capacidad];
      for (int i=0;i<tamano;i++){
        if(arrayInicial[i]==clave){
          for(int k=i;k<tamano;k++){
            relist[k]=arrayInicial[k+1];
          }
        }
        else
          relist[i]=arrayInicial[i];
      }
      arrayInicial=relist;
    }
    */
    
    public void popFront(){
        int[] nuevaLista;
        if(estaVacio()){
            System.out.println("Esta vacio");
        }else{
            this.tamano--;
            nuevaLista = new int[this.capacidad];
            for(int i = 0;i<tamano;i++){
                nuevaLista[i] = arrayInicial[i++];
            }
            arrayInicial = nuevaLista;
        }
    }
    
    public boolean estaLleno(){
        return tamano == capacidad;
    }
    public boolean estaVacio(){
        return this.tamano == 0;
    }
    
    public void imprimir(){
        for(int i = 0;i < this.capacidad;i++){
            System.out.println(arrayInicial[i]);
        }
    }

    public int getTamano() {
        return tamano;
    }
}
