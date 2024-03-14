package org.example.collections.linkedlist;

import java.util.LinkedList;

/**
 * Unlike arrays, we don't have to shift elements for insertion or deletion,
 * but we just have to update the next and previous pointers.
 *
 * Linear data structure where
 * Each item is a node, and it contains the current value and
 * the pointer/reference to next item, this allows easily modify and retrieve and
 * in a sequential manner
 *
 * The first element is the head and the last the tail
 * if the next node is null then it should be the last element in the list
 *
 * Since elements are connected by pointers the elements don't need to be stored
 * at contiguous memory location so inserting and deleting an element are less expensive
 *
 * Singly linkedList: Is a structure where elements have a pointer to the next element
 * Doubly LinkedList: It's a structure where each elements have pointer to previous and next
 * element
 *
 * Useful when:
 * Insertion and deletion are main operations
 * Adding/removing at first and last position of the structure
 *
 * Disadvantages:
 * Sorting requires more memory
 * Searching is more expensive: need to traverse through data and find a specific element.
 */
public class LinkedListSamples {
    private static LinkedList getLikeListAfterOperations(){
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Paola");
        linkedList.add("Julian");
        linkedList.add("Matias");
        linkedList.add("Orfa");
        linkedList.add("Clarita");

        linkedList.addFirst("Zen");
        linkedList.addFirst("Robin");
        linkedList.add(2, "ruth");
        linkedList.addLast("ana");
        System.out.println("List after additions => "+linkedList);

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.indexOf("Paola"));

        System.out.println("Size: "+linkedList.size());

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove("Orfa");
        System.out.println("List after removals => "+linkedList);

        linkedList.clear();
        System.out.println("List after being clear => "+linkedList);

        return linkedList;
    }

    /**
     * Generic because we are allowing to remove any position, in this case the middle
     * @param inputNode
     */
    private static void removeMiddlePosGeneric(Node inputNode){
        int middlePos = (inputNode.getLenght()/2) -1;
        inputNode.remove(middlePos);
        System.out.println("removeMiddlePos result => "+inputNode);
    }

    /**
     * Deleting always the middle
     * @param inputNode
     */
    private static void removeMiddlePos(Node inputNode){
        int middlePos = (inputNode.getLenght()/2) -1;
        inputNode.remove(middlePos);
        System.out.println("removeMiddlePos result => "+inputNode);
    }


    private static Node getNode(){
        Node node1 = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");

        node1.setNext(node2);
        node2.setNext(node3);
        return  node1;
    }

    private static Node getNode2(){
        Node node1 = new Node("a");
        Node node2 = new Node("b");

        node1.setNext(node2);
        return  node1;
    }

    private static Node getNode3(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return  node1;
    }



    /**
     * Given a single linkedList delete the middle node from the original list
     * @param args
     */

    public static void main(String args[]){
        //getLikeListAfterOperations();

        Node node1 = getNode();
        Node node2 = getNode2();

        removeMiddlePosGeneric(node1);
        removeMiddlePosGeneric(node2);
        System.out.println(node1.print());
        System.out.println(node2.print());
        removeMiddlePosGeneric(new Node("a"));

        Node node3 = getNode();
        node3.removeMiddle();
        System.out.println("node3 => "+ node3);

        Node node4 = getNode3();
        node4.removeMiddle();
        System.out.println("node4 => "+ node4);

    }
}
