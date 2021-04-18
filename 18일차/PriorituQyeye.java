///////오름차순
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{
	public static void main(String[] args) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		pq.add(new int[] {1});
		pq.add(new int[] {3});
		pq.add(new int[] {2});
		pq.add(new int[] {5});
		pq.add(new int[] {4});
		
		while(!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}
	}
}

//출력 
/*
[1]
[2]
[3]
[4]
[5]

*/

///내림차순
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{
	public static void main(String[] args) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		pq.add(new int[] {1});
		pq.add(new int[] {3});
		pq.add(new int[] {2});
		pq.add(new int[] {5});
		pq.add(new int[] {4});
		
		while(!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}
	}
}

/*
출력:
[5]
[4]
[3]
[2]
[1]

*/
