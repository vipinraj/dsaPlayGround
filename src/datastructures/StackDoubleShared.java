package datastructures;

import datastructures.Stacks;

public class StackDoubleShared {

	private Integer S[];

	private int top1 = -1;
	private int top2;
	private int size;

	public StackDoubleShared(Integer size) {
		this.size = size;
		S = new Integer[this.size];
		top2 = size;
	}

	public void push(Stacks stackName, Integer element) throws Exception {
		if (stackName.equals(Stacks.STACK1)) {
			if (top1 + 1 == top2) {
				throw new Exception("Stack overflows!");
			} else {
				top1++;
				S[top1] = element;
				System.out.println("Top1: " + top1 + " Top2: " + top2 );
			}
		} else {
			if (top2 - 1 == top1) {
				throw new Exception("Stack overflows!");
			} else {
				top2--;
				S[top2] = element;
				System.out.println("Top1: " + top1 + " Top2: " + top2 );
			}
		}
	}

	public Integer pop(Stacks stackName) throws Exception {
		if (stackName.equals(Stacks.STACK1)) {
			if (isEmpty(stackName)) {
				throw new Exception("Stack underflows!");
			}
			top1--;
			return S[top1 + 1];
		} else {
			if (isEmpty(stackName)) {
				throw new Exception("Stack underflows!");
			}
			top2++;
			return S[top2 - 1];
		}
	}
	
	public Boolean isEmpty(Stacks stackName){
		if(stackName.equals(Stacks.STACK1)){
			if(top1 == 0){
				return true;
			}else{
				return false;
			}
		}else{
			if(top2 == size - 1){
				return true;
			}else{
				return false;
			}
		}
	}
}
