package com.transtu.tn.Service;

import java.util.List;
import java.util.Set;
import com.transtu.tn.Entity.UserCredentials;
import com.transtu.tn.Request.UserCredentialsLogin;
import com.transtu.tn.Request.UserRequest;
import com.transtu.tn.Request.UserSave;
import com.transtu.tn.Request.UserUpdate;

public interface UserInterfaceService {


	public String login(UserCredentialsLogin credentialsLogin);

	public List<UserRequest> getAllUser();
	
	public String updateUser(UserUpdate userUpdate, UserCredentials updatedCredentials, Set<Long> roleIds);

	public String addUser(UserSave userSave, UserCredentials credentials);

	public boolean deleteUser(Long id);

    public void logout(String email);

	public void updatePassword(String email, String oldPassword, String newPassword);

 
	


   
	
}