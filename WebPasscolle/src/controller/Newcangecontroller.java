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

import model.NewChangeDao;
import model.PassEntity;

/**
 * Servlet implementation class Newcangecontroller
 */
@WebServlet("/Newcangecontroller")
public class Newcangecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newcangecontroller() {
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


		//passを取り出す
		//古いパスワード
		String ps = request.getParameter("pass");
		//新しいパスワード
		String np = request.getParameter("Npass");
		//確認パスワード
		String vp = request.getParameter("Vpass");

		if(np.equals(vp)) {
			//ResultDaoクラスのgetResultDataメソッドを実行
			NewChangeDao nd = new NewChangeDao();
			List<PassEntity> ne = nd.getNewChangeData(np,ps);

			HttpSession session = request.getSession();

					if(ne != null) {
						//スコープへデータ格納
						session.setAttribute("changename", ne);
						session.setAttribute("UEObj", null);
					}

			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
			//転送処理
			rd.forward(request,response);
		}else{
			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
			//転送処理
			rd.forward(request,response);
		}


	}

}
