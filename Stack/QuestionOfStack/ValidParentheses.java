package QuestionOfStack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((stack.peek() == '(' && ch == ')')
                        ||
                        (stack.peek() == '{' && ch == '}')
                        ||
                        (stack.peek() == '[' && ch == ']')) {
                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        // System.out.println(isValid("({{[]}})"));

        // String str = "   fly me   to   the moon  ";
       String s = "luffy is still joyboy";
        // System.out.println(str.trim());
        s = s.trim();
        // System.out.println(str);
        String[] str2 = s.split(" ");

        System.out.println(str2[str2.length - 1].length());
    }
}
