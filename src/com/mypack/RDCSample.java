package com.mypack;


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.inet.report.Engine;
import com.inet.viewer.SwingReportViewer;

/**
 * This class is used by every RDC sample. It provides a Frame for the report viewer and executes the Engine. Every
 * subclass have to create and fill the engine, by implementing the abstract method <code>ceateAndFillEngine</code>. <br>
 * <br>
 * See the source-samples in package samples.rdc for a more information.
 */
public abstract class RDCSample extends JFrame implements EngineCreator {

    /**
     * Initialize the viewer and the GUI for the samples
     */
    protected void initUI() {
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
                e.getWindow().dispose();
                System.exit( 0 );
            }
        } );
        setSize( Toolkit.getDefaultToolkit().getScreenSize() );
        setVisible( true );

        // Create the viewer
        SwingReportViewer viewer = new SwingReportViewer();
        viewer.setHasGroupTree( false );

        try {
            // Set the engine to the viewer
            EngineRDCRenderData proxy = new EngineRDCRenderData( this );
            viewer.addNewReportView( proxy );
            // Add the viewer to the target frame
            getContentPane().add( BorderLayout.CENTER, viewer );

        } catch( Throwable e ) {
            e.printStackTrace();
        }
        setVisible( true );
    }

    /**
     * Abstract method to create and fill the engine for a report.
     * @param exportFmt output format
     * @return engine the engine for the specified report
     */
    @Override
    public abstract Engine createAndFillEngine( String exportFmt );
}
