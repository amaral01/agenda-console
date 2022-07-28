package dev.amaral.agendaconsole;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Person {
	private int id;
	private String name;
	private Date birthDay;
	public int getId() {
		return id;
	}
	public void setId() {
		String input;
		try {
			input = JOptionPane.showInputDialog ("Valor inteiro");
			this.id = Integer.parseInt(input);
		}catch(Exception e) {
			e.getStackTrace();			
		}
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = JOptionPane.showInputDialog ("Informe o nome");
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay() {
		String input;
		try {
			input = JOptionPane.showInputDialog ("Informe a data de nascimento");
			//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(input);  
		}catch(Exception e) {
			e.getStackTrace();			
		}
		
	}

}
