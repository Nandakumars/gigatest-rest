package com.gigaspace.gigatestrest;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FooMapper implements RowMapper<Foo> {
    @Override
    public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Foo(rs.getInt("entrynumber"),
                rs.getString("mymessage"));
    }
}
