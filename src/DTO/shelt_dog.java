package DTO;

public class shelt_dog {

	int shelt_dog_num;
	String shelt_dog_name;
	String shelt_dog_kind;
	String shelt_dog_sex;
	String shelt_dog_age;
	String shelt_dog_weight;
	String shelt_dog_rescue;
	String shelt_dog_find;
	String shelt_dog_prot;
	String shelter_num;
	
	public shelt_dog(int shelt_dog_num, String shelt_dog_name, String shelt_dog_kind, String shelt_dog_sex, String shelt_dog_age
	                 ,String shelt_dog_weight, String shelt_dog_rescue, String shelt_dog_find, String shelt_dog_prot
	                 , String shelter_num ) {
		
		this.shelt_dog_num = shelt_dog_num;
		this.shelt_dog_kind = shelt_dog_kind;
		this.shelt_dog_sex = shelt_dog_sex;
		this.shelt_dog_age = shelt_dog_age;
		this.shelt_dog_weight = shelt_dog_weight;
		this.shelt_dog_rescue = shelt_dog_rescue;
		this.shelt_dog_find = shelt_dog_find;
		this.shelt_dog_prot = shelt_dog_prot;
		this.shelter_num = shelter_num;
	}
	
	public int shelt_dog_num() {
		return shelt_dog_num;
	}
	public void setshelt_dog_num(int shelt_dog_num) {
		this.shelt_dog_num = shelt_dog_num;
	}
	public String shelt_dog_kind() {
		return shelt_dog_kind;
	}
	public void setshelt_dog_kind(String shelt_dog_kind) {
		this.shelt_dog_kind = shelt_dog_kind;
	}
	public String shelt_dog_sex() {
		return shelt_dog_sex;
	}
	public void setshelt_dog_sex(String shelt_dog_sex) {
		this.shelt_dog_sex = shelt_dog_sex;
	}
	public String shelt_dog_age() {
		return shelt_dog_age;
	}
	public void setshelt_dog_age(String shelt_dog_age) {
		this.shelt_dog_age = shelt_dog_age;
	}
	public String shelt_dog_weight() {
		return shelt_dog_weight;
	}
	public void setshelt_dog_weight(String shelt_dog_weight) {
		this.shelt_dog_weight = shelt_dog_weight;
	}
	public String shelt_dog_rescue() {
		return shelt_dog_rescue;
	}
	public void setshelt_dog_rescue(String shelt_dog_rescue) {
		this.shelt_dog_rescue = shelt_dog_rescue;
	}
	public String shelt_dog_find() {
		return shelt_dog_find;
	}
	public void setshelt_dog_find(String shelt_dog_find) {
		this.shelt_dog_find = shelt_dog_find;
	}
	public String shelt_dog_prot() {
		return shelt_dog_prot;
	}
	public void setshelt_dog_prot(String shelt_dog_prot) {
		this.shelt_dog_prot = shelt_dog_prot;
	}
	public String shelter_num() {
		return shelter_num;
	}
	public void setshelter_num(String shelter_num) {
		this.shelter_num = shelter_num;
	}
}