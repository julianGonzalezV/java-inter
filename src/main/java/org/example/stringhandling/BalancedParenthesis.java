package org.example.stringhandling;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    private static boolean isValid(String input){
        Map<Character, Character> openClosedParenthesisMap = getOpenClosedParenthesisMap();
        Map<Character, Character> closeOpenedParenthesisMap = getCloseOpenedParenthesisMap();

        if(input.isEmpty() || input.length()%2!=0){
            return false;
        }
        LinkedList<Character> openedParenthesis = new LinkedList<>();

        for(char ch: input.toCharArray()){
            if(openClosedParenthesisMap.containsKey(ch)){
                openedParenthesis.add(ch);
                continue;
            }

            if(openedParenthesis.isEmpty() && closeOpenedParenthesisMap.containsKey(ch) ){
                return false;
            }

            if(closeOpenedParenthesisMap.containsKey(ch)){
                Character openParenthesis = closeOpenedParenthesisMap.get(ch);
                Character removed = openedParenthesis.removeLast();
                if(removed!=openParenthesis){
                    return false;
                }
            }

        }
        return openedParenthesis.isEmpty();

    }

    public static boolean isValidStackVersion(String input){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closedParenthesis = getCloseOpenedParenthesisMap();
        for (Character ch: input.toCharArray()) {

            if(stack.isEmpty()){
                stack.add(ch);
                continue;
            }

            if(closedParenthesis.get(ch)!= null && closedParenthesis.get(ch).equals(stack.peek())){
                stack.pop();
                continue;
            }
            stack.add(ch);

        }
        return stack.isEmpty();

    }

    private static Map<Character, Character> getOpenClosedParenthesisMap(){
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('(', ')');
        parenthesis.put('{', '}');
        parenthesis.put('[', ']');
        parenthesis.put('(', ')');
        return parenthesis;
    }

    private static Map<Character, Character> getCloseOpenedParenthesisMap(){
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put(')', '(');
        parenthesis.put('}', '{');
        parenthesis.put(']', '[');
        parenthesis.put(')', '(');
        return parenthesis;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{[()]}"));
        System.out.println(isValidStackVersion("()[]{[()]}"));
    }

}
