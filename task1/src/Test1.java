
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(getPath(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
	
	private static String getPath(int n, int m){
		
		String str = "";
		
		int[] arr = new int[n];
		int[] temp = new int[m];
		
		for (int i = 0; i < n; i++ ) 
			arr[i] = i + 1;
		
		int i = 0;
		do{
			for (int j = 0; j < m; j++){
				temp[j] = arr[(i*(m - 1) + j) % n];
			}
			
			str += temp[0];
			
			if(temp[m -1] == arr[0])
				return str;
			
			i++;
		}
		while(true);
	}

}
