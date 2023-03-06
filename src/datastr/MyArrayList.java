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
	//arg constructor
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
	
	public void add(char newElement) {
		if (isFull()) {
			increaseArray();
		}
		elements[elementCounter++] = newElement;
		//elementCounter++;
	}
	
	public void add(char newElement, int index) throws Exception {
		if (index >= 0 && index <= elementCounter) {
			if (isFull()) {
				increaseArray();
			}
			for(int i = elementCounter; i>index; i--) {
				elements[i] = elements[i-1];
			}
			elements[index] = newElement;
			elementCounter++;
		}
		else {
			throw (new Exception("Wrong index"));
		}
	}
	public void remove(int index) throws Exception {
		if (isEmpty()) {
			throw (new Exception("Nothing to delete"));
		}
		else {
			if (index >= 0 && index <= elementCounter) {
				for(int i = index; i<elementCounter; i++) {
					elements[i] = elements[i+1];
				}
				elements[elementCounter-1] = 0;
				elementCounter--;
			}
			else {
				throw (new Exception("Wrong index"));
			}
		}
	}
	public int get(int index) throws Exception {
		if (isEmpty()) {
			throw (new Exception("Nothing to return"));
		}
		if (index >= 0 && index <= elementCounter) {
			return elements[index];
		}
		else {
			throw (new Exception("Wrong index"));
		}
	}
	public boolean find(char newElement) throws Exception {
		if (isEmpty()) {
			throw (new Exception("Nothing to find"));
		}
		for (int i=0; i < elementCounter; i++) {
			if(newElement == elements[i]) {
				return true;
			}
		}
		return false;
	}
	
	public char[] retrieveNextNeighbours(char inputElement) throws Exception {
		if(find(inputElement)) {
			int howManySearchedElements = 0;
			for(int i = 0; i < elementCounter; i++) {
				if(elements[i] == inputElement) {
					howManySearchedElements++;
				}
			}
				if(elements[elementCounter-1]==inputElement) {
					howManySearchedElements--;
				}
				char[] nextNeighbours = new char[howManySearchedElements];
				int indexForNeighbours = 0;
				for(int j = 0; j < elementCounter-1; j++) {
					if(elements[j] == inputElement) {
						nextNeighbours[indexForNeighbours] = elements[j+1];
						indexForNeighbours++;
					}
				}
			
		return nextNeighbours;	
		}
		else {
			throw (new Exception("Input element is not found"));
		}
		
		
	}

	public char[] sort(SortingType type) throws Exception {
		if(isEmpty()) {
			throw (new Exception("Nothing to sort"));
		}
		else {
			char[] sortArray = new char[elementCounter];
			for(int i = 0; i < elementCounter; i++) {
				sortArray[i] = elements[i];
			}
			if(type == SortingType.ASC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter; j++) {
						if(sortArray[i] > sortArray[j]) {
							char temp = sortArray[i];
							sortArray[i] = sortArray[j];
							sortArray[j] = temp;
						}
						
					}
				}
			}
			else if(type == SortingType.DESC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter; j++) {
						if(sortArray[i] < sortArray[j]) {
							char temp = sortArray[i];
							sortArray[i] = sortArray[j];
							sortArray[j] = temp;
						}
						
					}
				}
			}
			else {
				throw (new Exception("Wrong sorting type"));
			}
			return sortArray;
		}
	}
	
	public void print() throws Exception {
		if (isEmpty()) {
			throw (new Exception("Nothing to print"));
		}
		for (int i=0; i < elementCounter; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	public void clear() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = new char[arraySize];
	}
}
