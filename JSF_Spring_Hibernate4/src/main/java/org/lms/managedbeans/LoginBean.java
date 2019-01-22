package org.lms.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.lms.dto.UserDTO;
import org.lms.service.LoginService;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private UserDTO userDTO;
	private String username;
	private String password;
	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;

	@PostConstruct
	public void init() {
		userDTO = new UserDTO();
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		userDTO = loginService.login(username, password);

		if (userDTO == null) {
			context.addMessage(null, new FacesMessage("Wrong username or password"));
			return null;
		} else {
			context.getExternalContext().getSessionMap().put("user", userDTO);
			context.getExternalContext().getSessionMap().put("userId", userDTO.getUserId());
			context.getExternalContext().getSessionMap().put("firstName", userDTO.getFirstName());
			context.getExternalContext().getSessionMap().put("lastName", userDTO.getLastName());
			context.getExternalContext().getSessionMap().put("username", userDTO.getUsername());
			context.getExternalContext().getSessionMap().put("email", userDTO.getEmail());
			context.getExternalContext().getSessionMap().put("age", userDTO.getAge());

			return ("login");
		}
	}

	public UserDTO getUser() {
		return userDTO;
	}

	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
