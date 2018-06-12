package com.su.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private Integer employeeId;    //Ա��id
	private Integer deptId;
	private Dept dept;				//����
	private Integer jobId;
	private Job job;				//ְҵ
	private String employeeName;	//Ա������
	private String employeeCardId;  //���֤
	private String employeeAddress; //��ַ
	private String employeePostCode; //��������
	private String employeePhone;	 //�ֻ���
	private String employeeQQ;		 //QQ��
	private String employeeEmail; 	 //E-mail
	private String employeeSex;		 //�Ա�
	private String employeeParty;    //������ò
	/**
	 *  ʹ��@ModelAttribute���ղ���ʱ
	 *  form����������,Spring��֪�������ת��,
	 *  Ҫ��ʵ��������������ϼ�@DateTimeFormat(pattern="yyyy-MM-dd")ע�� 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date employeeBirthday;   //��������
	
	private String employeeRace;     //����
	private String employeeEducation;  //ѧ��
	private String employeeHobby;      //����
	private Date employeeCreateDate; //��������
	
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
