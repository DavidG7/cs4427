package Client;




import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.Node;


import Factory.EnemyFactory;
import Observer.Enemy;
import Singleton.Player;

import Subject.Difficulty;
import Constants.Constants;
import UI.MenuUi;
import UI.Ui;




public class Client 
{

	
	static Enemy[] enemies;
	
    public static void main (String[] args) {
    	
    	//Create Subjects and set their Observers
    	Difficulty difficulty = new Difficulty();
        Player player = Player.getInstance();
       
        EnemyFactory monsterFactory = new EnemyFactory();
        Enemy[] monsters = monsterFactory.createEnemy(Constants.MONSTER, difficulty,player,1);
        Enemy[] zombies = monsterFactory.createEnemy(Constants.ZOMBIE, difficulty,player,1);
        
        Enemy[] enemies = concat(zombies,monsters);
     
        Ui userInterface = new MenuUi(difficulty, player, enemies);
        userInterface.draw();
    	
    	 // add elements to LinkedList
    	
    	/*int[] manDistance = neighbours(new int[]{2,2},new int[]{4,5});
    	System.out.println(manDistance);*/
		
	}

        
    	
    
    
    /*public static int[] neighbours(int[] player,int[] enemy){
    
        HashMap<String, int[]> neighbours = new HashMap<String, int[]>();
        neighbours.put("up", new int[]{enemy[0]+1,enemy[1]});
        neighbours.put("down", new int[]{enemy[0]-1,enemy[1]});
        neighbours.put("right", new int[]{enemy[0],enemy[1]+1});
        neighbours.put("left", new int[]{enemy[0],enemy[1]-1});
        
        int minimum = 100;
        int[] desiredPosition = null;
        
        Iterator it = neighbours.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            System.out.println(manhattanDistance(new int[]{player[0],player[1]},(int[])pairs.getValue()));
            int tempMinimum = manhattanDistance(new int[]{player[0],player[1]},(int[])pairs.getValue());
            
            if(tempMinimum < minimum){
            	minimum = tempMinimum;
            	desiredPosition = (int[]) pairs.getValue();
            }
        }
        System.out.println(desiredPosition[0]+ " " + desiredPosition[1]);
        
    	return desiredPosition;
    	
    }
    
    public static int manhattanDistance(int[] player,int[] enemy){
		int rowPosition = Math.abs(enemy[0]-player[0]);
		int colPosition = Math.abs(enemy[1]-player[1]);
		
		return colPosition+rowPosition;
    	
    	
    }*/
    public static Enemy[] concat(Enemy[] A, Enemy[] B) {
    	   int aLen = A.length;
    	   int bLen = B.length;
    	   Enemy[] enemies= new Enemy[aLen+bLen];
    	   System.arraycopy(A, 0, enemies, 0, aLen);
    	   System.arraycopy(B, 0, enemies, aLen, bLen);
    	   return enemies;
    	}
    
   
}



