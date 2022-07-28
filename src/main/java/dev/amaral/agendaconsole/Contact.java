package dev.amaral.agendaconsole;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

public class Contact {
	private StringBuffer description;
	
	public Contact() {
		super();
		this.description = new StringBuffer();
		// TODO Auto-generated constructor stub
	}
	
	public void report() {
		
		JOptionPane.showMessageDialog(null,toString(),"PopUp Dialog",JOptionPane.INFORMATION_MESSAGE);
		
	}
	@Override	
	public String toString() {
		String aux;
		aux =  "Contact [description=" + description + ", id=" + id + "\n, name=" + name + "\n, address=" + address
				+ ",\n birthDate=" + birthDate + "\n, modificationDate=" + modificationDate + "\n, city=" + city
				+ "\n, zipCode=" + zipCode + "\n, phone=" + phone + "\n, cellPhone=" + cellPhone + "\n, gender=" + gender + "]";
		this.description.append(aux);
		return description.toString();
	}
	private int id;

	public String getName() {
		return name;
	}
	public void setName() {
		this.name =  JOptionPane.showInputDialog ("Informe o nome");
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress() {
		this.address = JOptionPane.showInputDialog ("Informe o endereço");
	}
	public java.util.Date  getBirthDate() {
		return birthDate;
	}
	public void setBirthDate() {
		String input;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			input = JOptionPane.showInputDialog ("Informe a data de nascimento, dd/MM/yyyy");
			
			this.birthDate = (Date) formatter.parse(input); 			
			
		}catch(Exception e) {
			e.getStackTrace();			
		}
	}
	public java.util.Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate() {		
       		
		this.modificationDate =  new Date(System.currentTimeMillis());

	}
	public String getCity() {
		return city;
	}
	public void setCity() {
		this.city = JOptionPane.showInputDialog ("Informe a cidade");
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode() {
		this.zipCode = JOptionPane.showInputDialog ("CEP");
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone() {
		this.phone = JOptionPane.showInputDialog ("Informe o telefone (47)9999-9999");
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone() {
		this.cellPhone = JOptionPane.showInputDialog ("Informe a celular (47)9999-9999");
	}
	public String getGender() {
		return gender;
	}
	public void setGender() {
		String input;
		
		do {
			input = JOptionPane.showInputDialog ("Informe o genero");
	} while(!(input.equalsIgnoreCase("m"))||(input.equalsIgnoreCase("f")));
		this.gender = input;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName() {
		this.lastName = JOptionPane.showInputDialog ("Informe o sobrenome");;
	}
	private String name;
	private String lastName;
	private String address;
	private Date birthDate;
	private Date modificationDate;
	private String city;
	private String zipCode;
	private String phone;
	private String cellPhone;
	private String gender;
	private DateTimeFormatter formato;	
}