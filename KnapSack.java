import java.util.*;
public class KnapSack {
	static HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	static TreeSet<Integer> s = new TreeSet<Integer>();
	
	static void solution(int[] arr, int[] branch, int size, int index, int elements,int target) {
		if(elements==size) {
			int result=0;
			int check=0;
			for(int i=0; i<size; i++) {
				check+=branch[i];
				result+=m.get(branch[i]);
			}
			if(check<=target)s.add(result);
			return;
		}
		for(int i=index; i<arr.length; i++) {
			branch[elements] = arr[i];
			solution(arr,branch,size,++index,elements+1,target);
		}
	}
	static void helper(int[] arr,int target) {
		for(int i=0; i<=arr.length; i++) {
			int[] branch = new int[i];
			solution(arr,branch,i,0,0,target);
		}
	}
public static void main(String[] args) {
    int[] weight = {10,20,30};
    int[] value= {60,100,120};
    int target = 50;
    for(int i=0; i<weight.length; i++) m.put(weight[i], value[i]);
    helper(weight,target);
    System.out.println(s.last());
}
}
