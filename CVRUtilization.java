
public class CVRUtilization {

	public static void main(String[] args) {
		System.out.println("Creating 10 objects");
		CVR cvr1 = new CVR (100);
		CVR cvr2 = new CVR (150);
		CVR cvr3 = new CVR (200);
		CVR cvr4 = new CVR (4000);
		CVR cvr5 = new CVR (312313213);
		CVR cvr6 = new CVR (10);
		CVR cvr7 = new CVR (29);
		CVR cvr8 = new CVR (35000);
		CVR cvr9 = new CVR (28500);
		CVR cvr10 = new CVR (50);
		
		System.out.println();
		System.out.println("Setting key lengths");
		cvr1.setKeyLength(12);
		cvr2.setKeyLength(17);
		// cvr3 bot usable
		cvr3.setKeyLength(18);
		// cvr4 not usable
		cvr4.setKeyLength(9);
		// cvr5 not usable
		cvr5.setKeyLength(25);
		cvr6.setKeyLength(13);
		cvr7.setKeyLength(16);
		// cvr8 not usable
		cvr8.setKeyLength(-5);
		cvr9.setKeyLength(15);
		cvr10.setKeyLength(16);
		
		System.out.println();
		System.out.println("Setting thresholds");
		cvr1.setThreshold(100);
		cvr2.setThreshold(160);
		// cvr6 not usable
		cvr6.setThreshold(50);
		cvr7.setThreshold(9000);
		// cvr9 not usable
		cvr9.setThreshold(900001);
		cvr10.setThreshold(5000);
		
		System.out.println();
		System.out.println("Testing methods for a hashtable-based object");
		SeqList <String> generator1 = new SeqList<String>();
		generator1 = cvr1.generate(50);
		cvr1.addKey("ABCDEFHIJKL12", "1");
		System.out.println(cvr1.getValues("ABCDEFHIJKL12"));
		cvr1.addKey("123456789012", "2");
		cvr1.addKey("ADADADADADAD", "3");
		cvr1.allKeys();
		System.out.println(cvr1.getValues("ADADADADADAD"));
		System.out.println(cvr1.prevKey("123456789012"));
		System.out.println(cvr1.nextKey("123456789012"));
		cvr1.remove("123456789012");
		cvr1.allKeys();
		
		System.out.println();
		System.out.println("Testing methods for a sequence-based object");
		SeqList <String> generator2 = new SeqList<String>();
		generator2 = cvr7.generate(20);
		cvr7.addKey("ASDFFGHJKLQWERTYUI", "1");
		System.out.println(cvr7.getValues("ASDFFGHJKLQWERTYUI"));
		cvr7.addKey("ZXCVBNMASDFGHJKLQ", "2");
		cvr7.addKey("12345678901234567", "3");
		cvr7.allKeys();
		System.out.println(cvr7.getValues("12345678901234567"));
		System.out.println(cvr7.prevKey("ZXCVBNMASDFGHJKLQ"));
		System.out.println(cvr7.nextKey("ZXCVBNMASDFGHJKLQ"));
		cvr7.remove("12345678901234567");
		cvr7.allKeys();
		
		System.out.println();
		System.out.println("Adding generated elements to an object");
		SeqList <String> generator3 = new SeqList <String> ();
		generator3 = cvr10.generate(30);
		for (int i = 0; i <30; i++) {
			cvr10.addKey(generator3.atIndex(i), String.valueOf(i));
		}
		cvr10.allKeys();
		
		
	}

}
