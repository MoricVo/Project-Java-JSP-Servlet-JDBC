package com.duan.mapper;

import java.sql.ResultSet;

public interface row_mapper<T> {
 T maprow(ResultSet rs);
}
