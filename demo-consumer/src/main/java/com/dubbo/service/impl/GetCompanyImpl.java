package com.dubbo.service.impl;

import com.dubbo.demo.entity.Company;
import com.dubbo.demo.service.CompanyService;

public class GetCompanyImpl implements CompanyService{

	public Company getCompany() {
		// TODO Auto-generated method stub
		System.out.println("CompanyService getCompany invoke!!");
		Company comp = new Company();
		comp.setName("SDT");
		comp.setAddress("学院路");
		return comp;
	}

}
