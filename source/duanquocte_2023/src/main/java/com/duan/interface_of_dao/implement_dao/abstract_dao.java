package com.duan.interface_of_dao.implement_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.duan.interface_of_dao.generic_dao;
import com.duan.mapper.row_mapper;
import com.duan.model.bang_nguoidung_model;

public class abstract_dao<T> implements generic_dao<T> {
	ResourceBundle mybundle = ResourceBundle.getBundle("db");
	public Connection getconnection() {
		try {
		
			Class.forName(mybundle.getString("driverName"));
			String url = mybundle.getString("url");
			String username =mybundle.getString("username");
			String password =mybundle.getString("password");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	@Override
	public List<T> truyvandulieu_generic(String sql, row_mapper<T> row_mapper1, Object... parameters)
	{
		List<T> ketqua=new ArrayList<>();
	  
		Connection con=null;
	    PreparedStatement tt=null;
	    ResultSet rs=null;
			try
			{
				con=getconnection();
				tt=con.prepareStatement(sql);
				setParameter(tt,parameters);
				rs=tt.executeQuery();
				while(rs.next())
				{
					ketqua.add(row_mapper1.maprow(rs));
					
				}
				return ketqua;
			}
			catch(SQLException e)
			{
				return null;
			}
			finally
			{
				try {
					if (con != null) {
						con.close();
					}
					if (tt != null) {
						tt.close();
					}
					if (rs != null) {
						rs.close();
					}
					
				} catch (SQLException e)
				{
					return null;
				}
			}			
	}
	private void setParameter(PreparedStatement tt, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					tt.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					tt.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					tt.setInt(index, (Integer) parameter);
				}else if (parameter instanceof Float) {
					tt.setFloat(index, (Float) parameter);
				}else if (parameter instanceof Date) {
					tt.setDate(index, (Date) parameter);
				}else if (parameter instanceof Timestamp) {
					tt.setTimestamp(index, (Timestamp) parameter);
				}else if (parameter ==null) {	
					tt.setNull(index,Types.NULL );
				}



			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int themdulieu_generic(String sql, Object... parameters) {
		// TODO Auto-generated method stub con cặc lỏ
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement tt=null;
		try
		{
			int manguoidung=0;
			con=getconnection();
			con.setAutoCommit(false);
			tt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(tt, parameters);
			tt.executeUpdate();
			rs=tt.getGeneratedKeys();
			if(rs.next())
			{
				manguoidung=rs.getInt(1);
			}
			con.commit();
			return manguoidung;
		}
		catch(SQLException e)
		{
			if(con!=null)
			{
				try
				{
					con.rollback();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
        
		}
		finally
		{
			try {
				if (con != null) {
					con.close();
				}
				if (tt != null) {
					tt.close();
				}
				if (rs != null) {
					rs.close();
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public void capnhatdulieu_generic(String sql, Object... parameters) {
		// TODO Auto-generated method stub con cặc lỏ
				ResultSet rs=null;
				Connection con=null;
				PreparedStatement tt=null;
				try
				{
					con=getconnection();
					con.setAutoCommit(false);
					tt=con.prepareStatement(sql);
					setParameter(tt, parameters);
					tt.executeUpdate();
					con.commit();
				}
				catch(SQLException e)
				{
					if(con!=null)
					{
						try
						{
							con.rollback();
						}
						catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
	            
				}
				finally
				{
					try {
						if (con != null) {
							con.close();
						}
						if (tt != null) {
							tt.close();
						}
						if (rs != null) {
							rs.close();
						}
						
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				
		
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection con=null;
	    PreparedStatement tt=null;
	    ResultSet rs=null;
			try
			{
				int count =0;
				con=getconnection();
				tt=con.prepareStatement(sql);
				setParameter(tt,parameters);
				rs=tt.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
				}
				return count;
			}
			catch(SQLException e)
			{
				return 0;
			}
			finally
			{
				try {
					if (con != null) {
						con.close();
					}
					if (tt != null) {
						tt.close();
					}
					if (rs != null) {
						rs.close();
					}
					
				} catch (SQLException e)
				{
					return 0;
				}
			}	
		
	}

	

}
