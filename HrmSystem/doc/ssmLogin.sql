--#创建表userTable
CREATE TABLE userTable (
  userId number(11) NOT NULL,
  loginName VARCHAR(20) NOT NULL,
  loginPwd VARCHAR(16) NOT NULL,
  userStatus number(11) NOT NULL,
  userCreatedate TIMESTAMP NOT NULL ,
  userName VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (userId)
);
create sequence user_seq
start with 0
minvalue 0
increment by 1;
INSERT  INTO userTable(userId,loginName,loginPwd,userStatus,userCreatedate,userName) VALUES (user_seq.nextval,'su','1573',2,to_timestamp('2017-7-31 10:55:23','yyyy-mm-dd hh24:mi:ss'),'超级管理员');
INSERT  INTO userTable(userId,loginName,loginPwd,userStatus,userCreatedate,userName) VALUES (user_seq.nextval,'admin','123456',2,to_timestamp('2017-7-31 10:55:23','yyyy-mm-dd hh24:mi:ss'),'超级管理员');
INSERT  INTO userTable(userId,loginName,loginPwd,userStatus,userCreatedate,userName) VALUES (user_seq.nextval,'root','root',2,to_timestamp('2017-7-31 10:55:23','yyyy-mm-dd hh24:mi:ss'),'普通管理员');
INSERT  INTO userTable(userId,loginName,loginPwd,userStatus,userCreatedate,userName) VALUES (user_seq.nextval,'tom','cat',2,to_timestamp('2017-7-31 10:55:23','yyyy-mm-dd hh24:mi:ss'),'普通管理员');
commit;


CREATE TABLE deptTable (
  deptId number(11) NOT NULL,
  deptName VARCHAR(50) NOT NULL,
  deptDesc VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (deptId)
);
create sequence dept_seq
start with 0
minvalue 0
increment by 1;
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'技术部','技术部');
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'运营部','运营部');
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'财务部','财务部');
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'总公办','总公办');
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'市场部','市场部');
INSERT  INTO deptTable(deptId,deptName,deptDesc) VALUES (dept_seq.nextval,'教学部','教学部');
commit;


--创建表job
CREATE TABLE jobTable (
  jobId number(11) NOT NULL,
  jobName VARCHAR(50) NOT NULL,
  jobDesc VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (jobId)
);
create sequence job_seq
start with 0
minvalue 0
increment by 1;

INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'职员','职员');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'Java开发工程师','Java开发工程师');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'Java中级开发工程师','Java中级开发工程师');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'Java高级开发工程师','Java高级开发工程师');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'系统管理员','系统管理员');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'架构师','架构师');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'主管','主管');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'经理','经理');
INSERT  INTO jobTable(jobId,jobName,jobDesc) VALUES (job_seq.nextval,'总经理','总经理');
commit;



--#创建表employee
CREATE TABLE employeeTable (
  employeeId number(11) NOT NULL,
  deptId number(11) NOT NULL,
  jobId number(11) NOT NULL,
  employeeName VARCHAR(20) NOT NULL,
  employeeCardId VARCHAR(18) NOT NULL,
  employeeAddress VARCHAR(50) NOT NULL,
  employeePostCode VARCHAR(50) DEFAULT NULL,
  
  employeePhone VARCHAR(11) NOT NULL,
  employeeQQ VARCHAR(10) DEFAULT NULL,
  employeeEmail VARCHAR(50) NOT NULL,
  employeeSex VARCHAR(11) NOT NULL,
  employeeParty VARCHAR(10) DEFAULT NULL,
  employeeBirthday TIMESTAMP DEFAULT NULL,
  employeeRace VARCHAR(100) DEFAULT NULL,
  employeeEducation VARCHAR(10) DEFAULT NULL,
 
  employeeHobby VARCHAR(100) DEFAULT NULL,
  
  employeeCreateDate TIMESTAMP NOT NULL,
  PRIMARY KEY (employeeId),
  CONSTRAINT FK_EMP_DEPT FOREIGN KEY (deptId) REFERENCES deptTable (deptId),
  CONSTRAINT FK_EMP_JOB FOREIGN KEY (jobId) REFERENCES jobTable (jobId)
);

alter table employeeTable 
add constraint fk_dept foreign key (deptId) 
references deptTable (deptId);

create sequence employee_seq
start with 0
minvalue 0
increment by 1;
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,28,13,'爱丽丝','4328011988','广州天河','510000','13902001111','36750066','251425887@qq.com','女','党员',to_timestamp('1994-02-14','yyyy-mm-dd'),'满','本科','唱歌',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,29,14,'杰克','22623','43234','42427424','4247242','42424','251425887@qq.com','男',NULL,NULL,NULL,NULL,NULL,to_timestamp('2016-03-14 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,30,15,'bb','432801197711251038','广州','510000','13907351532','36750064','36750064@qq.com','男','党员',to_timestamp('1977-11-25','yyyy-mm-dd'),'汉','本科','爬山',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));

INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,28,16,'su','4328011988','广州天河','510000','13902001111','36750066','251425887@qq.com','女','党员',to_timestamp('1994-02-14','yyyy-mm-dd'),'满','本科','唱歌',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,29,14,'liu','22623','43234','42427424','4247242','42424','251425887@qq.com','男',NULL,NULL,NULL,NULL,NULL,to_timestamp('2016-03-14 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,30,15,'zhang','432801197711251038','广州','510000','13907351532','36750064','36750064@qq.com','男','党员',to_timestamp('1977-11-25','yyyy-mm-dd'),'汉','本科','爬山',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));

INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,31,13,'qq','4328011988','广州天河','510000','13902001111','36750066','251425887@qq.com','女','党员',to_timestamp('1994-02-14','yyyy-mm-dd'),'满','本科','唱歌',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,32,14,'mm','22623','43234','42427424','4247242','42424','251425887@qq.com','男',NULL,NULL,NULL,NULL,NULL,to_timestamp('2016-03-14 11:35:18','yyyy-mm-dd hh24:mi:ss'));
INSERT  INTO employeeTable(employeeId,deptId,jobId,employeeName,employeeCardId,employeeAddress,employeePostCode,employeePhone,employeeQQ,employeeEmail,
                            employeeSex,employeeParty,employeeBirthday,employeeRace,employeeEducation,employeeHobby,employeeCreateDate) 
VALUES (employee_seq.nextval,30,15,'gg','432801197711251038','广州','510000','13907351532','36750064','36750064@qq.com','男','党员',to_timestamp('1977-11-25','yyyy-mm-dd'),'汉','本科','爬山',to_timestamp('2017-07-31 11:35:18','yyyy-mm-dd hh24:mi:ss'));

commit;


--#创建表notice
CREATE TABLE noticeTable (
  noticeId number(11) NOT NULL,
  noticeTitle VARCHAR(50) NOT NULL,
  noticeContent VARCHAR(200) NOT NULL,
  noticeCreateDate TIMESTAMP NOT NULL ,
  userId number(11) DEFAULT NULL,
  PRIMARY KEY (noticeId),
  CONSTRAINT FK_NOTICE_USER FOREIGN KEY (userId) REFERENCES userTable (userId)
);
create sequence notice_seq
start with 0
minvalue 0
increment by 1;

insert into noticeTable VALUES(notice_seq.nextval,'招聘通知2','招聘Php工程师若干',to_timestamp('2017-02-14','yyyy-mm-dd'),1);
insert into noticeTable VALUES(notice_seq.nextval,'招聘通知3','招聘C++工程师若干',to_timestamp('2017-03-12','yyyy-mm-dd'),2);
insert into noticeTable VALUES(notice_seq.nextval,'招聘通知4','招聘C工程师若干',to_timestamp('2017-04-16','yyyy-mm-dd'),2);
insert into noticeTable VALUES(notice_seq.nextval,'招聘通知','招聘Python工程师若干',to_timestamp('2017-05-20','yyyy-mm-dd'),1);
insert into noticeTable VALUES(notice_seq.nextval,'招聘通知','招聘.Net工程师若干',to_timestamp('2017-06-11','yyyy-mm-dd'),0);
insert into noticeTable VALUES(notice_seq.nextval,'违纪处理','某某某给予警告',to_timestamp('2017-04-24','yyyy-mm-dd'),0);
commit;
select count(*) from noticeTable ;


--#创建表documentTable
CREATE TABLE documentTable (
  documentId number(11) NOT NULL,
  documentTitle VARCHAR(50) NOT NULL,
  fileName VARCHAR(300) NOT NULL,
  documentDesc VARCHAR(300) DEFAULT NULL,
  documentCreateDate TIMESTAMP NOT NULL,
  userId number(11) DEFAULT NULL,
  PRIMARY KEY (documentId),
  CONSTRAINT FK_DOCUMENT_USER FOREIGN KEY (userId) REFERENCES userTable (userId)
);
create sequence document_seq
start with 0
minvalue 0
increment by 1;
