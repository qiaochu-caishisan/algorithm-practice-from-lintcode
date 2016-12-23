public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    
    public MinStack() {
      stack = new Stack<>();
      minstack = new Stack<>();
    }

    public void push(int number) {
        stack.push(number);
        if(minstack.empty()){
            minstack.push(number);
        }else{
            minstack.push(Math.min(number, minstack.peek()));
        }
    }

    public int pop() {
        minstack.pop();
        return stack.pop();

    }

    public int min() {
        return minstack.peek();
    }
}
