package model;

public class DeleteEntity {

	//メンバー変数
	private String name;
	private String id;
	private String pass;

	public DeleteEntity() {
		setName("");
		setId("");
		setPass("");
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
