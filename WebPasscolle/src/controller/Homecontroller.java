package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homecontroller
 */
@WebServlet("/homecontroller")
public class Homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homecontroller() {
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

		//ユーザが入力したデータ取得(IDとパスワード)
		String chHm =request.getParameter("home");
		String chTr =request.getParameter("touroku");
		String chSs =request.getParameter("seisei");
		String chLo =request.getParameter("logout");

		if(chHm != null ) {
			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
			//転送処理
			rd.forward(request,response);
		}else if(chTr != null){
			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/SetPassword.jsp");
			//転送処理
			rd.forward(request,response);
		}else if(chSs != null) {
			//passwordに設定
			request.setAttribute("password","");
			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/CreatePassword.jsp");
			//転送処理
			rd.forward(request,response);
		}else if(chLo != null) {
			//コンテキストを取得
			ServletContext con = request.getServletContext();
			//移動先ページ設定
			RequestDispatcher rd = con.getRequestDispatcher("/loginform.jsp");
			//転送処理
			rd.forward(request,response);
		}



	}

}
