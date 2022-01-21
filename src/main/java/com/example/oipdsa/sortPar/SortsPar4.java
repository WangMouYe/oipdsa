package com.example.oipdsa.sortPar;

public class SortsPar4 {

    private Node tree ;

    private Node find(int data){
        Node p = tree;
        while (p!=null){
            if (data>p.data)p = p.right;
            else if (data<p.data)p = p.left;
            else return p;
        }
        return null;
    }

    private void insert(int data){
        if (tree==null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p!=null){
            if (data<p.data){
                if (p.left==null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
                if (p.right ==null ){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    private void delete(int data){
        Node p = tree;
        Node pp = null;

        while (p!=null && p.data!=data){
            pp = p;
            if (data<p.data)p = p.left;
            else p = p.right;
        }

        if (p==null)return;

        if (p.left!=null && p.right!=null){
            Node minP = p.right;
            Node minPP = p;
            while (minP.left!=null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;

        }

        Node child;
        if (p.left!=null)child = p.left;
        else if (p.right!=null)child = p.right;
        else child = null;

        if (pp==null)tree = child;
        else if (pp!=pp.left)pp.left = child;
        else pp.right = child;

    }

    public Node findMin(){
        if (tree==null)return null;
        Node p = tree;
        while (p.left!=null){
            p =p.left;
        }
        return p;
    }
    public Node findMax(){
        if (tree==null)return null;
        Node p =tree;
        while (p.right!=null){
            p = p.right;
        }
        return p;
    }


    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }
    }
}
