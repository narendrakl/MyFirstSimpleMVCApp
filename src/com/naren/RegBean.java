package com.naren;

public class RegBean {
	
	
	String uname, email, pwd, rpwd;
	
	public  RegBean(){
		System.out.println("Inside no arg consrtuctor of RegBean");
	}

	public String getUname() {
		System.out.println("Inside get uname");
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("Inside set uname");
		this.uname = uname;
	}

	public String getEmail() {
		System.out.println("Inside get email");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Inside set email");
		this.email = email;
	}

	public String getPwd() {
		System.out.println("Inside get pwd");
		return pwd;
	}

	public void setPwd(String pwd) {
		System.out.println("Inside set pwd");
		this.pwd = pwd;
	}

	public String getRpwd() {
		System.out.println("Inside get rpwd");
		return rpwd;
	}

	public void setRpwd(String rpwd) {
		System.out.println("Inside set rpwd");
		this.rpwd = rpwd;
	} 

	public String validate(){
		
		String msg="";
		if(uname==null || uname.trim().equals("")){
			System.out.println("user name is blank");
			return msg="your user name field is blank";
		}
		if(email==null || email.trim().equals("")){
			System.out.println("email is blank");
			return msg=msg+"Boss ur email field is empty";
		}
		if(pwd==null || pwd.trim().equals("")){
			System.out.println("pwd is blank");
			return msg=msg+"Your password is blank";
		}
		if(rpwd==null || rpwd.trim().equals("") || !rpwd.equals(pwd)){
			System.out.println("pwds does not match");
			return msg="pwds does not match";
		}
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
}
