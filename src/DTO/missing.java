package DTO;

public class missing {

	String animal_num;
	String dog_name;
	String dog_kind;
	String sex;
	String unique;
	String miss_place;
	String miss_time;
	String miss_date;
	String id;
	
	public missing(String animal_num, String dog_name, String dog_kind, String sex, String unique, String miss_place,
			String miss_time, String miss_date, String id) {
		
		this.animal_num = animal_num;
		this.dog_name = dog_name;
		this.dog_kind = dog_kind;
		this.sex = sex;
		this.unique = unique;
		this.miss_place = miss_place;
		this.miss_time = miss_time;
		this.miss_date = miss_date;
		this.id = id;
	}
	
	public String animal_num() {
		return animal_num;
	}
	public void animal_num(String animal_num) {
		this.animal_num = animal_num;
	}
	
	public String dog_name() {
		return dog_name;
	}
	public void dog_name(String dog_name) {
		this.dog_name = dog_name;
	}
	
	public String dog_kind() {
		return dog_kind;
	}
	public void dog_kind (String dog_kind) {
		this.dog_kind = dog_kind;
	}
	
	public String sex() {
		return sex;
	}
	public void sex(String sex) {
		this.sex = sex;
	}
	
	public String unique() {
		return unique;
	}
	public void unique(String unique) {
		this.unique = unique;
	}
	public String miss_place() {
		return miss_place;
	}
	public void miss_place(String miss_place) {
		this.miss_place = miss_place;
	}
	public String miss_time() {
		return miss_time;
	}
	public void miss_time(String miss_time) {
		this.miss_time = miss_time;
	}
	public String miss_date() {
		return miss_date;
	}
	public void miss_date(String miss_date) {
		this.miss_date = miss_date;
	}
	public String id() {
		return id;
	}
	public void id(String id) {
		this.id = id;
	}
}