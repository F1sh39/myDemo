package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Account;

import java.util.List;

public interface AccountMapper {

    @Insert("insert into bank_account values (null, #{name}, #{money})")
    public void save(Account account);

    @Select("select * from bank_account")
    public List<Account> findAll();
}
