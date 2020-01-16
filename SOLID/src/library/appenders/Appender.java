package library.appenders;

import library.enums.ReportLevel;

public interface Appender {
    void append(String time, String reportLevel, String message);

    ReportLevel getReportLevel();

    void setReportLevel(ReportLevel reportLevel);
}
