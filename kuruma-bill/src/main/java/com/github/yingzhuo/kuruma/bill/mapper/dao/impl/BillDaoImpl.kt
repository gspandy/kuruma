package com.github.yingzhuo.kuruma.bill.mapper.dao.impl

import com.github.yingzhuo.kuruma.bill.mapper.BillMapper
import com.github.yingzhuo.kuruma.bill.mapper.dao.BillDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("billDao")
open class BillDaoImpl @Autowired constructor(val billMapper: BillMapper) : BillDao {
}
