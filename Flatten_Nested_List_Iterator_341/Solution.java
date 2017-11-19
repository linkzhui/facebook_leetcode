package Facebook.Flatten_Nested_List_Iterator_341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;


//思路：In the constructor, we push all the element from the nestedList into the stack from back to front,
// so when we pop the stack, it returns the very first element.

//Second, in the hasNext() function, we peek the first element in stack currently, and if it is an Integer,
// we will return true and pop the element. If it is a list, we will further flatten it.
interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list// Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
abstract class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i>=0;i--)
        {
            stack.offerLast(nestedList.get(i));
        }
        return;
    }

    @Override
    public Integer next() {
        return stack.pollLast().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            //we have nested list in the stack right now
            NestedInteger curr = stack.peekLast();
            if(curr.isInteger()) {
                //if current nested list is integer
                return true;
            }

            //if current nested list is
            stack.pollLast();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                //flatten current nested list, we want order from left to right when the element is popped from the stack,
                // therefore we push the most right element into the stack first
                stack.offerLast(curr.getList().get(i));
            }
        }
        return false;
    }
}
