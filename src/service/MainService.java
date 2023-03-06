package service;

import java.util.Arrays;

import datastr.MyArrayList;
import datastr.SortingType;

public class MainService {
	public static void main(String[] args) {
		MyArrayList charList = new MyArrayList();
		try {
			charList.add('a');
			charList.add('c');
			charList.add('n');
			charList.add('z', 0);
			charList.print();
			System.out.println(charList.howManyElements());
			charList.remove('a', 0);
			charList.print();
			System.out.println(charList.get(1));
			System.out.println("Search: " + charList.find('n'));
			charList.add('d');
			charList.add('z');
			charList.add('n');
			charList.add('z');
			System.out.println(Arrays.toString(charList.retrieveNextNeighbours('n')));
			System.out.println(charList.sort(SortingType.ASC));
			charList.print();
			charList.clear();
			charList.print();
			charList.add('d');
			charList.print();
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
