/**
 * 
 */
package com.mypack;

/**
 * @author vrane
 *
 */
import java.io.FileOutputStream;

import com.inet.config.Configuration;
import com.inet.config.ConfigurationManager;
import com.inet.report.Datasource;
import com.inet.report.Engine;
import com.inet.report.StandaloneConfiguration;
import com.inet.viewer.props.DefaultSetting;

/**
 * This example shows how to export a report in a PDF file on the server-side or
 * in a standalone application. The generated report data (PDF format) is
 * directly written to the disk. If the program is invoked with a parameter
 * --use-stdout then the output is written to stdout instead. In case you want
 * to use the report engine in combination with a viewer, please see two
 * examples: a) ../viewer/EngineInAnApplet.java shows how to connect the viewer
 * to the engine directly via a JAVA interface (RenderData). This example
 * assumes that the viewer and the report engine run in the same process (
 * "fat client"). b) ./ListenerWithMyReportProperties.java shows how to connect
 * the viewer to the (remote-) engine via a TCP/IP socket. On Unix this program
 * can be used as follows: java ProgrammingTheEngine --use-stdout | pdf2ps | lpr
 * -P<printer> to directly print the generated PDF output.
 */
public class ProgrammingTheEngine {

	private static boolean useStdout = false;
	private static String reportFile = "file:D:/emp.rpt";

	/**
	 * Prints the usage hints for this program to the standard error and
	 * terminates it.
	 */
	static void usage() {
		System.err.println("Usage: ProgrammingTheEngine [--use-stdout]");
		System.exit(1);
	}

	/**
	 * Checks if parameter values has been set.
	 * 
	 * @param args
	 *            first parameter is stdout, second parameter is report file URL
	 */
	static void getOpt(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("--use-stdout")) {
				useStdout = true;
				System.err.println("writing PDF file to stdout");
			} else if (args[i].equals("--report")) {
				reportFile = args[++i];
			} else {
				usage();
			}
		}
	}

	/**
	 * Executes a report and exports it to PDF.
	 * 
	 * @param args
	 *            first parameter is stdout, second parameter is report file URL
	 */
	public static void main(String[] args) {
		getOpt(args);

		try {
			
			// Create an engine -> PDF export

			ConfigurationManager m = ConfigurationManager.getInstance();
			Configuration c = m.get(Configuration.SCOPE_USER, "Designer_Default");
			m.setCurrent(c);
			Engine engine = new Engine(Engine.EXPORT_PDF);

			// Set the report file
			engine.setReportFile(reportFile);

			// At this point you can change the default values from the rpt
			// file, e.g.:
			// Change Data Source Configuration - Use another database at
			// runtime as at design time
			Datasource ds = engine.getDatabaseTables().getDatasource(0);
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
			
			// Set Parameter Field values
			engine.setPrompt("-1", 0);
			engine.setPrompt("['promptval2']", 1);
			engine.setPrompt("promptval3", 2);
			engine.setPrompt("Date(1899,11,31)", 3);
			engine.setPrompt("Date(3000,11,31)", 4);

			// Start the report execution
			engine.execute();

			// Open the output file and save the data in a PDF file or in
			// standard out
			java.io.OutputStream pdfFile;
			if (useStdout) {
				pdfFile = System.out;
			} else {
				pdfFile = new FileOutputStream("D://sample1.pdf");
			}

			// Request all report pages from the engine
			for (int i = 1; i <= engine.getPageCount(); i++) {
				pdfFile.write(engine.getPageData(i));
			}
			if (useStdout) {
				pdfFile.flush();
			} else {
				pdfFile.close();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(0);
	}
}
