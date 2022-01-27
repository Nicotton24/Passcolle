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

import model.PassDao;
import model.PassEntity;
import model.SetPassDao;

/**
 * Servlet implementation class SetController
 */
@WebServlet("/SetController")
public class SetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetController() {
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
		//文字コード設定
		request.setCharacterEncoding("UTF-8");

		String error = null;

		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");

		SetPassDao pw = new SetPassDao();
		error=pw.setUserData(name,id,pass);

		//PassDaoクラスのgetUserDataメソッド実行
		PassDao ud = new PassDao();
		List<PassEntity> ue = ud.getUserData();

		ServletContext con = request.getServletContext();

		RequestDispatcher rd=null;

		//セッションスコープの準備
		HttpSession session = request.getSession();

		session.setAttribute("userentity", ue);

		if(error != null) {
			request.setAttribute("error",error);
			rd = con.getRequestDispatcher("/SetPassword.jsp");
		}
		else {
			rd = con.getRequestDispatcher("/homepage.jsp");
		}

		rd.forward(request, response);
	}
}
