package base;

import java.io.Serializable;

public class SupperTest implements Serializable{
	
	private String supperName;
	
	public SupperTest(String name) {
		this.supperName = name;
	}

	public String getSupperName() {
		return supperName;
	}

	public void setSupperName(String supperName) {
		this.supperName = supperName;
	}

}
