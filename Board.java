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
    
    //Class Variables
    Space[] board;

    Space[] board;    //Holds all spaces, including start/home.  Order: Starting>outter>Inner>Home, always in RGYB order.

    //Innit method.  Can you tell I'm rusty yet?  (still working in Vim)
    public void Board( ){

    	//Initialize BoardStoared (main array).
	this.board = new Space[101];
    	
	//Create the home areas
	board[0] = new Space("start");
	board[1] = new Space("start");
	board[2] = new Space("start");
	board[3] = new Space("start");


	//Create the outside spaces (I'll make the Space class later btw)
	board[4] = new Space("outter");
	for( int index = 5; index < 72; index++ ){
	    board[index] = new Space("outter");
	    board[index].addPrev(board[index-1]);
	    board[index-1].addNext(board[index]);
	}
	board[71].addNext(board[4]);
	board[4].addPrev(board[71]);

	//Make safe spaces
	for( int quad = 0; quad < 4; quad++ ){
	   board[4 + 7 + 18*quad].makeSafe();
	   board[4 + 12 + 18*quad].makeSafe();
	}
	board[4].makeSafe("red");
	board[21].makeSafe("green");
	board[38].makeSafe("yellow");
	board[55].makeSafe("blue");
	
	//Create the runway spaces.
	//Red
	Space prevSpace = board[67];
	for( int index = 72; index < 79; index++ ){
		board[index] = new Space("runway_red");
		board[index].addPrev(prevSpace);
		prevSpace.addNext(board[index]);
		prevSpace = board[index];
	}
	//Green
	Space prevSpace = board[16];
	for( int index = 80; index < 86; index++ ){
		board[index] = new Space("runway_green");
		board[index].addPrev(prevSpace);
		prevSpace.addNext(board[index]);
		prevSpace = board[index];
	}
	//Yellow
	Space prevSpace = board[33];
	for( int index = 86; index < 93; index++ ){
		board[index] = new Space("runway_yellow");
		board[index].addPrev(prevSpace);
		prevSpace.addNext(board[index]);
		prevSpace = board[index];
	}
	//Blue
	Space prevSpace = board[50];
	for( int index = 93; index < 100; index++ ){
		board[index] = new Space("runway_blue");
		board[index].addPrev(prevSpace);
		prevSpace.addNext(board[index]);
		prevSpace = board[index];
	}

	//Create Home & connections (home does not have previous since you can't go back from Home.
	board[100] = new Space("home");
	board[78].addNext(board[100]);
	board[85].addNext(board[100]);
	board[92].addNext(board[100]);
	board[99].addNext(board[100]);

 
    
    }

