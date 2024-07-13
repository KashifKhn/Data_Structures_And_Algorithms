package QuestionOfStack;

import java.util.Stack;

public class ExpressionConvert {

  public static String infixToPostFix(String exp) {
    Stack<Character> stack = new Stack<>();
    String cExp = "";
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        cExp += c;
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          cExp += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
          cExp += stack.pop();
        }
        stack.push(c);
      }
    }
    return cExp;
  }

  public static String infixToPreFix(String exp) {
    Stack<Character> stack = new Stack<>();
    String rExp = reverseString(exp);
    String cExp  = "";
    for (int i = 0; i < rExp.length(); i++) {
      char c = rExp.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        cExp += c;
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.empty() && stack.peek() != '(') {
          cExp += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
          cExp += stack.pop();
        }
        stack.push(c);
      }
    }
    return reverseString(cExp);
  }

  public static String reverseString(String exp) {
    String rExp = "";
    for (int i = exp.length() - 1; i >= 0; i--) {
      if (exp.charAt(i) == '(') {
        rExp += ')';
      } else if (exp.charAt(i) == ')') {
        rExp += '(';
      } else {
        rExp += exp.charAt(i);
      }
    }
    return rExp;
  }

  private static int precedence(char charAt) {
    switch (charAt) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }
}
