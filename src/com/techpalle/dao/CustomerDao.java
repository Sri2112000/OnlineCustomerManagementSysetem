package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class CustomerDao 
{
		private static final String dburl="jdbc:mysql://localhost:3306/project";
		private static final String dbusername="root";
		private static final String dbpassword="admin";
		
		private static Connection con=null;
		private static PreparedStatement ps=null;
		private static Statement s=null;
		private static ResultSet rs=null;
		
		private static final String customerListQuery="select * from customer";
		private static final String insertCustomer="insert into customer (name,email,mobile) values(?,?,?)";
		private static final String customerEditQuery="select * from customer where id=?";
		private static final String customerUpdate="update customer set name=?, email=?, mobile=? where id=?";
		private static final String customerDelete="delete from customer where id=?";
		
		public static Connection getConnectionDef()
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e)  
			{
				e.printStackTrace();
			}
			return con;
		}
	
		public static ArrayList<Customer> getAllCustomer()
		{
			ArrayList<Customer> al=new ArrayList<Customer>();
			try 
			{
				con=getConnectionDef();
				s=con.createStatement();
				rs=s.executeQuery(customerListQuery);
				while(rs.next())
				{
					int i=rs.getInt("id");
					String n=rs.getString("name");
					String e=rs.getString("email");
					long m=rs.getLong("mobile");
					
					Customer c=new Customer(i,n,e,m);
					
					al.add(c);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				
					try 
				    {
						if(rs!=null)
						rs.close();
						if(s!=null)
							s.close();
						if(con!=null)
							con.close();
					} 
					catch (SQLException e) 
				    {
						e.printStackTrace();
					}
			}
			return al;	
		}
		
        public static void insertingCustomer(Customer c)
		{
			try 
			{
				con=getConnectionDef();
				ps=con.prepareStatement(insertCustomer);
				
				ps.setString(1,c.getName());
				ps.setString(2,c.getEmail());
				ps.setLong(3,c.getMobile());
				
				ps.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
					try 
					{
						if(ps!=null)
						ps.close();
						if(con!=null)
						con.close();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
		}
        
        public static Customer getCustomer(int id)
        {
        	Customer c=null;
        	try 
        	{
        		con=getConnectionDef();
				ps=con.prepareStatement(customerEditQuery);
				ps.setInt(1,id);
				
				rs=ps.executeQuery();
				
				rs.next();
				
				int i=rs.getInt("id");
				String n=rs.getString("name");
				String e=rs.getString("email");
				long m=rs.getLong("mobile");
				
				c=new Customer(i,n,e,m);
			
			}
        	catch (SQLException e) 
        	{
				e.printStackTrace();
			}
        	finally
			{
					try 
				    {
						if(rs!=null)
						rs.close();
						if(ps!=null)
							ps.close();
						if(con!=null)
							con.close();
					} 
					catch (SQLException e) 
				    {
						e.printStackTrace();
					}
			}
			return c;
        }
        public static void editCustomer(Customer c)
        {	
        	try 
        	{
        		con=getConnectionDef();
				ps=con.prepareStatement(customerUpdate);
				ps.setString(1,c.getName());
				ps.setString(2,c.getEmail());
				ps.setLong(3,c.getMobile());
				ps.setInt(4, c.getId());
				
				ps.executeUpdate();
			}
        	catch (SQLException e) 
        	{
				e.printStackTrace();
			}
        	finally
			{
					try 
					{
						if(ps!=null)
						ps.close();
						if(con!=null)
						con.close();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
        }
        public static void deleteCustomer(int id)
        {
        	
        	try 
        	{
        		con=getConnectionDef();
				ps=con.prepareStatement(customerDelete);
				ps.setInt(1,id);
				
				ps.executeUpdate();
			} 
        	catch (SQLException e) 
        	{
				e.printStackTrace();
			}
        	finally
			{
					try 
					{
						if(ps!=null)
						ps.close();
						if(con!=null)
						con.close();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
			}
        	
        }
}
