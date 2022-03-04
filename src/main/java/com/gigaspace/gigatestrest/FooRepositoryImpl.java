package com.gigaspace.gigatestrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("FooRepository")
public class FooRepositoryImpl implements FooRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from foo", Integer.class);
    }

    @Override
    public int insert(Foo foo) {
        return jdbcTemplate.update("INSERT INTO foo (entrynumber, mymessage) VALUES (?, ?)", foo.getEntryNumber(), foo.getMyMessage());
    }

    @Override
    public int update(Foo foo) {
        return jdbcTemplate.update("UPDATE foo SET mymessage = ? WHERE entrynumber = ?", foo.getMyMessage(), foo.getEntryNumber());
    }

    @Override
    public int deleteByNumber(Integer entryNumber) {
        return jdbcTemplate.update("delete foo where entrynumber = ?", entryNumber);
    }

    @Override
    public Foo findByNumber(Integer entryNumber) {
        try {
            return jdbcTemplate.queryForObject("select * from foo where entrynumber = ?",
                    new FooMapper(),entryNumber);
        } catch (EmptyResultDataAccessException x) {
            return null;
        }
    }

    @Override
    public List<Foo> getAll() {
        return jdbcTemplate.query("select * from foo ", new FooMapper());

    }
}
