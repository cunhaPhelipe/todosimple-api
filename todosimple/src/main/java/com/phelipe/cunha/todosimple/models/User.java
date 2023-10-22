package com.phelipe.cunha.todosimple.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    public static final String TABLE_NAME = "user";
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size (groups = CreateUser.class, min = 2, max = 100)
    private  String username;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 50, nullable = false)
    @NotNull(groups = {CreateUser.class,UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size (groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 50)
    private  String password;

//    private List<Task> tasks = new ArrayList<Task>();

    public User(){

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (this.id == null)
			if (other.id == null)
				return false;
			else if (!this.id.equals(other.id)) {
				return false;

			}
		return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.password, other.getPassword());

	}

	@Override
	public int hashCode() {
		final  int prime = 31;
		int result = 1;
		result = prime + result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}
}