import java.util.Scanner;
public class TicTacToe{
	
	public char arr[][]=new char[3][3];
	public int type=1;
	
	
	public static void main(String args[]){
		TicTacToe obj=new TicTacToe();
		Scanner sc=new Scanner(System.in);
		//System.out.println("hello, world");
		do{
		obj.init();
		obj.maze();
		System.out.println("");
		System.out.println("1.Two Player Game");
		System.out.println("2.One Player Game");
		System.out.println("3.Exit");
		obj.type=sc.nextInt();
		if(obj.type==1){
			System.out.println("Starting multiplayer game...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//for keeping the move count
			StringBuffer player1 =new StringBuffer(""); 
			StringBuffer player2 = new StringBuffer("");
			boolean status=false;
			do{	
			obj.clearScreen();
			obj.maze();

			System.out.println("Player 1 \n Enter position:");
			int pos1=sc.nextInt();
			obj.mark(pos1,'X');
			player1.append(""+pos1);
			if(player1.length()>=3 ){
				if(obj.winCombination(player1)){
					status=true;
					System.out.println("Player 1 wins");
					sc.next();
					break;
					}
			}
			
			System.out.println("Player 2 \n Enter position:");
			int pos2=sc.nextInt();
			obj.mark(pos2,'O');
			player2.append(""+pos2);
			if(player2.length()>=3 ){
				if(obj.winCombination(player2)){
					status=true;
					System.out.println("Player 2 wins");
					sc.next();
					break;
					}
			}
			

		}while(!status);
		obj.clearScreen();

			


		//for  vs computer 
		}else if(obj.type==2){

		}

		}while(obj.type!=3);
	}


	boolean winCombination(StringBuffer player){
		String wincombo[]={"123","456","789","147","258","369"};
		
		for(String patt:wincombo){
			int flag=0;
			for(int i=0;i<3;i++){
				
				if (player.indexOf(""+patt.charAt(i))!=-1){
					flag+=1;
					
				}
			}
			if(flag==3){
				return true;
			}
		}
		return false;
			
	}


	void mark(int num,char player){
		for(int i=0;i<3;i++){

			for (int j=0;j<3;j++ ) {
				if(num==arr[i][j]){
					arr[i][j]=player;			//problem here
				}
			}
		}

	}

	void init(){
		char k='1';
		for(int i=0;i<3;i++){

			for (int j=0;j<3;j++ ) {
				arr[i][j]=k;
				k++;
			}
		}
	}

	void clearScreen(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
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