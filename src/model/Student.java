package model;

public class Student implements Comparable<Student> {
	//1. variables 
	private long id;
	private String name;
	private String surname;
	private Faculty faculty;
	private String personCode;
	
	private static long studentCounter = 0;
	
	//2. getters and setters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public String getPersonCode() {
		return personCode;
	}
	
	
	public void setId() {
		id = studentCounter;
		studentCounter++;
	}
	
	//TODO take a look to https://regex101.com/
	//[A-Z]{1}[a-z]+
	//[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+[ ]?([A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?
	//setname("sjkdhskfx78923748372hsdjkc7s8f798sedf")
	public void setName(String inputName) {
		if(inputName!=null && inputName.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+([ ][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?"))
		{
			name = inputName;
		}
		else
		{
			name = "Unknown";
		}
	}

	public void setSurname(String inputSurname) {
		if(inputSurname!=null && inputSurname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+([-][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?"))
		{
			surname = inputSurname;
		}
		else
		{
			surname = "Unknown";
		}
	}
	
	//TODO try to combine both regex masks
	//old personCode [0-9]{6}[-][0-9]{5}
	//new personCode 32{1}[0-9]{9}
	public void setPersonCode(String inputPersonCode) {
		if(inputPersonCode!=null && inputPersonCode.matches("[0-9]{6}[-][0-9]{5}"))
		{
			personCode = inputPersonCode;
		}
		else
		{
			personCode = "000000-00000";
		}
	}
	
	public void setFaculty(Faculty inputFaculty) {
		if(inputFaculty!=null) {
			faculty = inputFaculty;
		}
		else
		{
			faculty = Faculty.other;
		}
	}

	//3. constructors
	//no-args constructor
	public Student()
	{
		setId();
		setName("Unknown");
		setSurname("Unknown");
		setFaculty(Faculty.other);
		setPersonCode("000000-00000");
	}
	
	//args constructor
	public Student(String name, String surname, Faculty faculty, String personCode ) {
		setId();
		setName(name);
		setSurname(surname);
		setFaculty(faculty);
		setPersonCode(personCode);
	}

	
	//Student [id=0, name=Jānis, surname=Bērziņš utt
/*	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", faculty=" + faculty
				+ ", personCode=" + personCode + "]";
	}
	*/
	//4. toString
	//0: Jānis Bērziņš, 121290-12345, ITF
	public String toString() {
		return "" + id + ": " + name + " " + surname + ", " + personCode + ", " +faculty;
	}
	//5. additional functions

	@Override
	public int compareTo(Student o) {
		if(surname.charAt(0) > o.surname.charAt(0)) {
			return 1;
		}
		else if(surname.charAt(0) < o.surname.charAt(0)) {
			return -1;
		}
		else return 0;
	}
}