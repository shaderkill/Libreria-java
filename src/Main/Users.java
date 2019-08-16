package Main;

public class Users {
	Object username;
	String nombreCompleto;
	String password;
	
	Users() {
	}
	
	Users(String username, String nombreCompleto, String password) {
		this.username = username;
		this.nombreCompleto = nombreCompleto;
		this.password = password;
	}
	
	String mostrarNombre() {
		return this.nombreCompleto;
	}
	
	Boolean loginUser(String pass) {
		if(pass.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
}
