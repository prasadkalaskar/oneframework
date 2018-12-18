package com.poc.utils;


import org.cts.hybrid.ConfigProvider.ConfigProvider;

public class AuthenticationUtil {

	public boolean isAuth;
	public String authenticationType;
	public String userName;
    public String password;

    public AuthenticationUtil() {

    }
	public AuthenticationUtil(Boolean auth) {

        if (auth){

            setIsAuth();

            if(getIsAuth()){
                setAuthenticationType();
                setUserName();
                setPassword();
            }
        }
	}

    public void setIsAuth() {
	    this.isAuth = Boolean.valueOf(ConfigProvider.loadProperty(EnvConfig.environment,"ofw", "needAuthentication"));
    }

    public boolean getIsAuth(){
        return this.isAuth;
    }

    public void setAuthenticationType() {
        this.authenticationType =  ConfigProvider.loadProperty(EnvConfig.environment,"ofw", "authType");
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setUserName() {
        this.userName = ConfigProvider.loadProperty(EnvConfig.environment,"ofw", "userName");
    }


    public String getUserName() {
		return userName;
	}

    public void setPassword() {
        this.password =  ConfigProvider.loadProperty(EnvConfig.environment,"ofw", "password");
    }

    public String getPassword() {
		return password;
	}
}
