/*
Board.java
Board class for the Parcheesi game.
version 0.1

By Matt Swinton
Started 9/23/2015

About this class:
I decided to implement this as effectively a linked list of Spaces.
Complicating this is the fact that depending on the version you are paying a
space can have multiple next spaces depending on piece being moved.
While traversing a linked list is inefficient, it makes my job a lot easier and
I doubt efficiency will be an issue.  This also allows us to refresh the board
after every step is taken in order to show a piece moving, which might be nice.

The list has to be doubly-linked since there are formats where players move in
opposite directions.

Space Types:
Start - Starting area.
Outter - Standard white/blue bordered space, may be safe may be an entrance.
Runway - Colored space leading to Home.
*/

import Space;

public class Board{
    
    #Class Variables
    Space redStart;
    Space greenStart;
    Space yellowStart;
    Space blueStart;
    Space redEntrance;
    Space greenEntrance;
    Space yellowEntrance;
    Space blueEntrance;

    Space[] board;    #Holds all spaces, including start/home.  Order: Starting>outter>Inner>Home, always in RGYB order.

    #Innit method.  Can you tell I'm rusty yet?  (still working in Vim)
    public void Board( ){

    	#Initialize BoardStoared (main array).
	board = new Space[101];
    	
	#Create the home areas
	redStart = new Space("start");
	greenStart = new Space("start");
	yellowStart = new Space("start");
	blueStart = new Space("start");
	redStart = board[0];
	greenStart = board[1];
	yellowStart = board[2];
	blueStart = board[3];


	#Create the outside spaces (I'll make the Space class later btw)
	board[4] = new Space("outter");
	for( int index = 5; index < 72; index++ ){
	    board[index] = new Space("outter");
	    board[index].addPrev(board[index-1]);
	    board[index-1].addNext(board[index]);
	}
	board[71].addNext(board[4]);
	board[4].addPrev(board[71]);
	for( int quad = 0; quad < 4; quad++ ){
	   board[4 + 7 + 18*quad].makeSafe();
	   board[4 + 12 + 18*quad].makeSafe();
	}
	board[4].makeSafe("red");
	board[22].makeSafe("green");
	#18

 
    
    }

