package it.academy.servlet;

import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Locale;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/product",
                    "root",
                    "1234"
            );
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select ps.id, ps.product_name, psp.product_spec_price \n" +
                    "from product_spec as ps,product_spec_price as psp\n" +
                    "where ps.id=psp.id;");
            final PrintWriter writer = resp.getWriter();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                System.out.println("id="+id+" name="+ name+ " price="+price);
                writer.println("id="+id+" name="+ name+ " price="+price);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
