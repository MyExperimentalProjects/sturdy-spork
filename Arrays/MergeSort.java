class MergeSort{

	public static String[] merge(String[] word_x, String[] word_y){
		if(word_x.length == 0 && word_y.length == 0){
			return word_x;
		}
		if(word_x.length == 0){
			return word_y;
		}
		if(word_y.length == 0){
			return word_x;
		}
		String[] merged = new String[word_x.length + word_y.length];
		int _counter = 0;
		int _x = 0;
		int _y = 0;
		while( _x < word_x.length  && _y < word_y.length){
			if(word_x[_x].compareTo(word_y[_y]) >= 0){
				merged[_counter] = word_y[_y];
				_y++;
			}else{
				merged[_counter] = word_x[_x];
				_x++;
			}
			_counter++;
		}
		while(_x < word_x.length){
			merged[_counter] = word_x[_x];
			_x++;
			_counter++;
		}
		while(_y < word_y.length){
			merged[_counter] = word_y[_y];
			_y++;
			_counter++;
		}
		return merged;
	}
	public static void main(String[] args){
		String[] A = {"good", "in" };
		String[] B = { "god", "is" };
		String[] C = merge(A,B);
		for(String s: C){
			System.out.println(s);
		}
	}
}