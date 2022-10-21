package co.gui.dao;

public class Random {
	public static void main(String[] args) {
		String[] random =  new String[]{"권", "김", "백", "박", "이", "서", "주"};
		
			int[] a = new int[8];
			
		for(int i=0; i<a.length; i++) {
			a[i] = (int)(Math.random()*10);
			
			for(int j=0; j<i; i++ ) {
				if(a[i]==a[j]) {
				i--;
				break;
				}
			}	
			
		}
		for (int i=0; i<random.length; i++) {
			System.out.println(random[i]+" ");
		}
		
	}
	
}
