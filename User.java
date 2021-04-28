package users;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	private String personalName; // Собствено име
	private String userName; // Потребителско име
	private String password; // Парола
	private String jobTitle; // Работа
	private String description; // Описание
	private String email; // Имейл
	private String phone; // Телефон
	private Address address; // Адрес
	private ArrayList<Skill> profesionalSkill; // Проф. умения
	private ArrayList<Skill> personalSkill; // Личностни умения
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<Skill> getProfesionalSkill() {
		return profesionalSkill;
	}

	public void setProfesionalSkill(ArrayList<Skill> profesionalSkill) {
		this.profesionalSkill = profesionalSkill;
	}

	public ArrayList<Skill> getPersonalSkill() {
		return personalSkill;
	}

	public void setPersonalSkill(ArrayList<Skill> personalSkill) {
		this.personalSkill = personalSkill;
	}


	public User()
	{}

	public User(String personalName, String userName, String password) {
		super();
		this.personalName = personalName;
		this.userName = userName;
		this.password = password;
		this.jobTitle = "не е зададена";
		this.description = "не е зададенo";
		this.phone = "не е зададен";
		this.email = "не е зададен";
		this.address = new Address();
		this.profesionalSkill = new ArrayList<Skill>();
		this.personalSkill = new ArrayList<Skill>();



	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getUserName() {
		return userName;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
}
