import java.util.ArrayList;
import java.util.Collections;

class HeapAlgo {
	public static void main(String args[]){
		int count = 0;
		int number = 0;
		int[] a = { 1, 2, 3, 4 };
		int size = a.length;
		int[] c = new int[size];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int k=0, l=size-1; k<size; k++, l--) {
			number += Math.pow(10, l)*a[k];
			c[k] = 0;
			count++;
		}
		list.add(number);
		number=0;
		
		int i = 0;
		while(i<size){
			if (c[i]<i){
				if (i%2==0) { int temp = a[0]; a[0] = a[i]; a[i] = temp; } // İf i is even, swap a[0] to a[i]
				else { int temp = a[c[i]]; a[c[i]] = a[i]; a[i] = temp; } // İf i is odd, swap a[c[i]] to a[i]
				for(int k=0, l=size-1; k<size; k++, l--){
					number += Math.pow(10, l)*a[k];
					count++;
				}
				list.add(number);
				number=0;
				c[i] += 1;
				i=0;
			}
			else{
				c[i] = 0;
				i += 1 ;
			}
		}
		Collections.sort(list);
		for(int allNumber:list){
			System.out.println(allNumber);  
		}
		System.out.println("Number of Permutations: " + count/size);
	}
}
