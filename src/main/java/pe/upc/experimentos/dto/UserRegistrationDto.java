package pe.upc.experimentos.dto;

import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

	 @NotEmpty
	    private String firstName;

	    @NotEmpty
	    private String lastmName;

	    @NotEmpty
	    private String lastpName;
	    
	    @NotEmpty
	    private String password;

	    @NotEmpty
	    private String username;

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastmName() {
	        return lastmName;
	    }

	    public void setLastmName(String lastmName) {
	        this.lastmName = lastmName;
	    }

	    public String getLastpName() {
	        return lastpName;
	    }

	    public void setLastpName(String lastpName) {
	        this.lastpName = lastpName;
	    }
	    
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	
}
