package model;

import java.io.Serializable;

public class UserBean implements Serializable{
	private static final long seriaVersionUID = 1L;

	private String id;
	private String name ;

	//コンストラクタ
	public UserBean() {
		id="";
		name="";
	}

	//アクセサメソッド
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
