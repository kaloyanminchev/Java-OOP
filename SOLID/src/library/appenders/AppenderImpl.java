package library.appenders;

import library.enums.ReportLevel;
import library.layouts.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.appendedMessages = 0;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected void incrementMessagesCount() {
        this.appendedMessages++;
    }

    @Override
    public abstract void append(String time, String reportLevel, String message);

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.getLayout().getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.appendedMessages
        );
    }
}
