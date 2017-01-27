package edu.zju.page.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.zju.page.Singer;



public class DatabaseHelper
{
	private static final String url = "jdbc:mysql://localhost:3306/QQSpider";

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

//	public static void main(String []args)
//	{
//		querySingers();
//	}
	
	public static List<Singer> querySingers()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e)
		{
			LOGGER.info("ClassForName Error : e = " + e.getMessage());
			LOGGER.info("ClassForName Error : e_stack = " + e.getStackTrace());

		} catch (IllegalAccessException e)
		{
			LOGGER.info("ClassForName Error : e1 = " + e.getMessage());
			LOGGER.info("ClassForName Error : e_stack = " + e.getStackTrace());
		} catch (ClassNotFoundException e)
		{
			LOGGER.info("ClassForName Error : e2 = " + e.getMessage());
			LOGGER.info("ClassForName Error : e_stack = " + e.getStackTrace());
		}
		List<Singer> list = new ArrayList<Singer>();
		try
		{
			Connection connection = DriverManager.getConnection(url, "root", "zhangjie");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from singers");
			while (rs.next())
			{
				LOGGER.info(rs.getString("name") + " " + rs.getString("albums") + " "
						+ rs.getString("songs") + " " + rs.getString("mvs"));
				list.add(new Singer(rs.getString("id"), rs.getString("name"),
						rs.getString("albums"), rs.getString("songs"), rs.getString("mvs")));
			}
			connection.close();
		} catch (SQLException e)
		{
			LOGGER.info("ClassForName Error : e3 = " + e.getMessage());
			LOGGER.info("ClassForName Error : e_stack = " + e.getStackTrace());
		}

		return list;
	}
}
