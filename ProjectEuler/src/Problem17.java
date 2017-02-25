public class Problem17 {
	public static void main(String[]args){
		System.out.println("the sum is " + sum(1));
	}
	public static int sum(int i){
		if(i == 1000) 
			return wordCount(i);
		return wordCount(i) + sum(i+1);
	}
	//return length of word count for this number
	public static int wordCount(int num){
		if(num == 10){
			//ten
			return 3;
		}
		if(num == 100){
			//one hundred
			return 3+7;
		}
		if(num == 1000){
			//one thousand
			return 3+8;
		}
		else if(num < 10){
			if(num == 1){
				//one
				return 3;
			}
			if(num == 2){
				//two
				return 3;
			}
			if(num == 3){
				//three
				return 5;
			}
			if(num == 4){
				//four
				return 4;
			}
			if(num == 5){
				//five
				return 4;
			}
			if(num == 6){
				//six
				return 3;
			}
			if(num == 7){
				//seven
				return 5;
			}
			if(num == 8){
				//eight
				return 5;
			}
			if(num == 9){
				//nine
				return 4;
			}
		}
		else if(num < 20){
			if(num == 11){
				//eleven
				return 6;
			}
			if(num == 12){
				//twelve
				return 6;
			}
			if(num == 13){
				//thirteen
				return 8;
			}
			if(num == 14){
				//fourteen
				return 8;
			}
			if(num == 15){
				//fifteen
				return 7;
			}
			if(num == 16){
				//sixteen
				return 7;
			}
			if(num == 17){
				//seventeen
				return 9;
			}
			if(num == 18){
				//eighteen
				return 8;
			}
			if(num == 19){
				//nineteen
				return 8;
			}
		}
		else if(num < 100){
			int digit = num%10;
			int first = num/10;
			int sum = wordCount(digit);
			if(first == 2){
				//twenty
				sum += 6;
			}
			if(first == 3){
				//thirty
				sum += 6;
			}
			if(first == 4){
				//forty
				sum += 5;
			}
			if(first == 5){
				//fifty
				sum += 5;
			}
			if(first == 6){
				//sixty
				sum += 5;
			}
			if(first == 7){
				//seventy
				sum += 7;
			}
			if(first == 8){
				//eighty
				sum += 6;
			}
			if(first == 9){
				//ninety
				sum += 6;
			}
			return sum;
		}
		else if(num < 1000){
			int end = num%100;
			int start = num/100;
			//start hundred and end
			return wordCount(end) + 7+ 3 + wordCount(start);
		}
		return 0;
	}
}
