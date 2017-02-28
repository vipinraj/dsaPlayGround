package datastructures;

public class TestStack {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack(10);
		System.out.println(stack.isEmpty());
		//stack.pop();
		stack.push(10);
		stack.push(13);
		stack.push(1);
		stack.push(16);
		
		
		
		System.out.println(stack.pop());
		stack.push(56);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
		///double stack
		System.out.println("double stack --------------------------- ");
		
		StackDouble dStack = new StackDouble(3,2);
		
		dStack.push(Stacks.STACK1, 1);
		dStack.push(Stacks.STACK1, 2);
		dStack.push(Stacks.STACK1, 3);
		
		dStack.push(Stacks.STACK2, 8);
		dStack.push(Stacks.STACK2, 9);
		
		System.out.println(dStack.pop(Stacks.STACK1));
		System.out.println(dStack.pop(Stacks.STACK2));
		System.out.println(dStack.pop(Stacks.STACK1));
		System.out.println(dStack.pop(Stacks.STACK2));
		
		dStack.push(Stacks.STACK2, 10);
		dStack.push(Stacks.STACK1, 12);
		System.out.println(dStack.pop(Stacks.STACK1));
		dStack.push(Stacks.STACK1, 12);
		dStack.push(Stacks.STACK1, 13);
		//dStack.push(Stacks.STACK1, 89);
		dStack.push(Stacks.STACK2, 10);
		//dStack.push(Stacks.STACK2, 19);
		
		System.out.println("------------------------shared double stack");
		
		StackDoubleShared stackDS = new StackDoubleShared(5);
		stackDS.push(Stacks.STACK1, 52);
		stackDS.push(Stacks.STACK1, 85);
		stackDS.push(Stacks.STACK1, 5);
		
		stackDS.push(Stacks.STACK2, 98);
		stackDS.push(Stacks.STACK2, 63);
		//stackDS.push(Stacks.STACK2, 9);
		System.out.println(stackDS.pop(Stacks.STACK1));
		stackDS.push(Stacks.STACK2, 78);
		System.out.println(stackDS.pop(Stacks.STACK2));
	}

}

