class Distance{
	public static int min_distance(String[] words, String word1, String word2){
		int minDistance = Integer.MAX_VALUE;
		int index1 = -1 , index2 = -1;
		for(int i = 0 ; i < words.length ; ++i){
			if(words[i].equals(word1)){
				index1 = i;
			}
			if(words[i].equals(word2)){
				index2 = i;
			}
			if(index1 != -1 && index2 != -1){
				int distance = Math.abs(index2-index1);
				if(distance < minDistance){
					minDistance = distance;
				}
			}
		}
		if(minDistance == Integer.MAX_VALUE){
			return -1;
		}
		return minDistance;
	}
	public static void main(String[] args){
		String[] words = {"the", "quick", "brown", "fox", "quick"};
		System.out.println(min_distance(words,"the","q"));
	}
}