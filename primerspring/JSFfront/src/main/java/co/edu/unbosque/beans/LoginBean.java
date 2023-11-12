package co.edu.unbosque.beans;


import java.util.List;

import co.edu.unbosque.util.AESUtil;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String saludo = "";
	private String nombre = "";
	private String contrase = "";
	
	private String newName="";
	private String newGrade1="";
	private String newGrade2="";
	private String newGrade3="";
	private String average;
	
	//List<User> products;
	//UserService serv;
    //private List<Product> products;
    //private ProductService service;


	
	public LoginBean() {
		//serv=new UserService();
		//products=serv.getAll();
        //Sproducts = service.getProducts(5);

	}

	// https://mkyong.com/java/how-to-send-http-request-getpost-in-java/

	public String getContrase() {
		return contrase;
	}

	public void setContrase(String contrase) {
		this.contrase = contrase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewGrade1() {
		return newGrade1;
	}

	public void setNewGrade1(String newGrade1) {
		this.newGrade1 = newGrade1;
	}

	public String getNewGrade2() {
		return newGrade2;
	}

	public void setNewGrade2(String newGrade2) {
		this.newGrade2 = newGrade2;
	}

	
	
	public String getNewGrade3() {
		return newGrade3;
	}

	public void setNewGrade3(String newGrade3) {
		this.newGrade3 = newGrade3;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showSticky() {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_INFO, 
				"Sticky Message", 
				"Message Content")
		);
	}
	public void errorMessage(String content) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", content));
	}
	public void infoMessage(String content) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", content));
	}
	public void warningMessage(String content) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning:", "Message Content"));
	}

	public boolean containsNumbers(String text) {
		String temporal=text.toLowerCase();
		String let="qwertyuiopñlkjhgfdsazxcvbnméýúíóá ";
		
		for (int i = 0; i < let.length(); i++) {
			String cha=String.valueOf(let.charAt(i));
		temporal=temporal.replaceAll(cha, "");
		}
		if(!temporal.equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void validate() {
		showSticky();
	}
	
	public void matchGradewords() {
		
	}
	private String calculateAverage(String newGrade1, String newGrade2, String newGrade3){
		
		return "";
	}
	public void create() {
		boolean error=false;
		average=calculateAverage(newGrade1, newGrade2, newGrade3);
		//System.out.println(average);
		if(newName==""||newGrade1==""||newGrade2==""||newGrade2=="") {
			errorMessage("asegurese de llenar todos los campos");
			error=true;
		}
			try {
			Integer.parseInt(newGrade1);
			Integer.parseInt(newGrade2);
			Integer.parseInt(newGrade3);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				errorMessage("Por favor, recuerde que las notas no contienen letras");
				error=true;
				return;
				
			}
			if (containsNumbers(newName)==true) {
				errorMessage("Por favor, digite un nombre sin números ni carácteres especiales");
				error=true;
			}
			if (newName.length()==1) {
				errorMessage("Por favor, digite un nombre válido");
				error=true;
			}
		if(error==false) {
		String acerage=String.valueOf(newGrade1);
		newName=AESUtil.encrypt(newName);
		newGrade1=AESUtil.encrypt(newGrade1);
		newGrade2=AESUtil.encrypt(newGrade2);
		newGrade3=AESUtil.encrypt(newGrade3);
		
		//serv.createEncrypted(newName, newGrade1, newGrade2, newGrade3);
		
		infoMessage("Agregado correctamente");

	}
	}
	//public String show() {
		
	//}
}
