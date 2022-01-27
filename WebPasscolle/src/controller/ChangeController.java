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

import model.PassChangeDao;
import model.PassChangeEntity;

/**
 * Servlet implementation class ChangeController
 */
@WebServlet("/cangecontroller")
public class ChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeController() {
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


		//nameを取り出す
		String ch = request.getParameter("Change");

		//PassChangeDaoクラスのgetChangeDataメソッドを実行
		PassChangeDao pd = new PassChangeDao();
		PassChangeEntity pe = pd.getChangeData(ch);

		HttpSession session = request.getSession();

				if(pe != null) {
					//スコープへデータ格納
					session.setAttribute("changename", pe);
				}

		//コンテキストを取得
		ServletContext con = request.getServletContext();
		//移動先ページ設定
		RequestDispatcher rd = con.getRequestDispatcher("/ChangePassword.jsp");
		//転送処理
		rd.forward(request,response);


	}

}
