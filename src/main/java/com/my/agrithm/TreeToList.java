package com.my.agrithm;

/**
 * Created by Xiaoming Wang on 2014/11/14.
 */
public class TreeToList {
    private static class BTree{
        public int data;
        public BTree left;
        public BTree right;
    }

    private static class LinkedList{
        public int data;
        public LinkedList next;
    }

    private void convert(BTree t, LinkedList l){
        l.data = t.data;
        {
            if(t.left != null){
                l.next = new LinkedList();
                convert(t.left, l.next);
            }
            if(t.right != null){
                l.next = new LinkedList();
                convert(t.right, l.next);
            }
        }
    }

    public static void main(String[] args){
        BTree b = new BTree();

    }
}
