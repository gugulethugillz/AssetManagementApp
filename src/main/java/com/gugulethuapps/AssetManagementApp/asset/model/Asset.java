package com.gugulethuapps.AssetManagementApp.asset.model;

import java.util.Date;

import javax.persistence.*;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import com.gugulethuapps.AssetManagementApp.employee.model.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Asset {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;

	@Enumerated(EnumType.STRING)
	private AssetType assetType;
	
	private String assetNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;

	private String assetMake;

	@Enumerated(EnumType.STRING)
	private AssetStatus assetStatus;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee inCharge;
	private Integer employeeid;

	private String assetModel;

	@ManyToOne
	@JoinColumn(name="cityid", insertable=false, updatable=false)
	private City currentCity;
	private Integer cityid;
	
	private String remarks;	
}
