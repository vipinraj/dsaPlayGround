package datastructures;

public class Stack<Type> {
	private Type S[];
	private Integer top = 0;

	@SuppressWarnings("unchecked")
	public Stack(Integer size) {
		this.S = (Type[])new Object[size];
	}

	public void push(Type element) {
		this.top++;
		S[top-1] = element;
	}
	
	public Type pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack underflow");
		}else{
			this.top --;
			return S[this.top];
		}
	}
	
	public Boolean isEmpty(){
		if(this.top == 0){
			return true;
		}else{
			return false;
		}
	}
}
