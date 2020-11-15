// dice rolling game
import java.util.*;

class Player {
	String name;
	int loc = 0; // current location 
	int index;
	
	Player(String input, int i) {
		name = input;
		index = i;
	}
	
	void move() {
		// roll the dice
		Random rand = new Random();
		int result = rand.nextInt(6) + 1;
		
		// options: 1. roll 2. bonus roll 3. give up
		System.out.print("  [" + index + "번 플레이어 1.주사위 굴리기 2.찬스로 굴리기 0.포기]: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			loc += result;
			System.out.println("  " + index + "번 플레이어가 주사위를 굴렸습니다. " + result + " 이(가) 나왔습니다.");
			break;
		case 2:
			System.out.print("  " + index + "번 플레이어가 찬스로 주사위를 굴렸습니다. " + result + " 이(가) 나왔습니다. ");
			if (result == 6) {
				loc += 12;
				System.out.print("12칸 전진\n");
			}
			else {
				loc -= result; // going backwards; the location can be below zero
				System.out.print(result + "칸 후진\n");
			}
			break;
		case 0: break;
		default: move(); // in case of a wrong input
		}
	}
}

class Game {
	private Player[] players = new Player[5]; // max of 5 players
	private int num; // number of players
	private int goal; // location goal
	
	// game initialization
	void init() {
		System.out.println("*** 주사위 전진 게임 ***");
		Scanner input = new Scanner(System.in);
		
		System.out.print("플레이할 사용자 수: ");
		num = input.nextInt();
		
		for (int i = 0; i < num; i++) {
			System.out.print(i + "번 플레이어 이름: ");
			String name = input.next();
			players[i] = new Player(name, i);
		}
		
		System.out.print("목표 위치: ");
		goal = input.nextInt();
		
		System.out.println();
	}
	
	void loop() {
		int i = 1; // game round index
		
		while (true) {
			// print current locations of players
			System.out.print(i + "라운드 (위치: " );
			System.out.print(players[0].index + "번(" + players[0].name + ")=" + players[0].loc);
			for (int j = 1; j < num; j++) {
				System.out.print(", " + players[j].index + "번(" + players[j].name + ")=" + players[j].loc);
			}
			System.out.println(")");
			
			if (win() == true) {
				// print everyone who has passed the goal
				for (int j = 0; j < num; j++) {
					if (players[j].loc >= goal)
						System.out.println(players[j].index + "번 (" + players[j].name + ") 플레이어가 승리하였습니다.");
				}
				break;
			}
			
			for (int j = 0; j < num; j++) players[j].move();
			
			i++;
			System.out.println();
		}
	}
	
	boolean win() {
		// search for winners
		for (int i = 0; i < num; i++) {
			if (players[i].loc >= goal) {
				System.out.println("게임이 끝났습니다.");
				return true;
			}
		}
		return false;
	}
}

public class P320170154 {

	public static void main(String[] args) {
		Game rollTheDice = new Game();
		rollTheDice.init();
		rollTheDice.loop();
	}

}
