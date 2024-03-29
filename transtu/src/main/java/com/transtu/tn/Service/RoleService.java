package com.transtu.tn.Service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.transtu.tn.Entity.District;
import com.transtu.tn.Entity.Role;
import com.transtu.tn.Repository.RoleRepository;
import com.transtu.tn.Request.RoleRequest;

@Service
public class RoleService {

	private final RoleRepository roleRepository;
	
    private final DistrictService districtService;

 
    public RoleService(RoleRepository roleRepository, DistrictService districtService) {
        this.roleRepository = roleRepository;
        this.districtService = districtService;
    }

    public void createRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setLabel(roleRequest.getLabel());
        role.setDescription(roleRequest.getDescription());
        Set<District> districts = districtService.getDistrictsByIds(roleRequest.getDistrictIds());
        role.setDistricts(districts);

        roleRepository.save(role);
    }


    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public boolean deleteRoleById(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}