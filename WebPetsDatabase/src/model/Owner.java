/**
 * 
 */
package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="Owners")
/**
 * @author Jeremy Brannen - jrbrannen
 * 			Corry Burton  - codabu
 *CIS175
 * Mar 5, 2021
 */
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="owner_id")
	private int id;
	@Column(name="owner_name")
	private String name;
	@JoinTable(name="Pets", joinColumns = {@JoinColumn(name = "owner_id", referencedColumnName = "pet_id")})
	private Pet pet;
	
	public Owner() {
		super();
	}

	public Owner (String name) {
		super();
		this.name = name;
	}
	
	public Owner(int id, String name, Pet pet) {
		super();
		this.id = id;
		this.name = name;
		this.pet = pet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", pet=" + pet + "]";
	}

}
