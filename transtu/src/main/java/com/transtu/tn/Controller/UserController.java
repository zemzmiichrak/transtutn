package com.transtu.tn.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transtu.tn.Entity.UserCredentials;
import com.transtu.tn.Request.*;
import com.transtu.tn.Service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody UserRegistration userRegistration) {
        try {
            if (userRegistration == null || userRegistration.getUserSave() == null || userRegistration.getCredentials() == null) {
                return ResponseEntity.badRequest().body("User registration data is incomplete");
            }

            UserSave userSave = userRegistration.getUserSave();
            UserCredentials credentials = userRegistration.getCredentials();

            userService.addUser(userSave, credentials);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user: " + e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody UserCredentialsLogin credentialsLogin) {
        String token = userService.login(credentialsLogin);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping(path = "/getAllUser")
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateUser(@RequestBody UserUpdating userUpdating) {
        userService.updateUser(userUpdating.getUserUpdate(), userUpdating.getUpdatedCredentials(), userUpdating.getRoleIds());
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or could not be deleted");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");

        if (email == null) {
            return ResponseEntity.badRequest().body("Email is required for logout");
        }

        userService.logout(email);

        return ResponseEntity.ok("User logged out successfully");
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        String oldPassword = requestData.get("oldPassword");
        String newPassword = requestData.get("newPassword");

        if (email == null || oldPassword == null || newPassword == null) {
            return ResponseEntity.badRequest().body("Email, old password, and new password are required");
        }

        userService.updatePassword(email, oldPassword, newPassword);

        return ResponseEntity.ok("Password updated successfully");
    }
}
