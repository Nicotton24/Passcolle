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

import model.DeleteDao;
import model.PassEntity;

/**
 * Servlet implementation class DeleteController2
 */
@WebServlet("/deletecontroller2")
public class DeleteController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController2() {
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
		String da = request.getParameter("Delete2");


		DeleteDao dd = new DeleteDao();
		List<PassEntity> de= dd.getUserData(da);



		HttpSession session = request.getSession();

		if(de != null) {
			//スコープへデータ格納
			session.setAttribute("userentity", de);
			session.setAttribute("UEObj", null);
		}

		//コンテキストの取得
		ServletContext con = request.getServletContext();
		//移動先のページ設定
		RequestDispatcher rd = con.getRequestDispatcher("/homepage.jsp");
		//転送処理
		rd.forward(request, response);
	}

}
