package com.mypack;

import com.inet.config.Configuration;
import com.inet.config.ConfigurationManager;
import com.inet.report.*;

/**
 * This sample shows how to create a new report and add some database fields
 * from a stored procedure to it. The Data Source Configuration
 * "Sample Database" is necessary for this sample. You can create it using Data
 * Source Manager in i-net Designer or the Configuration Manager.
 */
public class AddDatabaseFieldsSample extends RDCSample {

	/**
	 * Creates a new report and add some database fields from a stored procedure
	 * to it.
	 * 
	 * @param exportFmt
	 *            the output format (e.g. Engine.EXPORT_PDF)
	 * @return the new engine for the report
	 */
	@Override
	public Engine createAndFillEngine(String exportFmt) {

		Engine eng = null;
		try {
			// Create an Engine for a new report

			ConfigurationManager m = ConfigurationManager.getInstance();
			Configuration c = m.get(Configuration.SCOPE_USER, "Designer_Default");
			m.setCurrent(c);

			eng = RDC.createEmptyEngine(exportFmt);

			// Fill the engine
			final DatabaseTables dbTables = eng.getDatabaseTables();
			final Fields fields = eng.getFields();

			// Define a data source
			/*
			 * Datasource ds = dbTables.createDatasource( "mydb" ); // Data
			 * Source Configuration "Sample Database" ds.setPassword("root");
			 * ds.setUsername("root");
			 */

			Datasource ds = eng.getDatabaseTables().getDatasource(0);
			ds.setDataSourceConfigurationName("mydataSource"); // name of the
																// Data Source
																// Configuration
																// that should
																// be used for
																// creation of
																// database
																// connection
			ds.setPassword("root"); // If the password is not saved in Data
									// Source Configuration
			ds.setUsername("root");

			// Define the stored procedure for the data source
			TableSource ts_Employees = ds.createTableSource("empProcedure");

			String[] columnNames = { "empid", "empname", "address1" };
			int[] columnTypes = { Field.NUMBER, Field.STRING, Field.STRING };
			for (int colIdx = 0; colIdx < columnNames.length; colIdx++) {
				ts_Employees.addColumn(columnNames[colIdx], columnTypes[colIdx]);
			}

			// Add database fields and text fields to the report
			DatabaseField dbField = null;
			Area dArea = eng.getArea("D");
			Section dSec = dArea.getSection(0);
			Area phArea = eng.getArea("PH");
			Section phSec = phArea.getSection(0);

			dbField = fields.getDatabaseField(ts_Employees.getAlias() + ".empid");
			dSec.addFieldElement(dbField, 700, 100, 1000, 200);
			Text text = phSec.addText(700, 100, 2000, 500);
			Paragraph para = text.addParagraph();
			TextPart tPart = para.addTextPart(dbField.getShortName());
			tPart.setBold(true);
			tPart.setUnderline(true);

			dbField = fields.getDatabaseField(ts_Employees.getAlias() + ".empname");
			dSec.addFieldElement(dbField, 4500, 100, 2000, 200);
			text = phSec.addText(4500, 100, 2000, 500);
			para = text.addParagraph();
			tPart = para.addTextPart(dbField.getShortName());
			tPart.setBold(true);
			tPart.setUnderline(true);

			dbField = fields.getDatabaseField(ts_Employees.getAlias() + ".address1");
			dSec.addFieldElement(dbField, 7800, 100, 2000, 200);
			text = phSec.addText(7800, 100, 2000, 500);
			para = text.addParagraph();
			tPart = para.addTextPart(dbField.getShortName());
			tPart.setBold(true);
			tPart.setUnderline(true);

		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(0);
		}
		return eng;
	}

	/**
	 * Main method of this sample
	 * 
	 * @param args
	 *            arguments not used
	 */
	public static void main(String[] args) {
		new AddDatabaseFieldsSample().initUI();
	}
}
