package com.su.test;

import java.util.List;

import com.su.domain.Dept;
import com.su.service.DeptService;
import com.su.service.impl.DeptServiceImpl;

public class TestfindAllDept {

	public static void main(String[] args) {
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findAllDept();
		
		for(Dept dept : deptList){
			System.out.println("≤ø√≈√˚≥∆£∫"+dept.getDeptName());
		}

	}

}
