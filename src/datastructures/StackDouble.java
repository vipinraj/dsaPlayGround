package datastructures;

/**
 * Two separate stacks in one array
 * @author vipin
 *
 */
public class StackDouble {

	Integer S[];

	Integer lengthS1;
	Integer lengthS2;
	Integer topS1 = -1;
	Integer topS2 = -1;

	public StackDouble(Integer size1, Integer size2) {
		S = new Integer[size1 + size2];
		lengthS1 = size1;
		lengthS2 = size2;
	}

	public void push(Stacks stack, Integer element) throws Exception {
		if (stack.equals(Stacks.STACK1)) {
			if (topS1 == lengthS1 - 1) {
				throw new Exception("Stack overflow!");
			}else{
				topS1++;
				S[topS1] = element;
			}
		}else if(stack.equals(Stacks.STACK2)){
			if (topS2 == lengthS2 - 1) {
				throw new Exception("Stack overflow!");
			}else{
				topS2 ++;
				S[topS2+lengthS1] = element;
			}
		}
	}
	
	public Integer pop(Stacks stack) throws Exception{
		if(stack.equals(Stacks.STACK1)){
			if(topS1 == -1){
				throw new Exception("Stack underflows!");
			}
			topS1 --;
			return S[topS1+1];
		}else{
			if(topS2 == -1){
				throw new Exception("Stack underflows!");
			}
			topS2 --;
			return S[lengthS1 + topS2 + 1];
		}
	}
	
	public Boolean isEmpty(Stacks stack){
		if(stack.equals(Stacks.STACK1)){
			if(topS1 == -1){
				return true;
			}else{
				return false;
			}
		} else{
			if(topS2 == -1){
				return true;
			}else{
				return false;
			}
		}
	}
}
