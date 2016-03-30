package com.mypack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class CreateWorkBook {

	public static Connection conn = null;

	// connection code -- begins
	static {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CreateWorkBook cb = new CreateWorkBook();
		

		
		//cb.getDatafromExcel();
		cb.dataRetrieve();
	}
	
	
	public void getDatafromExcel() throws Exception{
		FileInputStream fin = new FileInputStream("d://createworkbook.xlsx");

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fin);

		XSSFSheet sheet = workbook.getSheetAt(0);

		
		// List<EmpExcel> to store data

		List<EmpExcel> list = new ArrayList<EmpExcel>();

	

		

		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();// skipping header row of excel

		Iterator<Cell> cellItrator = null;
		EmpExcel empex = null;
		Cell cell = null;
		while (rowIterator.hasNext()) {

			cellItrator = (Iterator<Cell>) rowIterator.next().iterator();

			empex = new EmpExcel();

			while (cellItrator.hasNext()) {

				cell = cellItrator.next();
				switch (cell.getColumnIndex()) {

				case 0:
				
					empex.setEmpId((int) cell.getNumericCellValue());
					System.out.print((int) cell.getNumericCellValue());
					System.out.print("  ");
					break;

				case 1:
					empex.setEmpname(cell.toString());
					System.out.print(cell.toString());
					System.out.print("  ");
					break;

				case 2:
					empex.setSalary((int) cell.getNumericCellValue());
					System.out.print((int) cell.getNumericCellValue());
					System.out.print("  ");
					break;

				}

			}

			list.add(empex);

			System.out.println(" ");
		}

		pocessData(list);
		
		System.out.println("successfully insert data into database");
	}

	public static boolean isExist(int id) {
		
		System.out.println("Inside isExist method");
		int x = 0;

		try {
			Statement stmt = conn.createStatement();
			String query = "select empid from empexcel where empid=" + id;

			System.out.println("query print is "+query);
			ResultSet rs = stmt.executeQuery(query);

			/*x = rs.getRow();
			return x == 1 ? true : false;*/
			
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("inside catch block of isExist");
			e.printStackTrace();
			return false;
		}

	}

	public static void pocessData(List<EmpExcel> list) throws SQLException {
		
		String insertQuery = "INSERT INTO empexcel (empid,empname,salary) VALUES (?,?,?)";
		String  updateQuery= "UPDATE empexcel SET empname = ? ,salary =? WHERE empid = ?";
		
		// applying transaction here
		conn.setAutoCommit(false);
		
		PreparedStatement pstmtInsert = conn.prepareStatement(insertQuery);
		PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery);
		
		
		Iterator<EmpExcel> itr= list.iterator();
		
		EmpExcel empExcel= null;
		while(itr.hasNext()){
		
			empExcel= itr.next();
			if(isExist(empExcel.getEmpId())){
					
				pstmtUpdate.setString(1,empExcel.getEmpname());
				pstmtUpdate.setInt(2, empExcel.getSalary());
				pstmtUpdate.setInt(3,empExcel.getEmpId());
				pstmtUpdate.executeUpdate();			
			}
			
			else{
				
				pstmtInsert.setInt(1,empExcel.getEmpId());
				pstmtInsert.setString(2,empExcel.getEmpname());
				pstmtInsert.setInt(3,empExcel.getSalary());			
				pstmtInsert.executeUpdate();
			}	
			
		}
		conn.commit();	

	}
	
	public void dataRetrieve() throws Exception{
		try{
			EmpExcel empxl=null;
			
			
			
			//XSSFWorkbook workbook=new XSSFWorkbook();
			FileInputStream fin = new FileInputStream("d://createworkbook.xlsx");

			@SuppressWarnings("resource")
			XSSFWorkbook xworkbook = new XSSFWorkbook(fin);
			
			//Iterator itr= xworkbook.iterator();
			
			
			//int index=	xworkbook.getActiveSheetIndex();
			//System.out.println(index);
			/*while(itr.hasNext()){
			
				XSSFSheet activesheet=(XSSFSheet) itr.next();	
				String shname=activesheet.getSheetName();
				
				if(shname.equals("newEmployeeD1")){
					xworkbook.setActiveSheet(xworkbook.getSheetIndex(shname));
					
				int index=	xworkbook.getActiveSheetIndex();
				System.out.println(index);
				}
		
			}*/
						
			
			
			
			//xworkbook.setActiveSheet(xworkbook.getSheetIndex("newEmployeeDetails123222"));
			XSSFSheet sheet = xworkbook.getSheet("newEmployeeDetails123222");
			Row row= sheet.createRow(0);
			Cell cell;
			
		ArrayList<EmpExcel> list= new ArrayList<EmpExcel>();
		String query="select empid, empname, salary from empexcel";
		
		PreparedStatement pstmt= conn.prepareStatement(query);
		
		ResultSet rs= pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		for(int i=1;i<=columnCount;i++){
			//String name = rsmd.getColumnName(i);
			cell= row.createCell(i);
			cell.setCellValue(rsmd.getColumnName(i));			
		}		
		
	//	FileInputStream fin= new FileInputStream("d://createworkbook.xlsx");
		int rowcount=1;
		while(rs.next()){
			row= sheet.createRow(rowcount);
			for(int i=1;i<=columnCount;i++){
				//String name = rsmd.getColumnName(i);
				cell= row.createCell(i);
				
				switch(i){				
				case 1:
					cell.setCellValue(rs.getInt(1));	
				 break;
				case 2:
					cell.setCellValue(rs.getString(2));
					break;
				case 3:
					cell.setCellValue(rs.getInt(3));				
				}
			}		
						
			 empxl= new EmpExcel();
			empxl.setEmpId(rs.getInt(1));
			empxl.setEmpname(rs.getString(2));
			empxl.setSalary(rs.getInt(3));			
			list.add(empxl);
			
			
			rowcount++;
		}
	fin.close();
		FileOutputStream fout= new FileOutputStream("d://createworkbook.xlsx");
		xworkbook.write(fout);
		fout.close();
		
		}
		
		catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
}