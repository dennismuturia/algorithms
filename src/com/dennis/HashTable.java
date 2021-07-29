package com.dennis;

import java.util.Arrays;

public class HashTable {
    String[] array;
    int  size;

    HashTable(int size){
        this.size = size;
        array = new String[size];

    }

    void hashFunction(String[] itemsToBeInserted, String[] theArray){
        for (int i = 0; i < itemsToBeInserted.length ; i++) {
            String newElement = itemsToBeInserted[i];
            int arrayIndex = Integer.parseInt(newElement)%29;
            System.out.println("Index=: "+ arrayIndex+ " for value: " + newElement);

            while(theArray[arrayIndex] != null){
                ++arrayIndex;

                System.out.println("Collision detected at index: " + arrayIndex);
                arrayIndex%=arrayIndex;
            }

            theArray[arrayIndex] = newElement;
        }
    }


}
