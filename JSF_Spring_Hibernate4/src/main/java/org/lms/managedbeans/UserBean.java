package org.lms.managedbeans;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.converter.UserConverterImpl;
import org.lms.dto.UserDTO;
import org.lms.model.Role;
import org.lms.model.User;
import org.lms.service.RoleService;
import org.lms.service.UserService;
import org.lms.utils.Encryptor;
import org.lms.utils.Util;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	private static final Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;
	private String firstName;
	private String lastName;
	private String username;
	private String gender;
	private Integer age;
	private String email;
	private String password;
	private Boolean activated;
	private UserDTO userDTO = new UserDTO();
	private HttpSession hs;
	private UserDTO userToBeActivated;

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserDTO getUserToBeActivated() {
		return userToBeActivated;
	}

	public void setUserToBeActivated(UserDTO userToBeActivated) {
		this.userToBeActivated = userToBeActivated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String addUser() {
		LOGGER.info("First Name entered in the form: " + firstName);
		LOGGER.info("Last Name entered in the form: " + lastName);
		LOGGER.info("Username entered in the form: " + username);
		LOGGER.info("Email entered in the form: " + email);
		LOGGER.info("Gender entered in the form: " + gender);
		LOGGER.info("Age entered in the form: " + age);
		LOGGER.info("Password entered in the form: ******************** ");

		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setAge(age);
		userDTO.setEmail(email);
		userDTO.setPassword(Encryptor.encrypt(password, 12));
		if (gender.equals("Male")) {
			userDTO.setGender(true);
		} else if (gender.equals("Female")) {
			userDTO.setGender(false);
		} else {
			FacesContext.getCurrentInstance().addMessage("gender",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select your gender!", null));
			return null;
		}
		userDTO.setUsername(username);
		userDTO.setActivated(0);
		try {
			userService.addUser(userDTO);
		} catch (ConstraintViolationException e) {
			FacesContext.getCurrentInstance().addMessage("Existing",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or email is already taken", null));
			return null;
		}
		// roleService.updateRole(role);
		return ("page");
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String passwordi(User user) {
		return Encryptor.decrypt(user.getPassword(), 12);
	}

	public List<UserDTO> listUser() {
		return userService.listUser();
	}

	public HttpSession getHs() {
		return hs;
	}

	public void setHs(HttpSession hs) {
		this.hs = hs;
	}

	public String logIn() {
		FacesContext context = FacesContext.getCurrentInstance();

		UserDTO userDTO = userService.find(username, password);
		if (userDTO == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error logging in, please check your username or password", null));
			return null;
		} else {
			Integer activated = userDTO.getActivated();
			if (activated == 0) {
				return ("notActivated");
			} else if (activated == -1) {
				userService.deleteUser(userDTO);
				return ("disActivated");
			} else {
				context.getExternalContext().getSessionMap().put("user", username);
				hs = Util.getSession();
				hs.setAttribute("username", username);
				return "login";
			}
		}
	}

	public void logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
	}

	public List<UserDTO> usersThatAreNotActivated() {
		return userService.findUsersThatAreNotActivated();
	}

	public String activate() {
		this.userService.activateUser(userToBeActivated);
		return "here";
	}

	public String deActivate() {
		this.userService.deActivateUser(userToBeActivated);
		return "here";
	}
	
	public String test() {
		if (hs != null) {
			return "JAM I LOGUAR";
		} else {
			return "NUK JAM I LOGUAR";
		}
	}

	public Boolean isSessionActive() {
		if (hs == null) {
			return false;
		} else {
			return true;
		}
	}

	public String goToBook() {
		if (isSessionActive()) {
			return "book";
		} else {
			return "index";
		}
	}

	public String goToCategory() {
		if (isSessionActive()) {
			return "category";
		} else {
			return "index";
		}
	}

	public String goToRequests() {
		if (isSessionActive()) {
			return ("request");
		} else {
			return "index";
		}
	}

	public String goToSuccess() {
		if (isSessionActive()) {
			return ("success");
		} else {
			return "index";
		}
	}
}
