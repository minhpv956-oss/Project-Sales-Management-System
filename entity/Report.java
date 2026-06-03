
package entity;

import java.util.Date;


public class Report {
    
    private String reportType;
    private Date reportDate;
    
    public Report(String reportType,Date reportDate){
       this.reportDate = reportDate;
       this.reportType = reportType;
        
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    
            
            
}
