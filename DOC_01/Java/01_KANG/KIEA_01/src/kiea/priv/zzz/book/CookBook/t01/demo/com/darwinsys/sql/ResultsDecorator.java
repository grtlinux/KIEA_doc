package kiea.priv.zzz.book.CookBook.t01.demo.com.darwinsys.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ResultsDecorator
{
    PrintWriter out;
    Verbosity verbosity;

    public ResultsDecorator(PrintWriter wr, Verbosity v) {
        this.out = wr;
        this.verbosity = v;
    }

    /** Print the name of this Decorator's output format */
    public abstract String getName();

    /** Print the contents of a ResultSet */
    public abstract int write(ResultSet rs) throws IOException, SQLException;

    /** Print the resultset as a table info */
    public abstract void displayTable(String table, ResultSet rs)
        throws IOException, SQLException;

    public void printRowCount(int n) throws IOException {
        out.println("Row Count = " + n);
    }
    public void println(String line) throws IOException {
        out.println(line);
    }
    public void println() throws IOException {
        out.println();
    }
    public void print(String lineSeg) throws IOException {
        out.print(lineSeg);
    }

    public void flush() {
        out.flush();
    }

    public void setWriter(PrintWriter out) {
        this.out = out;
    }
}
