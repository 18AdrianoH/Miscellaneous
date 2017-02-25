package utilities;
//@author Adriano Hernandez

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@version Basic 1.0 (Basic Calculations)
//@date 16 June 2016

//a big integer class for when integers get too big for UInt64s (longs)

//this has minimal safety measures taken for when you pass a non numerical string
//therefore exercise caution when utilizing this utility class

public class BigInteger {
	// value is stored as a string
	private String value;

	// constructures
	public BigInteger() {
		setValue(0);
	}

	public BigInteger(String value) {
		setValue(value);
	}

	public BigInteger(BigInteger value) {
		setValue(value);
	}

	public BigInteger(int value) {
		setValue(value);
	}

	public BigInteger(long value) {
		setValue(value);
	}

	// adds two big Integers or two ints or two longs or one of each of
	//any combination - ease of use for later
	public static BigInteger add(BigInteger a, int b) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(BigInteger a, long b) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(int b, BigInteger a) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(long b, BigInteger a) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(int a, int b) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(long a, long b) {
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(int a, long b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(long b, int a){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(BigInteger a, String b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(String a, BigInteger b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(int a, String b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(String a, int b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(long a, String b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(String a, long b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger add(String a, String b){
		return add(new BigInteger(a), new BigInteger(b));
	}
	
	//add two big integers
	public static BigInteger add(BigInteger a1, BigInteger b1) {
		//create variables
		List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), 
				sum = new ArrayList<>();
		
		for(int i = 0; i < a1.toString().length(); i++){
			a.add(Integer.parseInt(a1.toString().substring(i, i+1)));
		}
		for(int i = 0; i < b1.toString().length(); i++){
			b.add(Integer.parseInt(b1.toString().substring(i, i+1)));
		}
		//calculate
		int sizeA = a.size(), sizeB = b.size();
		//this works
		if(sizeA == sizeB){
			int remainder = 0;
			for(int i = a.size()-1; i >= 0; i --){
				sum.add((a.get(i)+b.get(i)+remainder)%10);
				remainder = (a.get(i)+b.get(i)+remainder)/10;
			}
			if(remainder != 0){
				while(remainder > 0){
					sum.add(remainder%10);
					remainder /= 10;
				}
			}
		}
		
		else if(sizeA > sizeB){
			int remainder = 0;
			int aIndex = a.size()-1;
			for(int i = b.size()-1; i >= 0; i --){
				sum.add((a.get(aIndex)+b.get(i)+remainder)%10);
				remainder = (a.get(aIndex)+b.get(i)+remainder)/10;
				aIndex--;
			}
			for(;aIndex >= 0; aIndex--){
				sum.add((remainder + a.get(aIndex))%10);
				remainder = (a.get(aIndex)+remainder)/10;
			}
			if(remainder != 0){
				while(remainder > 0){
					sum.add(remainder%10);
					remainder /= 10;
				}
			}
		}
		else{
			int remainder = 0;
			int bIndex = b.size()-1;
			for(int i = a.size()-1; i >= 0; i --){
				sum.add((b.get(bIndex)+a.get(i)+remainder)%10);
				remainder = (b.get(bIndex)+a.get(i)+remainder)/10;
				bIndex--;
			}
			for(;bIndex >= 0; bIndex--){
				sum.add((remainder + b.get(bIndex))%10);
				remainder = (b.get(bIndex)+remainder)/10;
			}
			if(remainder != 0){
				while(remainder > 0){
					sum.add(remainder%10);
					remainder /= 10;
				}
			}
		}
		//return
		String summation = "";
		for(int i = sum.size()-1; i >= 0; i --){
			summation += String.valueOf(sum.get(i));
		}
		return new BigInteger(summation);
	}

	//multiple a times b
	//THIS DOESN'T WORK RIGHT NOW
	public static BigInteger multiply(BigInteger a, int b){
		if(b == 0) return new BigInteger(0);
		BigInteger sum = new BigInteger(a);
		while(b > 1){
			sum = BigInteger.add(sum, a);
			b--;
		}
		return sum;
	}
	/*
	public static BigInteger multiply(int a, BigInteger b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(long a, BigInteger b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(BigInteger b, int a){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(BigInteger b, long a){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	//string methods are not parse safe.  warning.
	public static BigInteger multiply(BigInteger b, String a){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(String a, BigInteger b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(String a, String b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(long a, long  b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(int  a, int b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(int  b, String a){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(String a, int  b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(long b, String a){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger multiply(String a, long b){
		return multiply(new BigInteger(a), new BigInteger(b));
	}
	*/
	
	//flexible maxes
	public static BigInteger max(int a, BigInteger b) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(long a, BigInteger b) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(String a, BigInteger b) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(BigInteger b, int a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(BigInteger b, long a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(BigInteger b, String a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(String b, String a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(int b, int a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	public static BigInteger max(long b, long a) {
		return max(new BigInteger(a), new BigInteger(b));
	}
	// check which if these two BigIntegers is bigger than each other
	// takes in two big integers called a and b and returns the one that is
	// bigger
	// in case of equality returns the first one
	public static BigInteger max(BigInteger a, BigInteger b) {
		return max(a, b, a, b);
	}
	
	private static BigInteger max(BigInteger a, BigInteger b, BigInteger a1, BigInteger b1) {
		// longer length to a
		if ((a.equals(b)) || (a1.toString().length() == 0 && b1.toString().length() == 0)) {
			// if they are the same we return the first one
			return a;
		}
		if (a.toString().length() > b.toString().length())
			return a;
		// longer length to b
		else if (b.toString().length() > a.toString().length())
			return b;
		else {
			// if it has a bigger number on the leftmost digit it is larger for
			// sure
			if (Integer.parseInt(a1.toString().substring(0, 1)) > Integer.parseInt(b1.toString().substring(0, 1))) {
				return a;
			} 
			else if (Integer.parseInt(a1.toString().substring(0, 1)) < Integer
					.parseInt(b1.toString().substring(0, 1))) {
				return b;
			} 
			else {
				// ignore the first value and see which has the highest other
				// values
				// new variables are made to avoid messing up originals
				// relative position is kept intact so as to avoid confusing
				// maxs
				a1 = new BigInteger(a1.toString().substring(1));
				b1 = new BigInteger(b1.toString().substring(1));
				return max(a, b, a1, b1);
			}
		}
	}

	// in case of equality returns the first one
	public static BigInteger min(BigInteger a, BigInteger b) {
		BigInteger max = BigInteger.max(a, b);
		if (max.equals(a)) {
			return b;
		} 
		else {
			return a;
		}
	}

	//doesn't work in the implementational way I want it to
	/*
	public static BigInteger sumDigits(BigInteger a){
		long sum = 0;
		for(int i = 0; i < a.getLength(); i ++){
			sum += Long.parseLong(a.toString().substring(i, i+1));
		}
		return new BigInteger(sum);
	}
	*/
	
	// basic stuff
	// @Override
	public String toString() {
		return value;
	}

	// @Override
	public boolean equals(BigInteger other) {
		return toString().equals(other.toString());
	}

	// getters
	public String getValue() {
		return toString();
	}
	public int getLength(){
		return toString().length();
	}
	public int getDigitCount(){
		return toString().length();
	}
	//if it's already too big for int or long then this isn't gonna work
	//but its here for when its needed
	//there is no safety for this, so user be warned
	public int toInt(){
		return Integer.parseInt(toString());
				}
	public long toLong(){
		return Long.parseLong(toString());
	}

	// setters
	public void setValue(BigInteger a) {
		this.value = a.value;
	}

	// the string must be an actual int
	public void setValue(String value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = String.valueOf(value);
	}

	public void setValue(long value) {
		this.value = String.valueOf(value);
	}
}
