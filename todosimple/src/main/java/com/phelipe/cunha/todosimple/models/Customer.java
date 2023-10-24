package com.phelipe.cunha.todosimple.models;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer {


	public interface CreateCustomer{}
	public interface UpdateCustomer{}

	public static final String TABLE_NAME = "customer";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 30)
	private  String name;


	@Column(name = "endereco", length = 100, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 2, max =  100)
	private String endereco;


	@Column(name = "complemento", length = 100, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 20)
	private String complemento;


}
