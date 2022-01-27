package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassWordGenerater;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateController() {
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

		ServletContext con = request.getServletContext();

		RequestDispatcher rd;

		String pass;

		int length = Integer.parseInt(request.getParameter("length"));

		Boolean low = Boolean.valueOf(request.getParameter("low"));
		Boolean upp = Boolean.valueOf(request.getParameter("upp"));
		Boolean num = Boolean.valueOf(request.getParameter("num"));
		Boolean sign = Boolean.valueOf(request.getParameter("sign"));

		PassWordGenerater pw = new PassWordGenerater();
		pass = pw.Generater(length, low, upp, num, sign);

		request.setAttribute("password",pass);
		rd = con.getRequestDispatcher("/CreatePassword.jsp");
		rd.forward(request, response);
	}

}
