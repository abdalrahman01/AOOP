package TestingSokobon.views;

import sokobon.views.GameMap;

public class TestingGameMap {
	private static final char X = 'x';
	private static final char P = 'p';
	private static final char O = 'o';

	private static char[][] map = new char[][] { { X, X, X, X, X, X, X, X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, X, X, X, X, X, X, X } };

	public static void main(String[] args) {
		GameMap gMap = new GameMap(map);
		gMap.addPlayer(2, 3);
		gMap.addMovingBox(3, 3);
//		System.out.println(gMap);
		gMap.movePlayerDown();
		//		System.out.println(gMap);
		gMap.movePlayerleft();
		//		System.out.println(gMap);
		gMap.movePlayerDown();
		//		System.out.println(gMap);
		gMap.movePlayerRight();
		//		System.out.println(gMap);
		gMap.movePlayerRight();
		//		System.out.println(gMap);
		gMap.movePlayerRight();
		//		System.out.println(gMap);
		gMap.movePlayerDown();
		//	System.out.println(gMap);
		gMap.movePlayerRight();
		//	System.out.println(gMap);
		gMap.movePlayerUp();
		//	System.out.println(gMap);
		gMap.movePlayerUp();
		//	System.out.println(gMap);
		gMap.movePlayerUp();
		//	System.out.println(gMap);
		gMap.pullBoxDown();
		//	System.out.println(gMap);
		gMap.movePlayerleft();
//        System.out.println(gMap);
        gMap.movePlayerUp();
//       System.out.println(gMap);
        gMap.pullBoxLeft();
//       System.out.println(gMap);
        gMap.movePlayerUp();
 //       System.out.println(gMap);
        gMap.movePlayerRight();
//        System.out.println(gMap);
        gMap.movePlayerDown();
//       System.out.println(gMap);
       gMap.pullBoxUp();
       System.out.println(gMap);
       gMap.movePlayerRight();
//     System.out.println(gMap);
       gMap.movePlayerDown();
     System.out.println(gMap);
     gMap.movePlayerleft();
   System.out.println(gMap);
   gMap.pullBoxRight();
   System.out.println(gMap);
   gMap.pullBoxRight();
   System.out.println(gMap);
   
     





		
		

		
		
	

	}
}
