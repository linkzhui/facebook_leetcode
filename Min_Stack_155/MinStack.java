package Facebook.Min_Stack_155;

import java.util.ArrayDeque;
import java.util.Deque;

//stack里面保存一个自己定义的class，这个class will record current Min value，current element value
//when we push a new value into the stack, we will compare the current value with stack.peek.min,
//if current value is less than peek.min, then we will push (new Node(x,x));
//if current value is bigger than peek.min, then we will push (new Node(x,peek.min));
public class MinStack {

    class Node{
        int val;
        int min;
        public Node(int val, int min)
        {
            this.val = val;
            this.min = min;
        }
    }
    Deque<Node> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty())
        {
            stack.offerLast(new Node(x,x));
        }
        else{
            Node prev = stack.peekLast();
            stack.offerLast(new Node(x,Math.min(prev.min,x)));
        }
    }

    public void pop() {
        if(!stack.isEmpty())
        {
            stack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast().val;
    }

    public int getMin() {
        return stack.peekLast().min;
    }
}
