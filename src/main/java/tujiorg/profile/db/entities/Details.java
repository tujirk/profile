package tujiorg.profile.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class Details {
	@Id
	@Column(name="k")
	private String key;
	@Column(name="v")
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key!=null?key.toUpperCase():key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Details [key=" + key + ", value=" + value + "]";
	}
	
}
