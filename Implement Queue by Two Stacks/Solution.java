public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }
     private void stack1tostack2(){
          while(!stack1.empty()){
            stack2.push(stack1.pop());

          }
      }
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
    if(!stack2.empty()){
        return stack2.pop();
    }else{
        this.stack1tostack2();
        return stack2.pop();
    }
    }

    public int top() {
        if(!stack2.empty()){
        return stack2.peek();
    }else{
        this.stack1tostack2();
        return stack2.peek();
    } 
        
    }
}
