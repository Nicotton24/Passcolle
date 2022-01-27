package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchDao {
	public List<PassEntity> getUserData(String tmpId) {

			PassEntity ue = null;

			List<PassEntity> peList = new ArrayList<>();


			//例外処理
			try {
				//JDBCのドライバーをロード。
				Class.forName("com.mysql.cj.jdbc.Driver");

				//データベースへの接続
				//?をつけ文字コード、サーバーのタイムゾーンを記載してあげる。
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_passcolle?characterEncoding=UTF-8&serverTimezone=JST",  "root", "root");

				PreparedStatement ps = con.prepareStatement("SELECT * FROM passmanagementkey where Name LIKE ?");

				//第一引数が位置
				ps.setString(1,tmpId + "%");

				ResultSet rs = ps.executeQuery();

				//結果を取り出す
				while(rs.next())  {
					ue = new PassEntity();
					
					ue.setName(rs.getString("name"));
					ue.setId(rs.getString("id"));
					ue.setPass(rs.getString("pass"));
					peList.add(ue);

				}

				//データベースのコネクションを開放する
				con.close();
				ps.close();
				rs.close();

			}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			//戻り値
			return peList;

	}

}
