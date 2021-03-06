package com.github.algorithms.hackerrank.stacksandqueues;


import java.util.*;

public class BalancedBrackets {

    public static final String RESULT_YES = "YES";
    public static final String RESULT_NO = "NO";

    public static void main(String[] args) {
        //NO
        System.out.println(isBalanced("}][}}(}][))]"));
        //YES
        System.out.println(isBalanced("[](){()}"));
        //YES
        System.out.println(isBalanced("()"));
        //YES
        System.out.println(isBalanced("({}([][]))[]()"));
        //NO
        System.out.println(isBalanced("{)[](}]}]}))}(())("));
        //NO
        System.out.println(isBalanced("{[(])}"));
        //YES
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    private static Set<Character> openingBrackets = initOpeningBrackets();
    private static Map<Character, Character> bracketPairs = initBracketPairs();

    static String isBalanced(String s) {
        Stack<Character> bracketsStack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (isOpeningBracket(bracket)) {
                bracketsStack.push(bracket);
            } else {
                if (!isClosingLastBracket(bracketsStack, bracket)) {
                    return RESULT_NO;
                }
            }
        }

        return bracketsStack.isEmpty() ? RESULT_YES : RESULT_NO;
    }

    private static boolean isOpeningBracket(char bracket) {
        return openingBrackets.contains(bracket);
    }

    private static boolean isClosingLastBracket(Stack<Character> bracketsStack, char closingBracket) {
        try {
            return bracketsStack.pop().equals(reversed(closingBracket));
        } catch (EmptyStackException e) {
            return false;
        }
    }

    private static Character reversed(char bracket) {
        return bracketPairs.get(bracket);
    }

    private static Set<Character> initOpeningBrackets() {
        Set<Character> openingBrackets = new HashSet<>();
        openingBrackets.add('{');
        openingBrackets.add('(');
        openingBrackets.add('[');
        return openingBrackets;
    }

    private static Map<Character, Character> initBracketPairs() {
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put('}', '{');
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        return bracketPairs;
    }
}
