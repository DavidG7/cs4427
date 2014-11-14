package State;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.security.sasl.SaslException;
import Constants.Constants;
import Memento.CareTaker;
import Memento.EnemyCareTaker;
import Observer.Enemy;
import Singleton.Player;

public class HardMoveState implements State {

	private Player player;
	private CareTaker careTaker = new CareTaker();
	@Override
	public void move(Enemy enemy) {
		// TODO Auto-generated method stub
		player = enemy.player;
	  
		System.out.println(Constants.ENEMEY_MOVES);
		
		if(player.isMovedBackOrForward().equals("FORWARD")){
		careTaker.add(enemy.saveStateToMemento());
		enemy.setEnemyCoordinates(aStar(player.getPreviousPosition()[0],player.getPreviousPosition()[1],enemy.getEnemyRowPosition(),
				enemy.getEnemyColPosition()));
		}else if(player.isMovedBackOrForward().equals("BACK")) {
	    enemy.getStateFromMemento(careTaker.get(careTaker.getNumberOfMoves()-1));
	    careTaker.remove(careTaker.get(careTaker.getNumberOfMoves()-1));
		}

		
	}
	
	
	public int[] aStar(int playerRow,int playerCol,int enemyRow, int enemyCol){
	    
        HashMap<String, int[]> neighbours = new HashMap<String, int[]>();
        neighbours.put("up", new int[]{enemyRow+1,enemyCol});
        neighbours.put("down", new int[]{enemyRow-1,enemyCol});
        neighbours.put("right", new int[]{enemyRow,enemyCol+1});
        neighbours.put("left", new int[]{enemyRow,enemyCol-1});
        
        int minimum = 100;
        int[] desiredPosition = null;
        
        Iterator it = neighbours.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            System.out.println(manhattanDistance(new int[]{playerRow,playerCol},(int[])pairs.getValue()));
            int tempMinimum = manhattanDistance(new int[]{playerRow,playerCol},(int[])pairs.getValue());
            
            if(tempMinimum < minimum){
            	minimum = tempMinimum;
            	desiredPosition = (int[]) pairs.getValue();
            }
        }
        System.out.println(desiredPosition[0]+ " " + desiredPosition[1]);
        
    	return desiredPosition;
		
    	
    }
    
    public int manhattanDistance(int[] player,int[] enemy){
		int rowPosition = Math.abs(enemy[0]-player[0]);
		int colPosition = Math.abs(enemy[1]-player[1]);
		
		return colPosition+rowPosition;
    }
}
