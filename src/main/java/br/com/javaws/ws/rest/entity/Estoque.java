package br.com.javaws.ws.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "label")
	private String label;

	@Column(name = "description")
	private String description;

	@Column(name = "alcoolic")
	private boolean alcoolic;

	public Estoque(int codigo, String label, String description,
			boolean alcoolic) {
		super();
		this.id = codigo;
		this.label = label;
		this.description = description;
		this.alcoolic = alcoolic;
	}

	public Estoque() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAlcoolic() {
		return alcoolic;
	}

	public void setAlcoolic(boolean alcoolic) {
		this.alcoolic = alcoolic;
	}

}
