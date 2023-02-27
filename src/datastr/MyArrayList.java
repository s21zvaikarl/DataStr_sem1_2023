package datastr;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	//no arg constructor
	public MyArrayList() {
		elements = new char[arraySize]; //masivs ar 6 sunam
	}
	//args constructor
	public MyArrayList(int inputArraySize) {
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		elements = new char[arraySize];
	}
	
	public boolean isEmpty() {
		/*
		if(elementCounter == 0) {
			return true;
		}
		return false;
		*/
		//return (elementCounter == 0)? true : false;
		
		return (elementCounter == 0);
	}
	
	public boolean isFull() {
		return (elementCounter == arraySize);
	}
	
	public int howManyElements() {
		return elementCounter;
	}
	
	private void increaseArray() {
		int newArraySize = (arraySize>100)? (int) (arraySize*1.5) : arraySize*2;
		char[] newElements = new char[newArraySize];
		for(int i = 0; i<arraySize; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		arraySize = newArraySize;
	}
}
