package QuestionOfStack;

import java.util.Stack;

public class ExpressionEvaluation {
    public static double preEval(String exp) {
        Stack<Double> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(Double.parseDouble(c + ""));
            } else {
                if (c == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else if (c == '-') {
                    stack.push(stack.pop() - stack.pop());
                } else if (c == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (c == '/') {
                    stack.push(stack.pop() / stack.pop());
                }
            }
        }
        return stack.pop();
    }

        public static double postEval(String exp) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(Double.parseDouble(c + ""));
            } else {
                if (c == '+') {
                    double d2 = stack.pop();
                    double d1 = stack.pop();
                    stack.push(d1 + d2);
                } else if (c == '-') {
                  double d2 = stack.pop();
                    double d1 = stack.pop();
                    stack.push(d1 - d2);
                } else if (c == '*') {
                    double d2 = stack.pop();
                    double d1 = stack.pop();
                    stack.push(d1 * d2);
                } else if (c == '/') {
                   double d2 = stack.pop();
                    double d1 = stack.pop();
                    stack.push(d1 / d2);
                }
            }
        }
        return stack.pop();
    }
}
