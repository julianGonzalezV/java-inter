package org.example.collections.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Stack: Ordered list of objects inserted and removed using LIFO policy
 * The first item added into the stack will be the last removed
 * The last item added into the stack will be the first removed
 *
 * Can be implemented with arrays or linkedList but this is more oriented and have specific operations and restrictions
 *
 * Operations:
 * Push(): add items on the top of the stack
 *
 * peek(): get the top item on the stack without removing it
 * Pop(): remove items on the top of the stack
 *
 * Usages:
 * - When needing to reverse something or keep track of state
 *
 */
public class StackSamples {

    private static void showIntro(){
        // Here Stranger Things will be the first I want to see
        Stack<String> pendingSeriesToSee = new Stack<>();
        pendingSeriesToSee.add("The rain");
        pendingSeriesToSee.add("Dark");
        pendingSeriesToSee.add("Black Mirror");
        pendingSeriesToSee.add("Stranger Things");
        System.out.println("pendingSeriesToSee  => "+pendingSeriesToSee);

        // Validation to avoid EmptyStackException
        if(!pendingSeriesToSee.isEmpty()){
            System.out.println("Top is => "+pendingSeriesToSee.peek());
            System.out.println("pendingSeriesToSee after peek() => "+pendingSeriesToSee);

            System.out.println("Removing Top  => "+pendingSeriesToSee.pop());
            System.out.println("pendingSeriesToSee after pop() => "+pendingSeriesToSee);
        }

        while(!pendingSeriesToSee.isEmpty()){
            pendingSeriesToSee.pop();
        }
        System.out.println("pendingSeriesToSee after while => "+pendingSeriesToSee);

    }

    /**
     * My version
     * @param input
     * @return
     */
    private static boolean isMatchedParentheses(String input){
        String cleanedInput = input.replaceAll("[A-Za-z]","");

        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')','(');
        parentheses.put('}','{');
        parentheses.put(']','[');
        parentheses.put('>','<');

        List<Character> justParenthesis = new ArrayList<>();
        Stack<Character> allParentheses = new Stack();


        for(char item: input.toCharArray()){
            if(item=='(' || item=='{' || item =='[' || item==')' || item=='}' || item ==']'|| item =='>' || item =='<'){
                justParenthesis.add(item);
            }
        }

        for (char cleanedItem: justParenthesis) {
            if(cleanedItem==')' || cleanedItem=='}' || cleanedItem ==']' || cleanedItem =='>'){
                allParentheses.pop();
            }else{
                allParentheses.push(cleanedItem);
            }


        }
        System.out.println("isMatchedParentheses => " +allParentheses.isEmpty());
        return allParentheses.isEmpty();
    }


    /**
     * Tutorial
     * Not sure about the complexity becasue it uses containsValue() into a loop so it could be O(n2)
     * @param input
     * @return
     */
    private static boolean isMatchedParenthesesV2(String input){
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')','(');
        parentheses.put('}','{');
        parentheses.put(']','[');
        parentheses.put('>','<');

        Stack<Character> allParentheses = new Stack();

        for (char item: input.toCharArray()) {
            if(parentheses.containsValue(item)){
                allParentheses.push(item);
            }
            if(parentheses.get(item)!=null){
                allParentheses.pop();
            }
        }
        System.out.println("isMatchedParentheses V2 => "+input+" Result:" +allParentheses.isEmpty());
        return allParentheses.isEmpty();
    }



    public static void main(String[] args) {
        //showIntro();
        isMatchedParentheses("()");
        isMatchedParentheses("[<incre>ment]");
        isMatchedParentheses("<increment(");

        isMatchedParenthesesV2("()");
        isMatchedParenthesesV2("[<incre>ment]");
        isMatchedParenthesesV2("<increment(");
    }
}
