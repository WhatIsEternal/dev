package com.test.dao;

import com.test.entity.Qx;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface QxDao {
    List<Qx> showQx();
}
