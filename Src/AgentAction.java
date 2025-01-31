//package agent;

public class AgentAction {
	// Vecteur de déplacement qui sera utile pour réaliser l'action dans le jeu
	private int _vx;
	private int _vy;

	// enumeration des directions possibles
	public final static int NORTH = 0;
	public final static int SOUTH = 1;
	public final static int EAST = 2;
	public final static int WEST = 3;
	/*public final static int STOP = 4;*/

	// Direction
	private int _direction;

	public AgentAction(int d) {

		_direction = d;

		// Calcule le vecteur de déplacement associé

		switch (_direction) {
			case NORTH:
				_vx = 0;
				_vy = -1;
				break;
			case SOUTH:
				_vx = 0;
				_vy = 1;
				break;
			case EAST:
				_vx = 1;
				_vy = 0;
				break;
			case WEST:
				_vx = -1;
				_vy = 0;
				break;
			/*case STOP:
				_vx = 0;
				_vy = 0;
				break;*/
			default:
				_vx = 0;
				_vy = 0;
				break;
		}
	}

	// getter & setter du vecteur de déplacement du l'axe X
	public int get_vx() {
		return _vx;
	}

	public void set_vx(int _vx) {
		this._vx = _vx;
	}

	// getter & setter du vecteur de déplacement du l'axe Y
	public int get_vy() {
		return _vy;
	}

	public void set_vy(int _vy) {
		this._vy = _vy;
	}

	//getter & setter de la direction
	public int get_direction() {
		return _direction;
	}

	public void set_direction(int _direction) {
		this._direction = _direction;
	}
}