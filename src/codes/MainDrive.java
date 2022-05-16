package codes;

import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int[] myNumbers = new int[6];

		for (int i = 0; i < 6; i++) {

			while (true) {
				System.out.print((i + 1) + "번째 숫자 : ");
				int inputNum = myScanner.nextInt();

				boolean isRangOk = 1 <= inputNum && inputNum <= 45;

				boolean isRepeat = false;

				for (int num : myNumbers) {
					if (num == inputNum) {
						isRepeat = true;
					}
				}

				if (isRangOk && !isRepeat) {
					myNumbers[i] = inputNum;
					break;
				}

			}

		}

		int[] winNumbers = new int[6];

		// 임시로 로직 확인 용 하드코딩
		winNumbers[0] = 10;
		winNumbers[1] = 11;
		winNumbers[2] = 20;
		winNumbers[3] = 21;
		winNumbers[4] = 30;
		winNumbers[5] = 40;

		// 당첨번호 랜덤으로 작성

		// 몇등인지 맞추는 로직

		// 당첨번호 확인

		int correctCount = 0;

		for (int myNum : myNumbers) {
			for (int winNum : winNumbers) {
				if (myNum == winNum) {
					correctCount++;
				}
			}
		}

		// 보너스 번호 뽑기
		int bonusNum = 0;
		while (true) {
			// Math.random() -> Double 0...1
			int randomNum = (int) (Math.random() * 45 + 1);

			boolean isRangOk = (1 <= randomNum && randomNum <= 45);

			boolean isRepeat = false;

			for (int num : winNumbers) {
				if (num == randomNum) {
					isRepeat = true;
				}
			}

			if (!isRangOk && !isRepeat) {
				bonusNum = randomNum;
				break;
			}
		}

		// 당첨등수 확인
		if (correctCount == 6) {
			System.out.println("1등 축");
		} else if (correctCount == 5) {
			// 보너스 번호와의 동일여부 -> 2/3등구분 처리
			System.out.println("2등 ");

			System.out.println("3등 ");
		} else if (correctCount == 4) {
			System.out.println("4등 ");
		} else if (correctCount == 3) {
			System.out.println("5등 ");
		} else {
			System.out.println("탈락");
		}

		// 당첨둥수 확인 (switch문 활용)
//		switch (correctCount) {
//		case 6:
//			System.out.println("1등 축");
//			break;
//		case 5:
//			System.out.println("3등 축");
//			break;
//		case 4:
//			System.out.println("4등 축");
//			break;
//		case 3:
//			System.out.println("5등 축");
//			break;
//		default:
//			System.out.println("꽝!");
//			break;
//		}

	}

}
