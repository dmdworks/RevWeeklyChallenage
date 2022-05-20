package freelance.com;

import java.util.ArrayList;
import java.util.List;

public class Week1Challenage {
	public List<Integer> sumList(List<Integer> num1, List<Integer> num2){
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		StringBuilder str3 = new StringBuilder();
		List<Integer> answer = new ArrayList<>();
		
		for(int n1: num1) {
			str1.append(n1);
		}
		
		for(int n2: num2) {
			str2.append(n2);
		}
		
		int number1 = Integer.parseInt(str1.toString());
		int number2 = Integer.parseInt(str2.toString());
		int ans = number1 + number2;
		
		str3.append(ans);
		
		for(int i=0; i<=str3.length()-1; i++) {
			answer.add(Integer.parseInt(String.valueOf(str3.charAt(i))));
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		Week1Challenage challenge = new Week1Challenage();
		StackMin minStack = new StackMin(12);
		
		List<Integer> num1 = new ArrayList<>();
		num1.add(3);
		num1.add(9);
		num1.add(4);
		List<Integer> num2 = new ArrayList<>();
		num2.add(1);
		num2.add(4);
		num2.add(6);
		
		System.out.println(challenge.sumList(num1, num2));
		
		minStack.push(6);
		minStack.push(19);
		minStack.push(3);
		minStack.push(8);
		
		System.out.println(minStack.min());
	}

}

class StackMin{
	private List<Integer> numbers;
	private List<Integer> min;
	
	StackMin(int first){
		this.numbers = new ArrayList<>();
		this.min = new ArrayList<>();
		
		numbers.add(first);
		min.add(first);
	}
	
	public void push(int num) {
		if(min.size()==1) {
			if(num < min.get(0)) {
				min.add(num);
			}
		}else if(num < min.get(1)) {
			min.set(0, min.remove(1));
			min.add(num);
		}
		
		numbers.add(num);
	}
	
	public int pop() {
		if( numbers.get(numbers.size()) == min.get(1) ) {
			min.set(1, min.get(0));
		}
		return numbers.remove(numbers.size());
	}
	
	public int min() {
		if(min.size()==1) {
			return min.get(0);
		}else {
			return min.get(1);
		}
	}
	
}
