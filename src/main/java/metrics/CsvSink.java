package metrics;

import java.io.*;
import java.nio.charset.StandardCharsets;

public final class CsvSink implements Closeable, Flushable {
    private final Writer out;
    public CsvSink(File file) throws IOException {
        this.out = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        this.out.write(PerformanceTracker.csvHeader());
        this.out.write("\n");
    }
    public void write(String line) throws IOException {
        out.write(line);
        out.write("\n");
    }
    @Override public void flush() throws IOException { out.flush(); }
    @Override public void close() throws IOException { out.close(); }
}
