// building a stack of strings
// exercise
import java.util.*;

interface Stack { // given
	int length(); // n of strings saved
	int capacity(); // size of stack
	String pop(); // return string on top of stack
	boolean push(String val); // push string to stack
}

class StringStack implements Stack {
	private String[] stack;
	private int length = 0;
	private int capacity;
	
	public StringStack() {
		System.out.print("Length of the stack >> ");
		Scanner scInt = new Scanner(System.in);
		capacity = scInt.nextInt();
		stack = new String[capacity];
		String str = new String();
		Scanner scStr = new Scanner(System.in);
		while (true) {
			System.out.print("Input string >> ");
			str = scStr.nextLine();
			if (str.toLowerCase().equals("stop")) break;
			if (!this.push(str)) System.out.println("Stack is full.");
		}
	}
	
	@Override
	public int length() {
		return length;
	}
	
	@Override
	public int capacity() {
		return capacity;
	}
	
	@Override
	public String pop() {
		return stack[--length];
	}
	
	@Override
	public boolean push(String val) {
		if (length < capacity) {
			stack[length++] = val;
			return true; // pushing succeeded
		}
		else return false; // pushing failed
	}
	
	public void stackPop() {
		System.out.print("Pop all strings in stack : ");
		while (length > 0) {
			System.out.print(this.pop() + " ");
		}
	}
}

public class stack_of_strings {

	public static void main(String[] args) {
		StringStack strStack = new StringStack();
		strStack.stackPop();
	}

}
