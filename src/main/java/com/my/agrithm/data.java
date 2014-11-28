package com.my.agrithm;

/**
 * Created by Xiaoming Wang on 2014/11/21.
 */
public class data {
    public static void main(String[] args) {
        int len = 100000;
        SNode first = null;
        SNode current = first;
        for (int i = 1; i <= len; i++) {
            SNode tmp = new SNode();
            tmp.data = i;
            if (first == null) {
                first = tmp;
                current = first;
                continue;
            }

            current.next = tmp;
            current = tmp;
        }
        findLast(first, 70000);
        findLast2(first, 70000);
        //print(first);
        //fold(first, len);

        //GetMinNotExisting();
    }

    private static int findLast(SNode l, int n) {
        Long start = System.currentTimeMillis();
        SNode p1 = l;
        SNode p2 = l;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("findLast:" + (System.currentTimeMillis() - start));
        return p2.data;
    }

    private static int findLast2(SNode l, int n) {
        Long start = System.currentTimeMillis();
        SNode p1 = l;
        int cnt = 1;
        while (p1.next != null) {
            p1 = p1.next;
            cnt++;
        }
        p1 = l;
        for (int i = 0; i < cnt - n; i++) {
            p1 = p1.next;
        }
        System.out.println("findLast2:" + (System.currentTimeMillis() - start));
        return p1.data;
    }

    private static void fold(SNode n, int len) {

        SNode first2 = null;
        SNode current = n;
        SNode current2 = null;
        int i = 0;
        while (current != null) {
            i++;
            if (i > len / 2) {
                SNode tmp = new SNode();
                tmp.data = current.data;
                tmp.next = first2;
                first2 = tmp;
            }
            current = current.next;
        }

        current = n;
        current2 = first2;
        i = 0;
        while (current.next != null) {
            i++;
            if (i > len / 2) {
                current.next = null;
                break;
            }


            SNode tmp = current.next;
            SNode tmp2 = current2.next;
            current.next = current2;
            current2.next = tmp;
            current = tmp;
            current2 = tmp2;
        }
        print(n);
    }

    private static void print(SNode n) {
        SNode tmp = n;
        while (tmp != null) {
            System.out.print(tmp.data + ",");
            tmp = tmp.next;
        }
        System.out.println();
    }

    private static void GetMinNotExisting() {
        int[] arr = {1, 1};
        int[] arr2 = new int[arr.length];
        for (int i : arr) {
            if (i > 0 && i <= arr.length) {
                arr2[i - 1] = i;
            }
        }
        int res = arr2.length + 1;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == 0) {
                res = i + 1;
                break;
            }
        }
        System.out.print(res);
    }

    private static class SNode {
        public SNode next;
        public int data;
    }
}