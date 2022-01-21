package com.example.oipdsa.linkedPar;

public class SingleLinked<T> {

    private Node<T> head = null;

    private Node findByValue(T t){
        Node p = head;
        while (p!=null && p.data!=t){
            p = p.next;
        }
        return p;
    }

    private Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p!=null && pos!=index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    private void insertToHead(T t){
        Node newNode = createNode(t);
        if (head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    private void insertTail(T t){
        Node newNode  = createNode(t);
        if (head==null){
            head = newNode;
        }else{
            Node p = head;
            while (p.next!=null){
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    private void insertAfter(Node p,T t){
        Node newNode = createNode(t);
        if (p==null)return;
        newNode.next = p.next;
        p.next = newNode;
    }


    private void insertBefore(Node p,T t){
        if (p==null)return;
        if (head==p){
            insertToHead(t);
            return;
        }
        Node newNode = createNode(t);
        Node q = head;

        while (q!=null && q.next!=p){
            q = q.next;
        }

        newNode.next = p;
        q.next = newNode;
    }

    private void deleteNode(Node p){
        if (head == null || p ==null)return;

        if (head==p){
            head = head.next;
            return;
        }
        Node q = head;
        while (q!=null && q.next!=p){
            q = q.next;
        }
        if (q==null)return;
        q.next = q.next.next;

    }

    private void deleteValue(T t){
        if(head ==null)return;

        Node p = head;
        Node q = null;
        while (p!=null && p.data!=t){
            q = p;
            p = p.next;
        }

        if (p==null)return;

        if (q==null){
            head = head.next;
        }else{
            q.next = q.next.next;
        }


    }

    private void printAll(){
        Node p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }




    private Node createNode(T t){return new Node(t,null);}


    public static class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
        public T getData(){return data;}
    }

    public static void main(String[] args) {
        SingleLinked linked = new SingleLinked();
        int [] arr = {0,1,4,2,3,5};
        for (int i=0;i<arr.length;i++){
//            linked.insertToHead(arr[i]);
            linked.insertTail(arr[i]);

        }
        linked.printAll();
        Node p = linked.findByIndex(1);
//        linked.insertAfter(p,21);
        linked.insertBefore(p,21);
        linked.printAll();

        linked.deleteValue(21);
        Node q = linked.findByValue(5);
        linked.deleteNode(q);
        linked.printAll();
    }

}
