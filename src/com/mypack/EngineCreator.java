package com.mypack;


import com.inet.report.Engine;

/**
 * Interface used to create new reports and fill it with elements.
 */
public interface EngineCreator {

    /**
     * Method to create and fill the engine for a report.
     * @param exportFmt the output format (e.g. Engine.EXPORT_PDF)
     * @return the new engine for the report
     */
    public Engine createAndFillEngine( String exportFmt );

}