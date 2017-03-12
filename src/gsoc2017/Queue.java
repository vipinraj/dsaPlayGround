package gsoc2017;

/**
 * @author vipin
 * Queue implementation 
 */
public class Queue<Type> {
	Type[] Q;
	Integer head = 0;
	Integer tail = 0;
	Integer length;

	@SuppressWarnings("unchecked")
	public Queue(Integer length) {
		this.Q = (Type[]) new Object[length];
		this.length = length;
	}

	void put(Type element) throws Exception {

		if ((this.tail + 1) % this.length == this.head) {
			throw new Exception("Queue overflows");
		}

		this.Q[this.tail] = element;
		if (this.tail == this.length - 1) {
			this.tail = 0;
		} else {
			this.tail++;
		}
	}

	Type pop() throws Exception {

		if (this.head == this.tail) {
			throw new Exception("Queue underflows");
		}

		Type x = this.Q[this.head];
		if (this.head == this.length - 1) {
			this.head = 0;
		} else {
			this.head++;
		}

		return x;
	}

	Type peek() throws Exception {
		if (this.head == this.tail) {
			throw new Exception("Queue is empty");
		}

		return this.Q[this.head];
	}
}
