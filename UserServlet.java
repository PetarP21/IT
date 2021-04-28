package users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCollection collection;

	public void init(ServletConfig config) throws ServletException {
		collection = UserCollection.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		User registeredUser = collection.getById(id);
		request.setAttribute("registeredUser", registeredUser);
		RequestDispatcher rd = request.getRequestDispatcher("/EditProfilPage.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("personal_name");
		String jobTitle = request.getParameter("job_title");
		String description = request.getParameter("description");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		Address address = new Address(city,street);
		
		User updatedUser = collection.getById(id);
		
		updatedUser.setPersonalName(name);
		updatedUser.setJobTitle(jobTitle);
		updatedUser.setDescription(description);
		updatedUser.setEmail(email);
		updatedUser.setPhone(phone);
		updatedUser.setAddress(address);
		
		for(int i=0;i<updatedUser.getProfesionalSkill().size();i++)
		{
			String profSkillName = request.getParameter("profSkillName");
			int profSkillLevel = Integer.parseInt(request.getParameter("profSkillLevel"+i));
			updatedUser.getProfesionalSkill().get(i).setSkillName(profSkillName);
			updatedUser.getProfesionalSkill().get(i).setLevel(profSkillLevel);
		}
		
		for(int i=0;i<updatedUser.getPersonalSkill().size();i++)
		{
			String personalSkillName = request.getParameter("personalSkillName");
			int personalSkillLevel = Integer.parseInt(request.getParameter("personalSkillLevel"+i));
			updatedUser.getPersonalSkill().get(i).setSkillName(personalSkillName);
			updatedUser.getPersonalSkill().get(i).setLevel(personalSkillLevel);
		}
		
		request.setAttribute("registeredUser", updatedUser);
		RequestDispatcher rd = request.getRequestDispatcher("/ProfilPage.jsp");
		rd.forward(request, response);
	}

}
