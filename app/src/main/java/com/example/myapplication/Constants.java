package com.example.myapplication;

/**
 * @author jm
 * enum constants and other constants for server
 */
public class Constants {
	// TODO Category survey required.
	// waitingQueue level
	public final static int TOP = 0;
	public final static int CATEGORY = 1;
	public final static int BRAND = 2;
	public final static int MENU = 3;
	
	// user state
	public final static int NONE 			= 0;	// order & delivery also use this 
	public final static int WAIT_MATCHING 	= 1;
	public final static int TALKING 		= 2;
	public final static int WAIT_SELECT 	= 3;
	public final static int WAIT_PAY 		= 4;
	public final static int WAIT_DELIVERY 	= 5;  

	// order & delivery man state
	public final static int WAITING 	= 1;
	public final static int DELIVERYING = 2;
	public final static int COMPLETE 	= 3;

	public static enum Category {
		/* BUNSIC, */ 치킨(0), 피자(1); /*, CHAINESE, JOCBO, NIGHT, FAST, DOSIRAC;*/
		public int value;
		
		Category(int value){
			this.value = value;
		}
	}

	/*
	static enum BUNSIC {
		
	}
	 */
	
	public static enum CHICKEN {
		BBQ(0), 네네(1);
		public int value;
		
		CHICKEN(int value){
			this.value = value;
		}
	}

	public static enum PIZZA {
		네오피자(0), 피자빙고(1);
		public int value;
		
		PIZZA(int value){
			this.value = value;
		}
	}
	
	public static enum BBQ {
		황금올리브치킨(0, 16000), 시크릿양념치킨 (1, 17000);
		public int value;
		public int price;
		
		BBQ(int value, int price){
			this.value = value;
			this.price = price;
		}
	}

	public static enum NENE {
		양념(0, 16000), 힛블링(1, 18000);
		public int value;
		public int price;
		
		NENE(int value, int price){
			this.value = value;
			this.price = price;
		}
	}

	public static enum NEOPIZZA {
		불고기피자(0, 13000), 치즈바이트피자(1, 18000);
		public int value;
		public int price;
		
		NEOPIZZA(int value, int price){
			this.value = value;
			this.price = price;
		}
	}
	
	public static enum PIZZABINGO {
		고구마피자 (0, 10000), 페파로니피자 (1, 8000);
		public int value;
		public int price;
		
		PIZZABINGO(int value, int price){
			this.value = value;
			this.price = price;
		}
	}
}
