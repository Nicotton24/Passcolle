package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteDao {
	public List<PassEntity> getUserData(String da) {

		PassEntity ue = null;

		List<PassEntity> peList = new ArrayList<>();


		try (Connection db = DriverManager.getConnection(
			      "jdbc:mysql://localhost:3306/db_passcolle?characterEncoding=UTF-8&serverTimezone=JST", "root", "root")) {
			      PreparedStatement ps = db.prepareStatement(
			        "delete from passmanagementkey where Name = ?");
			      ps.setString(1, da);
			      ps.executeUpdate();
			      ps = db.prepareStatement("select * from passmanagementkey");
			      

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
					db.close();
					ps.close();
					rs.close();

			    } catch (SQLException e) {
			      e.printStackTrace();
			    }

		//戻り値
		return peList;

	}

}
