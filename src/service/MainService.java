package service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

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
			charList.remove(0);
			charList.print();
			System.out.println(charList.get(1));
			System.out.println("Search: " + charList.find('n'));
			charList.add('d');
			charList.add('z');
			charList.add('n');
			charList.add('z');
			System.out.println("!" +Arrays.toString(charList.retrieveNextNeighbours('n')));
			System.out.println(charList.sort(SortingType.ASC));
			charList.print();
			charList.clear();
			//charList.print();
			charList.add('d');
			charList.print();
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static MyArrayList getArrayElementsFromFile(String path) {
		File myFile = new File(path);
		FileInputStream myInputStream = new FileInputStream(myFile);
		Scanner myScanner = new Scanner(myInputStream);
		MyArrayList listFromFile = new MyArrayList();
		while(myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			char element = line.charAt(0);
			listFromFile.add(element);
		}
		myScanner.close();
		return listFromFile;
	}
}
