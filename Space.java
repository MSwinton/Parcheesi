/*  Space.java
Space Object, used mostly in Board but I decided to have it be its own class rather than a subclass just in case.

Matt Swinton
Started 10/4/2015
*/

class Space{

    public String type;
    public boolean isSafe;
    public int capacity;
    public int color;
    public ArrayList<Space> prevSpaces;
    public ArrayList<Space> nextSpaces;

    public Space( String type ){
    	#Initialize/Set class variables.
	prevSpaces = new Arraylist<Space>();
	nextSpaces = new Arraylist<Space>();
	this.type = type;
	if( type == "start" ) capacity = 4;
	elif( type == "home" ) capacity = 100;
	else capacity = 2;
	isSafe = false;

    }
    public Space( ){
        Space("");
    }


    #Sets this space as safe.
    public void makeSafe( ){
	isSafe = true;
    }
    #Overload:  If a string is added for color, also sets the color of the space.
    public void makeSafe( String color ){
	isSafe = true;
	this.color = color;
    }

    #Adds a next space to the next array.
    public addNext( Space spacebo ){
	nextSpaces.add(spacebo);
    }
    #Same but with prev
    public addPrev( Space spacebo ){
    	prevSpaces.add(spacebo);
    }


}
