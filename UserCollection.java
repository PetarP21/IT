package users;

import java.util.HashSet;
import java.util.Set;

public class UserCollection {

	public static UserCollection instance = null;
	private static Set<User> collection; // Колекция от тип User
	static int index = 1;

	private UserCollection() {
	}

	public static UserCollection getInstance() // Извличане на колекция
	{
		if (instance == null) {
			instance = new UserCollection();
			collection = new HashSet<User>();
		}
		return instance;
	}

	public void addUser(User user) // Метод за добавяне на потребител
	{
		user.setId(index++);
		collection.add(user);
	}

	public User getUser(String userName) // Метод за връщане на потребител по потребителско име
	{
		for (User u : collection) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		return null;
	}

	public User getById(int id){
		User user = null;
		for(User u:collection)
		{
			if(id==u.getId())
			{
				user = u;
			}
		}
		return user;
	}
	
	public boolean checkIfExist(User user) { // Метод за проверка дали даден User е в колекцията
		return collection.contains(user);
	}

}