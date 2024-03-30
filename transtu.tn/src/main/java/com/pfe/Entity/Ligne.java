package com.pfe.Entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Ligne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;
    
 
    @ManyToMany
    @JoinTable(
            name = "Ligne_District",
            joinColumns = @JoinColumn(name = "ligne_id"),
            inverseJoinColumns = @JoinColumn(name = "district_id")
    )
    private Set<District> districts = new HashSet<>();
   
	@Override
	public String toString() {
		return "Ligne [id=" + id + ", code=" + code + ", label=" + label + ", districts=" + districts + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	public Ligne() {
		
	}

	public Ligne(Long id, String code, String label, Set<District> districts) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.districts = districts;
	
	}

	


  
}