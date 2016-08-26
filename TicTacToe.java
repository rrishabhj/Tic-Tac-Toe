
public class TicTacToe{
	
	public int arr[][]=new int[3][3];

	public static void main(String args[]){
		TicTacToe obj=new TicTacToe();

		System.out.println("hello, world");
		obj.init();
		obj.maze();
	}

	void init(){
		int k=1;
		for(int i=0;i<3;i++){

			for (int j=0;j<3;j++ ) {
				arr[i][j]=k;
				k++;
			}
		}
	}
	void maze(){
	
	for(int i=0;i<3;i++){

			System.out.println("   |   |   ");

			for (int j=0;j<3;j++ ) {
				
				System.out.print(" "+ arr[i][j] + " ");
				//so that it will not print a | at the last position
				if(j<2)
					System.out.print("|");
				
			}
			System.out.println();
			System.out.println("---|---|---");
		}	
	}
}