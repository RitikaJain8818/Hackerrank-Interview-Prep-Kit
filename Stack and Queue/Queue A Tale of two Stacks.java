import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class MyQueue<T>{
        Stack<T> stack_newest_on_top=new Stack<>();
        Stack<T> stack_oldest_on_top=new Stack<>();   
        void enqueue(T x) {
            stack_newest_on_top.push(x);
        }
        T dequeue() {
            if(stack_oldest_on_top.empty()) my_arrange();
            return stack_oldest_on_top.pop();
        }
        T peek() {
            if(stack_oldest_on_top.empty()) my_arrange();
            return stack_oldest_on_top.peek();
        }
        void my_arrange() {
            int size = stack_newest_on_top.size();
            for(int i = 0; i < size; i++) {
                stack_oldest_on_top.push(stack_newest_on_top.peek());
                stack_newest_on_top.pop();
            }
        }
}
public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

