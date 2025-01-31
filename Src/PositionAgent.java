//package agent;

import java.io.Serializable;

public class PositionAgent implements Serializable {

	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private int dir;

	//constructeurs
	public PositionAgent(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public PositionAgent(int x, int y, int dir) {
		this.x = x;
		this.y = y;
	    this.dir = dir;
	}

	

	//getters & setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
	    return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(PositionAgent other) {
		return (x == other.getX()) && (y == other.getY());
	}

	public int distanceWith(PositionAgent other){
		return Math.abs((x-other.getX())+(y-other.getY()));
	}

}