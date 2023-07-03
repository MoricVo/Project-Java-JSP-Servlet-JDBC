package com.duan.interface_of_dao;

import java.util.List;

import com.duan.mapper.row_mapper;

public interface generic_dao<T>
{
List<T> truyvandulieu_generic(String sql,row_mapper<T> row_mapper1,Object... parameters);
int themdulieu_generic(String sql,Object...parameters);
void capnhatdulieu_generic(String sql,Object...parameters);
int count(String sql,Object... parameters);
}
