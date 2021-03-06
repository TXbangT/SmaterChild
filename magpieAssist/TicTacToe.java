package magpieAssist;

import java.util.*;
public class TicTacToe implements Game{
  private int[] info = new int [3][3];
  private String name = "TicTacToe";
  private Scanner s = new Scanner(System.in);
  private int x;
  private int y;
  public TicTacToe(){
  }
  /**
   * Starts the game
   */
  public void play(){
  	System.out.println("You are X Computer is O Computer makes first move");
  	computerMove();
  	while(checkWin()==-1()){
  		System.out.println("Input the location of your play (Range is 0-2 inclusive)");
  		System.out.print("X: ");
  		x = s.nextInt();
  		System.out.print("\nY: ");
  		y = s.nextInt();
  		Sysetm.out.println();
  		while(((x<0&&x>2)||(y<0&&y>2))||info[x][y]!=0){
  		  System.out.print("Invalid play: Please imput a different play");
  		  x = s.nextInt();
  		  y = s.nextInt();
  		}
  		System.out.println(move("X at " + x + " " + y));
  		System.out.println(computerMove());
  	}
  	endGame();
  }
  
  public String Move(String str){
    if(str.CharAt(0)=='X'){
      info[Integer.parseInt(str.substring(5,6))][Integer.parseInt(str.substring(7))] = 1;
    }else if(str.CharAt(0)=='O'){
      info[Integer.parseInt(str.substring(5,6))][Integer.parseInt(str.substring(7))] = 2;
    }
    return str; 
  }
  
  public String computerMove(){
    int x = (int)(Math.random()*3);
    int y = (int)(Math.random()*3);
    String out = "";
    while(info[x][y]!=0){
      x = (int)(Math.random()*3);
      y = (int)(Math.random()*3);
    }
    out = "O at " + x + " " + y;
    Move(out);
    return out;
  }
  
  public String toString(){
    String out = "";
    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        out += intToChar(info[i][j]);
        if(j<2)
        out += "|"
      }
      out += "\n"
      if(i<2)
        out+= "-----\n";
    }
  }
  
  /**
   * Turns a given int to an approate game
   */
  private String intToChar(int i){
    if(i==1){
      return "X";
    }else if(i==2){
      return "O";
    }else{
      return " ";
    }
  }
  /**
   * @Return -1 if no win; 0 if X win; 1 if O win; 2 if tie;
   */
  public int checkWin(){
    int winTile -1;
  	if(info[0][0]==info[1][1]&&info[2][2]=info[0][0]){
  		winTile = info[0][0];
  	}else if(info[0][2]==info[1][1]&&info[2][0]=info[0][2]){
  	  winTile = info[1][1];
  	}else{
  	  for(int i = 0; i<3; i++){
  	    if(info[0][i]==info[1][i]&&info[2][i]==info[0][i]){
  	      winTile = info[0][i];
  	      break;
  	    }
  	  }
  	    for(int i = 0; i<3; i++){
  	      if(info[i][0]==info[i][1]&&info[i][2]==info[i][0]){
  	        winTile = info[i][0];
  	        break;
  	      }
  	    }
  	  }
  	  for(int i = 0; i<3; i++){
  	    for(int j = 0; j<3; j++){
  	      if(info[i][j]==0){
  	        winTile = 2;
  	        i=4;
  	        break;
  	      }
  	    }
  	  }
  	  return winTile;
  	}
  	public String endGame(){}/*Pretend that this method returns a value based on how the checkWin method returns*/
  }
