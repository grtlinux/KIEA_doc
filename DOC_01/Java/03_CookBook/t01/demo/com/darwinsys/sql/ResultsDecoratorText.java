package kiea.priv.zzz.book.CookBook.t01.demo.com.darwinsys.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultsDecoratorText extends ResultsDecorator
{
    public ResultsDecoratorText(PrintWriter out, Verbosity v) {
        super(out, v);
    }

    @Override
    public int write(ResultSet rs) throws IOException,SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int colCount = md.getColumnCount();
        for (int i = 1; i <= colCount; i++) {
            print(md.getColumnName(i) + "\t");
        }
        println();
        int rowCount = 0;
        while (rs.next()) {
            ++rowCount;
            for (int i = 1; i <= colCount; i++) {
                print(rs.getString(i) + "\t");
            }
            println();
        }
        return rowCount;
    }

    @Override
    public void displayTable(String table, ResultSet rs)
        throws IOException, SQLException {

        write(rs);
    }

    @Override
    public void printRowCount(int rowCount) throws IOException {
        println("Rows: " + rowCount);
    }

    /* (non-Javadoc)
     * @see ResultsDecorator#getName()
     */
    @Override
    public String getName() {
        return "Plain text";
    }
}