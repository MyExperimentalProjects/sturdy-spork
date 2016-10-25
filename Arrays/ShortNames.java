class ShortNames{
	String[] names;
	Set<String> shortNames;

	ShortNames(){
		names = {};
		shortNames = new HashSet<>();
	}

	public convert(){
		for(String s:names){
			String[] name = s.split(" ");
			String fname = name[0];
			String lname = name[1];
			String shortName1 = fname + " " + lname.charAt(0);
			String fullName = s;
			if(shortNames.containsKey(fname)){
				if(shortNames.containsKey(shortName1)){
					
				}
			}
		}
	}
}