import java.util.*;

public class CVR {
	class InnerVehicle {
		String report;
		String key;
		// inner class for vehicle reports
		public InnerVehicle(String key, String report) {
			this.key=key;
			this.report=report;
		}
		public String getKey() {
			return key;
		}
		public String getReport() {
			return report;
		}
		public void setKey(String key) {
			this.key=key;
		}
		public void setReport(String report) {
			this.report=report;
		}
	}
	
	private static final String STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private int threshold;
	private int keyLength;
	private int maxKeys;
	private Hashtable hashList= new Hashtable();
	private SeqList SList= new SeqList();
	private ArrayList <String> keyStorer=new ArrayList();
	private ArrayList <InnerVehicle> dataStorer= new ArrayList();
	private String switcher;
	
	public CVR(int x) {
		maxKeys = x;
		keyStorer = new ArrayList();
		dataStorer = new ArrayList();
		SeqList SList = new SeqList();
		Hashtable hashList = new Hashtable();
	}
	public void setThreshold(int threshold) {
		if (threshold >= 100 && threshold <= 900000)
			this.threshold=threshold;
		else {
			System.out.println("Entered threshold was not got. Threshold initialization has failed.");
		}
		if (this.threshold>=maxKeys) {
			switcher="NOTSEQUENCE";
			System.out.println("Using Hash Table for this object");
		}
		else {
			switcher="SEQUENCE";
			System.out.println("Using Sequence for this object");
		}
		
	}
	public void setKeyLength (int length) {
		if (length >= 10 && length <= 17) {
			keyLength = length;
			System.out.println("Key length has been set to "+keyLength);
		}
		else {
			System.out.println("Entered length was not good. Length initialization has failed.");
		}
	}
	public SeqList <String> generate(int n) {
		SeqList generation = new SeqList();
		Random generator= new Random();
		int random;
		String insertion="";
		for (int i=0;i<n;i++) {
			for (int j=0;j<keyLength; j++) {
				random=generator.nextInt(36);
				insertion=insertion+STRING.charAt(random);
			}
			if (!(keyStorer.contains(insertion))) {
				generation.addLast(insertion);
			}
			insertion="";
		}
		return generation;
	}
	public void allKeys() {
		ArrayList <String> temp = new ArrayList <String>();
		for (int i=0;i<keyStorer.size();i++) {
			temp.add(keyStorer.get(i));
		}
		Collections.sort(temp);
		for (String counter: temp) {
			System.out.println(counter);
		}
	}
	public void addKey(String key, String value) {
		InnerVehicle temp = new InnerVehicle(key, value);
		keyStorer.add(key);
		dataStorer.add(temp);
		if (switcher.equals("SEQUENCE")) {
			if (SList.isEmpty()) {
				for (int i = 0; i< keyStorer.size();i++) {
					SList.addLast(keyStorer.get(i));
				}
			}
			else {
				SList.addLast(key);
			}
			System.out.println("Added key to Sequence");
			hashList.clear();
		}
		else {
			if (!SList.isEmpty()) {
				for (int i = 0; i<keyStorer.size();i++) {
					hashList.put(keyStorer.get(i), dataStorer.get(i));
				}
				
			}
			else {
				hashList.put(key, temp);
			}
			while (!this.SList.isEmpty()) {
				SList=null;
				SList= new SeqList();
			}
			System.out.println("Added key to Hash Table");
		}
	}
	public void remove (String key) {
		if (keyStorer.contains(key)) {
			keyStorer.remove(key);
			for (int i = 0; i<dataStorer.size(); i++) {
				if (dataStorer.get(i).getKey().equalsIgnoreCase(key)) {
					dataStorer.remove(i);
					break;
				}
			}
		}
		else {
			System.out.println("Key does not exist");
		}
		if (switcher.equals("SEQUENCE")) {
			if (SList.isEmpty()) {
				for (int i = 0; i<keyStorer.size();i++) {
					SList.addLast(keyStorer.get(i));
				}
			}
			
			else {
				keyStorer.remove(key);
			}
			hashList.clear();
			System.out.println("The key has been removed from the sequence");
		}
			else {
				hashList.remove(key);
				if (!SList.isEmpty()) {
					SList.remove(key);
				for (int i = 0; i< keyStorer.size();i++ ) {
					hashList.put(keyStorer.get(i),dataStorer.get(i));
				}
			}
				System.out.println("The key has been removed from the hash table");
		
		}
	}
	
	public String getValues (String key) {
		String valueToReturn="";
		for (int i = 0 ; i<keyStorer.size(); i++) {
			if (dataStorer.get(i).getKey().equalsIgnoreCase(key)) {
				valueToReturn=dataStorer.get(i).getReport();
			}
		}
		return valueToReturn;
	}
	public String nextKey(String key) {
		String temp = "";
		if (keyStorer.contains(key)) {
			try {
				temp = keyStorer.get(keyStorer.indexOf(key)+1);
			}
			catch (Exception e) {
				System.out.println("No key found");
				return null;
			}
		}
		else {
			System.out.println("This key has not been found");
		}
		return temp;
	}
	public String prevKey(String key) {
		String temp = "";
		if (keyStorer.contains(key)) {
			try {
				temp = keyStorer.get(keyStorer.indexOf(key)-1);
			}
			catch (Exception e) {
				System.out.println("No key found");
				return null;
			}
		}
		else {
			System.out.println("This key has not been found");
		}
		return temp;
	}
	public String prevAccids(String key) {
		for (int i=0;i<dataStorer.size();i++) {
			if (dataStorer.get(i).getKey().equalsIgnoreCase(key)) {
				return dataStorer.get(i).getReport();
			}
		}
		return null;
	}
	
	
}
