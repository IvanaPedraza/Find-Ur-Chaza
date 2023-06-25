/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Cliente;

/**
 *
 * @author kelly
 */
public class HashCliente {
    class LinkedHash{
        String key;
        Cliente value;
        LinkedHash next;
        
        LinkedHash(String key, Cliente value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private int tableSize;
    private int size;
    private LinkedHash[] table;
    
    public HashCliente(int ts){
        size = 0;
        tableSize = ts;
        table = new LinkedHash[tableSize];
        
        for(int i = 0; i < tableSize; i++){
            table[i] = null;
        }
    }
    public int getSize(){
        return size;
    }
    
    public void makeEmpty(){
        for(int i = 0; i < tableSize; i++){
            table[i] = null;
        }
    }
    
    public Cliente get(String key){
        int value = (myhash(key)% tableSize);
        if(table[value] == null)
            return null;
        else{
            LinkedHash current = table[value];
            while(current != null && !current.key.equals(key)){
                current = current.next;
            }
            if(current == null){
                return null;
            }
            else{
                return current.value;
            }
        }
    }
    
    
    
    public Cliente getNA(String name, String surname){
        LinkedHash linkedHash = getCliente(name, surname);
        Cliente clienteRetornado = linkedHash.value;
        return clienteRetornado;
    }
    
    public LinkedHash getCliente(String nombre, String apellido){
        for(int i = 0; i < tableSize; i++){
            LinkedHash current = table[i];
            while(current != null){
                if(current.value.getNombre().equals(nombre) && current.value.getApellido().equals(apellido)){
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }
    
    public void insert(String key, Cliente value)
    {
        int hash = (myhash(key) % tableSize);
        if (table[hash] == null) {
            table[hash] = new LinkedHash(key, value);
        }
        else {
            LinkedHash entry = table[hash];
            while (entry.next != null
                   && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value;
            }
            else {
                entry.next = new LinkedHash(key, value);
            }
        }
        size++;
    }
    
    public void remove(String key)
    {
        int value = (myhash(key) % tableSize);
        if (table[value] != null) {
            LinkedHash prev = null;
            LinkedHash current = table[value];
            while (current.next != null
                   && !current.key.equals(key)) {
                prev = current;
                current = current.next;
            }
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[value] = current.next;
                }
                else {
                    prev.next = current.next;
                }
                size--;
            }
        }
    }
    
    
    
    
    private int myhash(String x)
    {
        int value = stringHash(x);
        value %= tableSize;
        if (value < 0) {
            value = value + tableSize;
        }
        return value;
    }
    
    private int stringHash(String x){
        int keyValue = 0;
        for(int i = 0; i<x.length(); i++)
            keyValue = keyValue + x.charAt(i); 
        return keyValue;
    }
    
    public void printHashTable()
    {
        for (int i = 0; i < tableSize; i++) {
            LinkedHash current = table[i];
            while (current != null) {
                System.out.println(
                    "Key = " + current.key +
                    "Value = " + current.value.getNombre() + " "
                        + current.value.getApellido() + " "
                        + current.value.getTelefono()
                    );
                current = current.next;
            }
        }
        System.out.println();
    }
}
