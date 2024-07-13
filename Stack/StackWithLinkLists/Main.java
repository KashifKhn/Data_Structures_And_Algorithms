
package StackWithLinkLists;
public class Main {

    public static void main(String[] args) {
        StackLink<Integer> stack = new StackLink<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
    }

    

}