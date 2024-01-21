package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.util.SqlQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final SqlQuery sqlQuery;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sqlQuery.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(sqlQuery.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(sqlQuery.getDeleteById(), id);
    }

    public void updateUser(User user) {
        jdbc.update(sqlQuery.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }

    public User findById(int id) {
        return jdbc.query(sqlQuery.getFindById(), new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
}
