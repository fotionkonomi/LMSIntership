package org.lms.converter;


import org.lms.dto.RoleDTO;
import org.lms.model.Role;

public class RoleConverterImpl implements RoleConverter {

	public Role toModel(RoleDTO roleDTO) {
		Role role = new Role();
	//	role.setRoleId(roleDTO.getRoleId());
		role.setRoleName(roleDTO.getRoleName());
		role.setRoleDescription(roleDTO.getRoleDescription());
		return role;
	}
	
	public RoleDTO toDTO(Role role) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleId(role.getRoleId());
		roleDTO.setRoleName(role.getRoleDescription());
		roleDTO.setRoleDescription(role.getRoleDescription());
		return roleDTO;
	}
}
