package com.dennis;


public class HashTable {
    LinkedList[] arr;
    int arrSize;
    int itemsInArray;

    HashTable(int size){
        this.arr = new LinkedList[size];
        this.arrSize = size;
    }

    //grouping
    public void addItemsGrouping(String[] items, LinkedList[] arr){
        for(String s: items){
            int hash = hashFunction(s);
            if(arr[hash] != null){
                System.out.println("Collission detected");
                LinkedList p = arr[hash];
                while (arr[hash].next!= null){
                    arr[hash] = arr[hash].next;
                }
                arr[hash].next = new LinkedList(s);
                itemsInArray+=1;
            }else{

                arr[hash] = new LinkedList(s);
                itemsInArray +=1;
            }
        }
    }

    //linear expression
    public void addItems(String[] items, String[] arr){
        for(String s: items){
            int hash = hashFunction(s);
            if(arr[hash] != null){
                System.out.println("Collision detected");
                //use linear expression
                while(arr[hash] != null){
                    if(hash >= arrSize -1){
                        hash = -1;
                    }
                    hash+=1;
                }
                arr[hash] = s;
                itemsInArray+=1;
            }else{
                arr[hash] = s;
                itemsInArray+=1;
            }

        }
    }

    //retrieve item from the hash table
    int getItem(String item){
        int sum = 0;
        for(int i = 0; i <item.length(); i++){
            sum += item.charAt(i);
        }

        int hash = sum%arrSize;
        while(!arr[hash].equals(item)){
            if(hash >= arrSize -1){
                hash = -1;
            }
            hash+=1;
        }
        return hash;
    }

    public int hashFunction(String item){
        int sum = 0;
        for(int i = 0; i <item.length(); i++){
            sum += item.charAt(i);
        }

        return sum%arrSize;
    }

    void printHashTable(){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                System.out.println(i +" Contains null" );
            }else{
                while (arr[i] != null){
                    System.out.println(i + " Contains " + arr[i].val);
                    arr[i] = arr[i].next;
                }
            }

        }
    }

    class LinkedList{
        String val;
        LinkedList next;
        LinkedList(){}

        LinkedList(String item){
            this.val = item;
            this.next = null;
        }
    }
}
