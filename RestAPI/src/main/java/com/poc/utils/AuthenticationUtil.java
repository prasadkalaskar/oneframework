package com.poc.utils;


public class AuthenticationUtil {

	public boolean isAuth;
	public String authenticationType;
	public String userName;
    public String password;

	public AuthenticationUtil() {

	    setIsAuth();

	    if(getIsAuth()){
	        setAuthenticationType();
	        setUserName();
	        setPassword();
        }

	}

    public void setIsAuth() {
        this.isAuth = Boolean.valueOf(Utilities.getFrameworkConfig("needAuthentication"));
    }

    public boolean getIsAuth(){
        return this.isAuth;
    }

    public void setAuthenticationType() {
        this.authenticationType =  Utilities.getFrameworkConfig("authType");
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setUserName() {
        this.userName =  Utilities.getFrameworkConfig("userName");
    }


    public String getUserName() {
		return userName;
	}

    public void setPassword() {
        this.password = Utilities.getFrameworkConfig("password");
    }

    public String getPassword() {
		return password;
	}
}
