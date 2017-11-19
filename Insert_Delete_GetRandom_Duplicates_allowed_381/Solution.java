package Facebook.Insert_Delete_GetRandom_Duplicates_allowed_381;

import java.util.*;

// insert O(1)：linkedlist insert at tail and arraylist insert and tail are all O(1) time complexity
// get random: according to array size, get a random number which is between 0 and array.size-1;

// remove element: linkedlist and arraylist remove at tail both O(1) time complexity
// 但是我们要删掉的元素不一定就在tail的位置，所以，我们可以把要删掉的元素和tail的元素swap一下，然后把tail删掉，这样就可以保证O（1）的时间
// 所以我们需要一个hashmap来记录元素的位置，因为有重复的元素，therefore the hashmap's key will be element, value will be index for this element in the list
// 因为删掉一个元素，我们还需要access这个元素的位置，所以我们选择arraylist

//因为有重复的元素,所以在hashmap里面存list或者set,因为set的remove，add都是O（1）的时间，所以我们选择用set，用list的话，更新元素的index会比较麻烦一点.
// 我们删除这个元素的时候，会把尾巴的元素替换到当前元素的位置，所以我要更新尾巴元素的index，同时删掉当前元素在set里的index


public class Solution {
}
class RandomizedCollection {

    List<Integer> list;
    Map<Integer,Set<Integer>> map;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> linkedHashSet = map.get(val);
        boolean result = false;
        if(linkedHashSet == null)
        {
            //check if the current value is exist in the hashset before
            result = true; //set the result to true of the collection is not exist in the HashMap before
            linkedHashSet = new LinkedHashSet<>();
            //the element is not exist in the hashmap before
            map.put(val,linkedHashSet);
        }
        linkedHashSet.add(list.size());   //add current element index into the set
        list.add(val);  //add current element into the end of the arraylist
        return result; //return true if element is not exist before
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> linkedHashSet = map.get(val);
        if(linkedHashSet == null)
        {
            return false;
        }
        int index = linkedHashSet.iterator().next(); //从set里拿出一个这个数的index
        linkedHashSet.remove(index);  //因为要删掉这个数，所以把这个数的index从hashset里面删掉

        if(index < list.size()-1)
        {
            //current index is not the tail of the list
            //therefore we need to replace the tail element into current index
            //then remove the tail

            //get the last element value
            int last_element = list.get(list.size()-1);
            list.set(index,last_element);     //replace current index value to last element value

            //since we remove the last element to the current index, then we need to update last element's index in the hashset

            map.get(last_element).remove(list.size() -1);  //delete原先的index删掉 for last element
            map.get(last_element).add(index);
        }

        list.remove(list.size()-1); //因为最后一位element已经被我们替换到前面去了，所以我们把最后一个element删掉

        if(map.get(val).isEmpty())
        {
            //if this value is only one exist in the linkedhashmap, therefore if we remove this value, we also remove this value from hahsmap
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get( rand.nextInt(list.size()) );
    }
}
