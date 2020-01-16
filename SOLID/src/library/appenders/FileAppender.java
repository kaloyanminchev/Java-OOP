package library.appenders;

import library.layouts.Layout;
import library.utils.FileStorage;

public class FileAppender extends AppenderImpl{
    private FileStorage logFile;

    public FileAppender(Layout layout, FileStorage fileStorage) {
        super(layout);
        this.logFile = fileStorage;
    }

    @Override
    public void append(String time, String reportLevel, String message) {
        this.incrementMessagesCount();
        this.logFile.write(this.getLayout().format(time, reportLevel, message));
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.logFile.getSize();
    }
}
