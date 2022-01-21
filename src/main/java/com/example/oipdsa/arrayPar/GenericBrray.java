package com.example.oipdsa.arrayPar;

public class GenericBrray<T> {

    private T [] data;
    private int size;

    public GenericBrray(int capacity){
        this.data =(T[]) new Object[capacity];
        this.size = 0;
    }

    public GenericBrray(){this(10);}

    private int cuont(){return size;}

    private int getCapacity(){return data.length;}

    private boolean isEmpty(){return size==0;}

    public boolean isContains(T t){
        for (int i=0;i<size;i++){
            if (data[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    private T findByIndex(int index){
        checkIndex(index);
        return data[index];
    }

    private int findByValue(T t){
        for (int i=0;i<size;i++){
            if(data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    private void insert(int index,T t){
        checkIndexAdd(index);
        if (size==data.length){
            resize(data.length<<1);
        }
        for (int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index]  =t;
        ++size;
    }

    private T deleteByIndex(int index){
        checkIndex(index);
        T t = data[index];
        for (int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        data[size]= null;
        --size;
        if (size==(data.length>>2)){
            resize(data.length>>1);
        }
        return t;
    }

    private int deleteByValue(T t){
        int index = findByValue(t);
        deleteByIndex(index);
        return index;
    }


    private void resize(int capacity) {
        T [] newArr = (T[]) new Object[capacity];
        for (int i=0;i<size;i++){
            newArr[i] = data[i];
        }
        data = newArr;
    }

    private void printAll(){
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    private void checkIndex(int index){
        if (index<0 || index>=size){
            System.out.println("输入下标不合法（查询/删除操作）");
            return;
        }
    }

    private void checkIndexAdd(int index){
        if (index<0 || index>size){
            System.out.println("插入操作输入下标不合法");
            return;
        }
    }

    public static void main(String[] args) {
        GenericBrray<Integer> brray = new GenericBrray<>(4);
        brray.insert(0,0);
        brray.insert(1,1);
        brray.insert(2,2);
        brray.insert(3,3);
        brray.insert(4,4);
        brray.insert(5,5);
        brray.printAll();
        brray.deleteByIndex(0);
        brray.deleteByValue(1);
        brray.printAll();

        String res = brray.findByIndex(0).toString();
        String res1 = brray.findByValue(5)+"";
        System.out.println(res+" "+res1)
        ;
    }
}
