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
import model.UserBean;
import model.UserCheck;

/**
 * Servlet implementation class LoginController1
 */
@WebServlet("/logincontroller")
public class LoginController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController1() {
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
		String id = "";

		//ユーザが入力したデータ取得(IDとパスワード)
		String chId =request.getParameter("user");
		String chPass =request.getParameter("pass");

		//UserCheckクラスを利用してIDとパスワードをチェック
		UserCheck uc = new UserCheck();
		UserBean ub = uc.idPassCheck(chId,chPass);

		//PassDaoクラスのgetUserDataメソッド実行
		PassDao ud = new PassDao();
		List<PassEntity> ue = ud.getUserData();

		//コンテキストを取得
		ServletContext con = request.getServletContext();

		//移動先のページ設定
		RequestDispatcher rd;

		//セッションスコープの準備
		HttpSession session = request.getSession();

		//判定
		if (ub != null) {
			//ホーム画面へ
			//セッションスコープの有効期限を設定(3分間）
			session.setMaxInactiveInterval(180);
			//セッションへユーザ登録
			session.setAttribute("userbean", ub);

			session.setAttribute("userentity", ue);
			request.setAttribute("searchbox", id);

			rd = con.getRequestDispatcher("/homepage.jsp"); //仮ページ設定してるよ(ここにホームページ設定する）
		}else {
			//ログイン失敗画面へ
			rd = con.getRequestDispatcher("/loginNGform.jsp");
		}

		//処理転送
		rd.forward(request,response);

	}

}
