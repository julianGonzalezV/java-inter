package org.example.collections.linkedlist;

import java.util.Objects;

public class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
    }

    public int getLenght(){
        int lenght = 1;
        Node nextNode = this.getNext();
        while (Objects.nonNull(nextNode)){
            lenght ++;
            nextNode = nextNode.getNext();
        }
        return lenght;
    }

    public void remove(int positionToDelete){
        int position = 0;
        Node currentNode = this;
        while (Objects.nonNull(currentNode)){
            Node nextNode = currentNode.getNext();
            if(position == positionToDelete){
                currentNode.setNext(nextNode.getNext());
            }
            position ++;
            currentNode = currentNode.getNext();
        }
    }

    /**
     * Sample1:
     * (1,(2,(3,null)))
     *      iteration1 => fast=(3,null); previous=(1,(2,(3,null))); slow=(2,(3,null))
     *      iteration2 => No iteration because fast.getNext = null
     *      previous.setNext((3,null)) =>  previous from iteration1 is replaced to (1,(3,null))
     *      Result = Having 1.-> this=(1,(3,null)) and previous is  (1,(3,null))
     *
     * Sample2:
     *      fast=(1,(2,(3,(4,null))))
     *      slow=(1,(2,(3,(4,null))))
     *      previous=null
     *
     *      iteration1 => fast=(3,(4,null)); previous=(1,(2,(3,(4,null)))); slow=(2,(3,(4,null)))
     *      iteration2 => fast=null; previous=(2,(3,(4,null))); slow=(3,(4,null))
     *      iteration3 =>  No iteration because fast = null
     *      previous.setNext((4,null)) =>  previous from iteration2 is replaced to (2,(4,null)))
     *      Result = Having 1.-> this=(1,(2,(3,(4,null)))) then   2. previous from iteration2 is a references to the same
     *      memory of this, which is (2,(3,(4,null)))
     *      is replaced by (2,(4,null))) ..then this= (1, (2,(4,null)))) Awesome right!?
     *
     *  The algorithm uses the fast and slow strategy see:
     *  The slow node goes one node at time
     *  The fast node goes two node at time
     *  When the fast node is null or is the last in the list (next is null) then slow node is in the middle of the
     *  list, see
     *  https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2003:%20Fast%20%26%20Slow%20pointers.md
     *
     *  it should be used when:
     *  Finding cycles in an array, linkedList or graph
     *  https://codeburst.io/fast-and-slow-pointer-floyds-cycle-detection-algorithm-9c7a8693f491
     */
    public void removeMiddle(){
        if(this == null || this.getNext() == null){
            return;
        }
        Node slow = this;
        Node fast = this;
        Node previous = null;

        while(fast != null && fast.getNext() !=null){
            fast = fast.getNext().getNext();
            previous = slow;
            slow = slow.getNext();
        }

        previous.setNext(slow.getNext());
        System.out.println(previous);
    }

    public String print(){
        StringBuilder result = new StringBuilder("[");
        Node currentNode = this;
        while (currentNode!=null){
            result.append(currentNode.getData());
            if( currentNode.getNext() !=null){
                result.append(",");
            }

            currentNode = currentNode.getNext();
        }
        result.append("]");
        return result.toString();
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
