package com.transtu.tn.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;
    private String label;
    private String address;


    @JsonBackReference
    @ManyToMany(mappedBy = "districts")
    private Set<Ligne> lignes = new HashSet<>();
    
    
    @ManyToMany(mappedBy = "districts")
    private Set<Role> roles = new HashSet<>();
    
    public District() {
       
    }

    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	
    public District(Long districtId, String label, String address, Set<Ligne> lignes, Set<Role> roles) {
		super();
		this.districtId = districtId;
		this.label = label;
		this.address = address;
		this.lignes = lignes;
		this.roles = roles;
	}

	
	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", label=" + label + ", address=" + address + ", lignes=" + lignes
				+ ", roles=" + roles + "]";
	}

	public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 
    public Set<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(Set<Ligne> lignes) {
        this.lignes = lignes;
    }
}
