package com.gugulethuapps.AssetManagementApp.asset.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import com.gugulethuapps.AssetManagementApp.employee.model.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetLease {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="assetid", insertable=false, updatable=false)
	private Asset asset;
	private Integer assetid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateOut;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateIn;
	
	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee employee;
	private Integer employeeid;
	
	@ManyToOne
	@JoinColumn(name="cityid", insertable=false, updatable=false)
	private City city;
	private Integer cityid;
	
	private String remarks;
}
