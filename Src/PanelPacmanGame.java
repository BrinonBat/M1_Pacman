//package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

//import agent.PositionAgent;

//import motor.Maze;

public class PanelPacmanGame extends JPanel {

	private static PanelPacmanGame firstInstance = null; // indicateur d'instance servant au pattern Singleton

	private static final long serialVersionUID = 1L;

	private Color wallColor = Color.BLUE;
	private Color wallColor2 = Color.CYAN;

	private double sizePacman = 1.1;
	private Color pacmansColor = Color.yellow;

	private ArrayList<Color> ghostsColor = new ArrayList<Color>(Arrays.asList(
		new Color(51,153,255),
		new Color(255,204,51),
		new Color(255,102,0),
		new Color(204,0,0)
	));
	private Color ghostScarredColor = new Color(0,0,204);


	private double sizeFood = 0.3;
	private Color colorFood = Color.white;

	private double sizeCapsule = 0.7;
	private Color colorCapsule = Color.red;

	private boolean ghostsScarred=false;

	private static int sa = 0;
	private static int fa = 0;

	private Maze m;

	private ArrayList<PositionAgent> pacmans_pos;
	private ArrayList<PositionAgent> ghosts_pos;

	//getInstance appliquant le pattern Singleton
	public static synchronized PanelPacmanGame getInstance(){
		//on n'instancie l'objet que s'il n'y a pas déjà une instance de celui-ci en cours
		if(firstInstance==null){
			firstInstance=new PanelPacmanGame();
		}
		return firstInstance;
	}

	///singleton donc constructeur bloqué
	private PanelPacmanGame() {}

	public void paint(Graphics g) {

		int dx = firstInstance.getSize().width;
		int dy = firstInstance.getSize().height;
		g.setColor(Color.black);
		g.fillRect(0, 0, dx, dy);

		int sx = firstInstance.m.getSizeX();
		int sy = firstInstance.m.getSizeY();
		double stepx = dx / (double) sx;
		double stepy = dy / (double) sy;
		double posx = 0;

		// affiche le terrain "case par case"
		for (int x = 0; x < sx; x++) {
			double posy = 0;
			for (int y = 0; y < sy; y++) {
				if (firstInstance.m.isWall(x, y)) {
					g.setColor(firstInstance.wallColor2);
					g.fillRect((int) posx, (int) posy, (int) (stepx + 1), (int) (stepy + 1));
					g.setColor(firstInstance.wallColor);
					double nsx = stepx * 0.5;
					double nsy = stepy * 0.5;
					double npx = (stepx - nsx) / 2.0;
					double npy = (stepy - nsy) / 2.0;
					g.fillRect((int) (npx + posx), (int) (npy + posy), (int) (nsx), (int) nsy);
				}
				if (firstInstance.m.isFood(x, y)) {
					g.setColor(firstInstance.colorFood);
					double nsx = stepx * firstInstance.sizeFood;
					double nsy = stepy * firstInstance.sizeFood;
					double npx = (stepx - nsx) / 2.0;
					double npy = (stepy - nsy) / 2.0;
					g.fillOval((int) (npx + posx), (int) (npy + posy), (int) (nsx), (int) nsy);
				}
				if (firstInstance.m.isCapsule(x, y)) {
					g.setColor(firstInstance.colorCapsule);
					double nsx = stepx * firstInstance.sizeCapsule;
					double nsy = stepy * firstInstance.sizeCapsule;
					double npx = (stepx - nsx) / 2.0;
					double npy = (stepy - nsy) / 2.0;
					g.fillOval((int) (npx + posx), (int) (npy + posy), (int) (nsx), (int) nsy);
				}
				posy += stepy;
			}
			posx += stepx;
		}

		for (int i = 0; i < firstInstance.pacmans_pos.size(); i++) {
			PositionAgent pos = firstInstance.pacmans_pos.get(i);
			drawPacmans(g, pos.getX(), pos.getY(), pos.getDir(), firstInstance.pacmansColor);
		}

		int j = 0;
		for (int i = 0; i < firstInstance.ghosts_pos.size(); i++) {
			PositionAgent pos = firstInstance.ghosts_pos.get(i);
			if (firstInstance.ghostsScarred) {
				drawGhosts(g, pos.getX(), pos.getY(), firstInstance.ghostScarredColor);
			} else {
				if(j > firstInstance.ghostsColor.size() - 1) j=0;
				drawGhosts(g, pos.getX(), pos.getY(), firstInstance.ghostsColor.get(j));
				j++;
			}
		}
	}

	void drawPacmans(Graphics g, int px, int py, int pacmanDirection, Color color) {

		// si pacman est en vie
		if ((px != -1) || (py != -1)) {

			int dx = firstInstance.getSize().width;
			int dy = firstInstance.getSize().height;

			int sx = firstInstance.m.getSizeX();
			int sy = firstInstance.m.getSizeY();
			double stepx = dx / (double) sx;
			double stepy = dy / (double) sy;

			double posx = px * stepx;
			double posy = py * stepy;

			g.setColor(color);
			double nsx = stepx * firstInstance.sizePacman;
			double nsy = stepy * firstInstance.sizePacman;
			double npx = (stepx - nsx) / 2.0;
			double npy = (stepy - nsy) / 2.0;

			if (pacmanDirection == Maze.NORTH) {
				PanelPacmanGame.sa = 70;
				PanelPacmanGame.fa = -320;
			}
			if (pacmanDirection == Maze.SOUTH) {
				PanelPacmanGame.sa = 250;
				PanelPacmanGame.fa = -320;
			}
			if (pacmanDirection == Maze.EAST) {
				PanelPacmanGame.sa = 340;
				PanelPacmanGame.fa = -320;
			}
			if (pacmanDirection == Maze.WEST) {
				PanelPacmanGame.sa = 160;
				PanelPacmanGame.fa = -320;
			}

			g.fillArc((int) (npx + posx), (int) (npy + posy), (int) (nsx), (int) nsy, PanelPacmanGame.sa, PanelPacmanGame.fa);
		}

	}

	void drawGhosts(Graphics g, int px, int py, Color color) {

		if ((px != -1) || (py != -1)) {
			int dx = firstInstance.getSize().width;
			int dy = firstInstance.getSize().height;

			int sx = firstInstance.m.getSizeX();
			int sy = firstInstance.m.getSizeY();
			double stepx = dx / (double) sx;
			double stepy = dy / (double) sy;

			double posx = px * stepx;
			double posy = py * stepy;

			g.setColor(color);

			double nsx = stepx * firstInstance.sizePacman;
			double nsy = stepy * firstInstance.sizePacman;
			double npx = (stepx - nsx) / 2.0;
			double npy = (stepy - nsy) / 2.0;

			g.fillArc((int) (posx + npx), (int) (npy + posy), (int) (nsx), (int) (nsy), 0, 180);
			g.fillRect((int) (posx + npx), (int) (npy + posy + nsy / 2.0 - 1), (int) (nsx), (int) (nsy * 0.666));
			g.setColor(Color.BLACK);
			g.fillOval((int) (posx + npx + nsx / 5.0), (int) (npy + posy + nsy / 3.0), 4, 4);
			g.fillOval((int) (posx + npx + 3 * nsx / 5.0), (int) (npy + posy + nsy / 3.0), 4, 4);

			g.setColor(Color.black);
		}

	}

	//getters & setters
	public Maze getMaze() {
		return firstInstance.m;
	}
	public void setMaze(Maze maze) {
		firstInstance.m = maze;
		firstInstance.pacmans_pos =firstInstance.m.getPacman_start();
		firstInstance.ghosts_pos =firstInstance.m.getGhosts_start();
	}
	public void setGhostsScarred(boolean ghostsScarred) {
		firstInstance.ghostsScarred = ghostsScarred;
	}
	public ArrayList<PositionAgent> getPacmans_pos() {
		return firstInstance.pacmans_pos;
	}
	public void setPacmans_pos(ArrayList<PositionAgent> pacmans_pos) {
		firstInstance.pacmans_pos = pacmans_pos;
	}
	public ArrayList<PositionAgent> getGhosts_pos() {
		return firstInstance.ghosts_pos;
	}
	public void setGhosts_pos(ArrayList<PositionAgent> ghosts_pos) {
		firstInstance.ghosts_pos = ghosts_pos;
	}

}
