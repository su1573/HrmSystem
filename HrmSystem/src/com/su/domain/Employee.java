package com.su.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private Integer employeeId;    //员工id
	private Integer deptId;
	private Dept dept;				//部门
	private Integer jobId;
	private Job job;				//职业
	private String employeeName;	//员工名字
	private String employeeCardId;  //身份证
	private String employeeAddress; //地址
	private String employeePostCode; //邮政编码
	private String employeePhone;	 //手机号
	private String employeeQQ;		 //QQ号
	private String employeeEmail; 	 //E-mail
	private String employeeSex;		 //性别
	private String employeeParty;    //政治面貌
	/**
	 *  使用@ModelAttribute接收参数时
	 *  form表单中有日期,Spring不知道该如何转换,
	 *  要在实体类的日期属性上加@DateTimeFormat(pattern="yyyy-MM-dd")注解 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date employeeBirthday;   //出生日期
	
	private String employeeRace;     //民族
	private String employeeEducation;  //学历
	private String employeeHobby;      //爱好
	private Date employeeCreateDate; //建档日期
	
	public Employee(){
		super();
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCardId() {
		return employeeCardId;
	}

	public void setEmployeeCardId(String employeeCardId) {
		this.employeeCardId = employeeCardId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeePostCode() {
		return employeePostCode;
	}

	public void setEmployeePostCode(String employeePostCode) {
		this.employeePostCode = employeePostCode;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeQQ() {
		return employeeQQ;
	}

	public void setEmployeeQQ(String employeeQQ) {
		this.employeeQQ = employeeQQ;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeeParty() {
		return employeeParty;
	}

	public void setEmployeeParty(String employeeParty) {
		this.employeeParty = employeeParty;
	}

	public Date getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(Date employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}

	public String getEmployeeRace() {
		return employeeRace;
	}

	public void setEmployeeRace(String employeeRace) {
		this.employeeRace = employeeRace;
	}

	public String getEmployeeEducation() {
		return employeeEducation;
	}

	public void setEmployeeEducation(String employeeEducation) {
		this.employeeEducation = employeeEducation;
	}

	public String getEmployeeHobby() {
		return employeeHobby;
	}

	public void setEmployeeHobby(String employeeHobby) {
		this.employeeHobby = employeeHobby;
	}

	public Date getEmployeeCreateDate() {
		return employeeCreateDate;
	}

	public void setEmployeeCreateDate(Date employeeCreateDate) {
		this.employeeCreateDate = employeeCreateDate;
	}
	

}
