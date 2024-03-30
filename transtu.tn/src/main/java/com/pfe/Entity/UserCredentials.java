package com.pfe.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserCredentials {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

	@Override
	public String toString() {
		return "UserCredentials [id=" + id + ", username=" + username + ", password=" + password + ", user=" + user
				+ "]";
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCredentials(Long id, String username, String password, User user) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
	}

	public UserCredentials() {
	
	}

}