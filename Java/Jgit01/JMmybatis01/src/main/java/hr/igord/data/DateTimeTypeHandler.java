
package hr.igord.data;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeTypeHandler extends BaseTypeHandler<DateTime>{

    private static final transient Logger LOG = LoggerFactory.getLogger(DateTimeTypeHandler.class);
    
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        LOG.debug("----------------------------------------------------");
        LOG.debug("WARNING: Untested");
        LOG.debug("See: http://stackoverflow.com/questions/1071800/how-to-use-joda-time-with-java-sql-timestamp?rq=1");
        LOG.debug("----------------------------------------------------");
        ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new DateTime(rs.getTimestamp(columnName).getTime());
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new DateTime(rs.getTimestamp(columnIndex).getTime());
    }

    @Override
    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new DateTime(cs.getTimestamp(columnIndex).getTime());
    }

}
