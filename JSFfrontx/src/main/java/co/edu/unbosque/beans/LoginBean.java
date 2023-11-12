package co.edu.unbosque.beans;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import co.edu.unbosque.util.AESUtil;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10)).build();
	
	private String saludo = "";
	private String nombre = "";
	private String contrase = "";
	
	private String newName="";
	private String newGrade1="";
	private String newGrade2="";
	private String newGrade3="";
	private String average;
	
	private String users = "";
	
	private String test="test";

	
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

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
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

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public static HttpClient getHttpclient() {
		return httpClient;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showBlueSticky() {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_INFO, 
				"Message:", 
				"Va pasando")
		);
	}
	public void showYellowSticky() {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_WARN, 
				"Message:", 
				"Va raspando")
				);
	}
	public void showRedSticky() {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_ERROR, 
				"Message:", 
				"Va reprobando")
				);
	}
	public void errorMessage(String content) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", content));
	}
	public void infoMessage(String content) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "users:", content));
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
	
	
	public void matchGradewords() {
		
	}
	private String calculateAverage(String newGrade1, String newGrade2, String newGrade3){
		
		return "";
	}
	/*
	public void create2() {
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
		String iv = "holamundohfooooo";
		String key = "holamundohfmmmmm";
		String average=String.valueOf(newGrade1);
		newName=AESUtil.encrypt(key, iv, newName);
		newGrade1=AESUtil.encrypt(key, iv, newGrade1);
		newGrade2=AESUtil.encrypt(key, iv, newGrade2);
		newGrade3=AESUtil.encrypt(key, iv, newGrade3);
		
		//serv.createEncrypted(newName, newGrade1, newGrade2, newGrade3);
		
		infoMessage("ffff");

	}
	}
	*/
	//public String show() {
		
	//}
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
		int suma=Integer.parseInt(newGrade1)+Integer.parseInt(newGrade2)+Integer.parseInt(newGrade3);
		int aver=suma/3;
		String average=String.valueOf(aver);
		String iv = "holamundohfooooo";
		String key = "holamundohfmmmmm";
		//String average=String.valueOf(newGrade1);
		newName=AESUtil.encrypt(key, iv, newName);
		newGrade1=AESUtil.encrypt(key, iv, newGrade1);
		newGrade2=AESUtil.encrypt(key, iv, newGrade2);
		newGrade3=AESUtil.encrypt(key, iv, newGrade3);
		
		//serv.createEncrypted(newName, newGrade1, newGrade2, newGrade3);
		
		//usersMessage("Agregado correctamente");
		System.out.println(doPost("http://localhost:8081/user/createuserjason",
				"{\"name\": \"" + newName + "\",\"grade1\": \"" + newGrade1 + "\",\"grade2\": \"" + newGrade2 + "\",\"grade3\": \"" + newGrade3 + "\",}"));
		infoMessage("Su promedio es de "+average);
		
		if(aver>3) {
			showBlueSticky();
		}
		else if(aver==3) {
			showYellowSticky();
		}
		else if(aver<3) {
			showRedSticky();
		}
		
		

	
	}
		
		
		
		

	}
/*
	public void delete() {
		System.out.println(doDelete("http://localhost:8081/user/deletebyid/{id}", id.toString()));
		usersMessage("Success");

	}
*/
	public String mostrar() {
		
		System.out.println(doGet("http://localhost:8081/user/getall"));

		users = doGet("http://localhost:8081/user/getall");
		//Message("Success");
		return users;

	}
/*
	public void update() {
		System.out.println(doPut("http://localhost:8081/user/modifyuserjason/{id}",
				"{\"userName\": \"" + newUsername + "\",\"password\": \"" + newPass1 + "\"}", id.toString()));
		usersMessage("Success");
	}
*/
	public static String doGet(String url) {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("status code -> " + response.statusCode());

		String uglyJson = response.body();
		return prettyPrintUsingGson(uglyJson);
	}

	public static String doPut(String url, String json, String id) {
		url = url.replace("{id}", id);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot")
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());
		System.out.println(response.body());
		return response.body();
	}

	public static String doDelete(String url, String id) {
		url = url.replace("{id}", id);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());

		return response.body();
	}

	public static String mostrarJason(String url) {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("status code -> " + response.statusCode());

		String uglyJson = response.body();
		return prettyPrintUsingGson(uglyJson);
	}

	public static String prettyPrintUsingGson(String uglyJson) {
		Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
		JsonElement jsonElement = JsonParser.parseString(uglyJson);
		String prettyJsonString = gson.toJson(jsonElement);
		return prettyJsonString;
	}

	public void matchPasswords() {

	}

	public static String doPost(String url, String json) {
		System.out.println(1);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;

		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());

		return response.body();
	}
}
