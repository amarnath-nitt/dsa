package main.systemdesign;

class Element{
    int val;
    int minVal;
    Element(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
    }
}
public class MinStack {
    Element [] st = new Element[10000];
    int top = -1;

    MinStack(){
        top = -1;
    }

    public void push(int val){
      st[++top] = new Element(val, val);
      if(top > 0){
        st[top].minVal = Math.min(st[top].minVal, st[top - 1].minVal);
      }
    }

    public int top(){
        return st[top].val;
    }

    public int getMin(){
        return st[top].minVal;
    }

    public void pop(){
        top--;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(3);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
