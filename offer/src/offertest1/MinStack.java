package offertest1;

import java.util.*;

class MinStack {

    Stack<Integer>stack;
    HashMap<Integer,Integer>map;
    /** initialize your data structure here. */
    public MinStack() {
    stack=new Stack<>();
    map=new HashMap<>();
    }

    public void push(int x) {
        map.put(x,map.getOrDefault(x,0)+1);
       stack.push(x);
    }

    public void pop() {
       int tt= stack.pop();
        int val;
       if(map.containsKey(tt))
       {
           val=map.get(tt);
           if(val==1)
              map.remove(tt);
           else
            map.put(tt,map.get(tt)-1);
       }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min=Integer.MAX_VALUE;
      for(Map.Entry<Integer,Integer>entry:map.entrySet()){
          min=Math.min(min,entry.getKey());
      }
      return min;
    }
}
