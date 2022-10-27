package common;

public class member_DTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public member_DTO() {
		
	}

	public member_DTO(String id, String pass, String name, String regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "member_DTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}
	
	
	
}