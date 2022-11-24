package DTO;

public class adopt{

	String adopt_num;
	String adopt_date;
	String adopt_dog_name;
	String adopt_dog_kind;
	String adopt_dog_sex;
	String shelter_num;
	String id;
	
	public adopt(String adopt_num, String adopt_date, String adopt_dog_name, String adopt_dog_kind, String adopt_dog_sex,
			String shelter_num, String id) {
		
		this.adopt_num = adopt_num;
		this.adopt_date = adopt_date;
		this.adopt_dog_name = adopt_dog_name;
		this.adopt_dog_kind = adopt_dog_kind;
		this.adopt_dog_sex = adopt_dog_sex;
		this.shelter_num = shelter_num;
		this.id = id;
	}
	
	public String adopt_num() {
		return adopt_num;
	}
	public void adopt_num(String adopt_num) {
		this.adopt_num = adopt_num;
	}
	public String adopt_date() {
		return adopt_date;
	}
	public void adopt_date(String adopt_date) {
		this.adopt_date = adopt_date;
	}
	public String adopt_dog_name() {
		return adopt_dog_name;
	}
	public void adopt_dog_name(String adopt_dog_name) {
		this.adopt_dog_name = adopt_dog_name;
	}
	public String adopt_dog_kind() {
		return adopt_dog_kind;
	}
	public void adopt_dog_kind(String adopt_dog_kind) {
		this.adopt_dog_kind = adopt_dog_kind;
	}
	public String adopt_dog_sex() {
		return adopt_dog_sex;
	}
	public void adopt_dog_sex(String adopt_dog_sex) {
		this.adopt_dog_sex = adopt_dog_sex;
	}
	public String shelter_num() {
		return shelter_num;
	}
	public void shelter_num(String shelter_num) {
		this.shelter_num = shelter_num;
	}
	public String id() {
		return id;
	}
	public void id(String id) {
		this.id = id;
	}
}