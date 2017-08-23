package com.utn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "METODOLOGIA")
public class Metodologia {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	private String nombre;
	@ElementCollection
	private List<String> condiciones;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<String> condiciones) {
		this.condiciones = condiciones;
	}

}
