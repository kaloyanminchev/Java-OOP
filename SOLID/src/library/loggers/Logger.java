package library.loggers;

import library.appenders.Appender;

public interface Logger {
    void logInfo(String time, String message);

    void logWarning(String time, String message);

    void logError(String time, String message);

    void logCritical(String time, String message);

    void logFatal(String time, String message);

    void addAppender(Appender appender);
}
