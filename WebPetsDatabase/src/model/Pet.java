/**
 * 
 */
package model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pets")
/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Feb 26, 2021
 */
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pet_id")
	private int id;
	@Column(name="pet_name")
	private String name;
	@Column(name="pet_type")
	private String type;
	@Column(name="adoption_date")
	private LocalDate adoptionDate;
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	public Pet() {
		super();
	}

	public Pet(String name, String type, LocalDate adoptionDate, Owner owner) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.adoptionDate = adoptionDate;
//		this.owner = owner;
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(LocalDate adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", adoptionDate=" + adoptionDate + "]";
	}
	
}
