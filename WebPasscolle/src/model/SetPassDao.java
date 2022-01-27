package model;

//test

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SetPassDao {

	public String setUserData(String name,String id,String pass) {

		//例外処理
		try {
			//JDBCのドライバーをロード。
			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースへの接続
			//?をつけ文字コード、サーバーのタイムゾーンを記載してあげる。
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_passcolle?characterEncoding=UTF-8&serverTimezone=JST",  "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into PassManagementkey values\n"
					+"(0,?,AES_ENCRYPT(?, 'Idkey'),AES_ENCRYPT(?, 'Passkey'))");

			//第一引数が位置
			ps.setString(1,  name);
			ps.setString(2,  id);
			ps.setString(3,  pass);

			try {
				ps.executeUpdate();
			}catch(SQLIntegrityConstraintViolationException e){
				return "名前が重複";
			}

			//データベースのコネクションを開放する
			con.close();
			ps.close();

		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}