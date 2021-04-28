package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCollection collection;

	public void init(ServletConfig config) throws ServletException { // Инициализация на сървлета

		collection = UserCollection.getInstance(); // Извличаме/създаваме една единствена инстанция
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // Задаваме типа на съдържанието на отговора(response)
		response.setCharacterEncoding("UTF-8"); // Задаваме кирилица
		request.setCharacterEncoding("UTF-8"); // Задаваме кирилица за заявката(request)

		PrintWriter out = response.getWriter();
		
		// Извличане на данните от формата
		String personalName = request.getParameter("Person");
		String userName = request.getParameter("User");
		String password = request.getParameter("Password");
		String rep_password = request.getParameter("Rep_password");

		if (personalName == null || personalName.isEmpty() || userName == null || userName.isEmpty() || password == null
				|| password.isEmpty() || rep_password == null || rep_password.isEmpty()) {
			out.print("<p style='color:red; text-align:center'> Моля, въведете всички полета!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
			rd.include(request, response);
		} else if (!rep_password.equals(password)) {
			out.print("<p style='color:red; text-align:center'> Въведените пароли не съвпадат!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
			rd.include(request, response);

		} else {
			User user = new User(personalName, userName, password);
			ArrayList<Skill> profSkills = new ArrayList<Skill>();
			profSkills.add(new Skill());
			profSkills.add(new Skill());
			profSkills.add(new Skill());
			profSkills.add(new Skill());

			user.setProfesionalSkill(profSkills);

			ArrayList<Skill> personalSkills = new ArrayList<Skill>();
			personalSkills.add(new Skill());
			personalSkills.add(new Skill());
			personalSkills.add(new Skill());

			user.setPersonalSkill(personalSkills);

			if (collection.getUser(userName) == null) {
				collection.addUser(user);
				response.sendRedirect("LoginPage.jsp");
			} else {
				out.print("<p style='color:red; text-align:center'> Потребителското име е заето!</p>");
				RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
				rd.include(request, response);

			}
		}
	}

}
