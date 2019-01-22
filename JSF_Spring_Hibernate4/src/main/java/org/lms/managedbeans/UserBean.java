package org.lms.managedbeans;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
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
	private UserDTO userDTOLogged;
	private UserDTO userToBeActivated;
	private String username;
	private Integer userId;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("ERDHI KETU");
		userDTOLogged = (UserDTO) context.getExternalContext().getSessionMap().get("user");

		username = (String) context.getExternalContext().getSessionMap().get("username");
		userId = (int) context.getExternalContext().getSessionMap().get("userId");

	}

	public UserDTO getUserDTOLogged() {
		return userDTOLogged;
	}

	public void setUserDTOLogged(UserDTO userDTOLogged) {
		this.userDTOLogged = userDTOLogged;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public UserDTO getUserToBeActivated() {
		return userToBeActivated;
	}

	public void setUserToBeActivated(UserDTO userToBeActivated) {
		this.userToBeActivated = userToBeActivated;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String passwordi(User user) {
		return Encryptor.decrypt(user.getPassword(), 12);
	}

	public List<UserDTO> listUser() {
		return userService.listUser();
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
	
	public Boolean isUserAdmin() {
		return userService.isUserAdmin(userDTOLogged);
	}

}
