import java.util.*;

class SetOfStacks<T>{
	ArrayList<Stack<T>> stacks;
	int threshold;
	int stackIndex;

	SetOfStacks(int t){
		stacks = new ArrayList<>();
		threshold = t;
		Stack<T> stack = new Stack<T>();
		stacks.add(stack);
		stackIndex = 0;
	}

	Stack<T> getCurrentStack(){
		return stacks.get(stackIndex);
	}

	Stack<T> addStack(){
		Stack<T> stack = new Stack<T>();
		stacks.add(stack);
		stackIndex++;
		return stack;
	}

	Stack<T> removeStack() throws Exception{
		if(stackIndex <= 0){
			throw new Exception();
		}
		stackIndex--;
		return stacks.get(stackIndex);
	}

	boolean isCurrentStackFull(){
		return (stacks.get(stackIndex).size() >= threshold);
	}

	boolean isCurrentStackEmpty(){
		return (stacks.get(stackIndex).isEmpty());
	}

	void push(T val){
		if(isCurrentStackFull()){
			addStack().push(val);
		}else{
			getCurrentStack().push(val);
		}
	}

	T pop() throws Exception{
		if(!isCurrentStackEmpty()){
			return getCurrentStack().pop();
		}
		if(stackIndex <= 0){
			throw new Exception();
		}
		return removeStack().pop();
	}

	T pop(int index) throws Exception{
		if(index >= stacks.size()){
			throw new Exception();
		}
		Stack<T> target = stacks.get(index);
		if(!target.isEmpty()){
			return target.pop();
		}
		throw new Exception();
	}

	void show(){
		Stack<T> curr = stacks.get(stackIndex);
		System.out.println("In stack "+(stackIndex+1));
		while(!curr.isEmpty()){
			System.out.println(curr.pop());
		}
		while(stackIndex > 0){
			stackIndex--;
			System.out.println("In stack "+(stackIndex+1));
			curr = stacks.get(stackIndex);
			while(!curr.isEmpty()){
				System.out.println(curr.pop());
			}
		}
	}

	public static void main(String[] args) throws Exception{
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		setOfStacks.push(6);
		setOfStacks.show();
	}
}
