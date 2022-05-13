package freelance.com;

import java.util.ArrayList;
import java.util.List;

public class WeekChallenage {
	//Returns -1 if there is no magic index
	public int magicIndex(int[] A){
		for(int i=0; i<A.length; ++i) {
			if(i==A[i]) {
				return i;
			}
		}
		return -1;
	}
	//This is terribly inefficient and doesn't fully work. I'll be thinking on this more
	public List<List<Integer>> powerSet(List<Integer> set, List<List<Integer>> subsets){
		if(set.size()<=1) {
			return subsets;
		}
		
		List<Integer> current = new ArrayList<>();
		for(Integer num: set) {
			current.add(num);
		}
		subsets.add(current);
		
		List<Integer> temp = new ArrayList<>();
		temp.add(set.get(0));
		subsets.add(temp);
		
		for(int i=1; i<set.size(); ++i) {
			List<Integer> temp2 = new ArrayList<>();
			temp2.add(set.get(0));
			temp2.add(set.get(i));
			subsets.add(temp2);
		}
		
		set.remove(0);
		
		if(set.size()<=1) {
			List<Integer> temp4 = new ArrayList<>();
			temp4.add(set.get(0));
			subsets.add(temp4);
		}
		
		return powerSet(set, subsets);
	}
	
	public int recMulti(int num1, int num2){
		if(num2 == 0) {
			return 0;
		}else {
			return num1+recMulti(num1, num2-1);
		}
	}

	public static void main(String[] args) {
		WeekChallenage challenage = new WeekChallenage();
		int[] A = {3,5,6,3,9,4};
		List<Integer> set = new ArrayList<>();
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		//Prints 3 with the above test array
		System.out.println(challenage.magicIndex(A));
		//Prints 15 as it solves 3*5
		System.out.println(challenage.recMulti(3, 5));
		//An attempt at returning all subsets but my logic does miss some sets
		System.out.println(challenage.powerSet(set, subsets));
	}

}
