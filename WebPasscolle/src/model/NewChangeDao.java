package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewChangeDao {

	public List<PassEntity> getNewChangeData(String Npass,String pass) {
		//初期化
		PassEntity re = null;

		List<PassEntity> pcList = new ArrayList<>();

		try {
			//JDBCドライバーをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースへの接続
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_passcolle"
					+"?characterEncoding=UTF-8&serverTimezone=JST", "root", "root");
			//SQL文を設定
			PreparedStatement ps =
					con.prepareStatement("UPDATE passmanagementkey SET Pass = AES_ENCRYPT(?, 'Passkey') WHERE Name = ?");
			ps.setString(1, Npass);
			ps.setString(2, pass);

			ps.executeUpdate();

			ps = con.prepareStatement("select * from passmanagementkey");

			//SQL文を実行
			ResultSet rs = ps.executeQuery();

			//結果を取り出す
			while(rs.next()) {
				re = new PassEntity();

				re.setName(rs.getString("name"));
				re.setId(rs.getString("id"));
				re.setPass(rs.getString("pass"));
				pcList.add(re);
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
		return pcList;






	}

}