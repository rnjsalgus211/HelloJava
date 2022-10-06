package co.edu.except;

public class RectPrint {
	public static void main(String[] args) {
//		int cnt = 1;
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//					System.out.printf("%3d", cnt= i+1+j*5);
//			}
//			System.out.println();
//		}

		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 * i - 1; j++) {
				if (j % 5 == 0) {
					System.out.printf("%3d", cnt++);
				}
			}
			System.out.println();
		}
		System.out.println();

		int cnt2 = 1;
		for (int i = 0; i < 5; i++) {
			for(int k=4; k>i; k--) {
				System.out.printf("%3s", "");
			}		
			for (int j = 0; j < 5 * i - 1; j++) {
				if (j % 5 == 0) {
					System.out.printf("%3d", cnt2++);
				}
			}
			System.out.println();
		}
	}
}
