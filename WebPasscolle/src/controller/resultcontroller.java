package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ResultDao;
import model.ResultEntity;

/**
 * Servlet implementation class resultcontroller
 */
@WebServlet("/resultcontroller")
public class resultcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultcontroller() {
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
		request.setCharacterEncoding("UTF-8");

		//入力されたIDを取り出す
		String kk = request.getParameter("syID");
		String id = "";

		//UserDaoクラスのgetUserDataメソッドを実行
		ResultDao ud = new ResultDao();
		ResultEntity re = ud.getUserData(kk);

		HttpSession session = request.getSession();

				if(re != null) {
					//スコープへデータ格納
					session.setAttribute("UEObj", re);
					request.setAttribute("searchbox", id);
				}

				//コンテキストの取得
				ServletContext con = request.getServletContext();
				//移動先のページ設定
				RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
				//転送処理
				rd.forward(request, response);
	}

}
