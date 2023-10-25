package com.phelipe.cunha.todosimple.models;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "name", length = 255, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private  String name;


	@Column(name = "endereco", length = 255, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 2, max =  255)
	private String endereco;


	@Column(name = "complemento", length = 100, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 20)
	private String complemento;


	@Column(name = "numero", length = 40, nullable = true)
	@Digits(integer = 10,fraction=0)
	private String numero;

	@Column(name = "cep", length = 100, nullable = true)
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 12, message = "Informe o CEP sem o digito")
	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
