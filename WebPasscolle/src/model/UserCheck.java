package model;

public class UserCheck {

	private String idDb = "admin";
	private String passDb = "password";   //とりあえず固定

	public UserBean idPassCheck(String id,String pass) {

		//戻り値初期化
		UserBean ub = new UserBean();

		if(idDb.equals(id) && passDb.equals(pass)) {

			ub.setId(id);
			ub.setName("admin");
		}else{
			ub = null;
		}
		return ub;
	}

}
