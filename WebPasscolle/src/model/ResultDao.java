package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDao {

	public ResultEntity getUserData(String tmpId) {
		//初期化
		ResultEntity re = null;
		try {
			//JDBCドライバーをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースへの接続
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_passcolle"
					+"?characterEncoding=UTF-8&serverTimezone=JST", "root", "root");
			//SQL文を設定
			PreparedStatement ps =
					con.prepareStatement("SELECT Name ,convert(AES_DECRYPT(Id,'Idkey')using utf8) AS Id ,convert(AES_DECRYPT(Pass,'Passkey')using utf8) AS Pass FROM passmanagementkey WHERE Name = ?");
			ps.setString(1, tmpId);

			//SQL文を実行
			ResultSet rs = ps.executeQuery();

			//結果を取り出す
			while(rs.next()) {
				re = new ResultEntity();
				
				re.setName(rs.getString("name"));
				re.setId(rs.getString("id"));
				re.setPass(rs.getString("pass"));
			}
			//データベースのコネクションを開放する
			con.close();
			ps.close();
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {


			e.printStackTrace();
		}finally {

		}

		//戻り値
		return re;






	}

}
