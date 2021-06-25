import java.util.Stack;

public class Zadatak2 {
    public static void main(String[] args) {
        Stack<Integer> nums= new Stack<>();
        nums.add(5);
        nums.add(10);
        nums.add(16);
        nums.add(15);
        nums.add(20);
        nums.add(25);
        nums.add(30);
        System.out.println(counter(nums));
    }

    private static Stack<Integer> counter(Stack<Integer> nums){
        Stack<Integer> ascending = new Stack<>();
        do {
            ascending.push(nums.pop());
        } while (ascending.peek() > nums.peek() || nums.isEmpty());
        return ascending;
    }
}
