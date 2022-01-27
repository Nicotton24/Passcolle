package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PassEntity;
import model.SchDao;


/**
 * Servlet implementation class Searchcontroller
 */
@WebServlet("/Searchcontroller")
public class Searchcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//コンテキストを取得
		ServletContext con = request.getServletContext();
		//移動先ページ設定
		RequestDispatcher rd = con.getRequestDispatcher("/loginform.jsp");
		//転送処理
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
				request.setCharacterEncoding("UTF-8");

				//入力されたIDを取り出す
				String id = request.getParameter("sch");

				//UserDaoクラスのgetUserDataメソッドを実行
				SchDao sd = new SchDao();
				List<PassEntity> se = sd.getUserData(id);

				//セッションスコープの準備
				HttpSession session = request.getSession();

				if(se != null&&id !=null) {
					//スコープへデータ格納
					session.setAttribute("userentity", se);
					request.setAttribute("searchbox", id);

				if(se != null ) {
					//スコープへデータ格納
					session.setAttribute("userentity", se);
				}

				//コンテキストの取得
				ServletContext con = request.getServletContext();
				//移動先のページ設定
				RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
				//転送処理
				rd.forward(request, response);
	}

}
}