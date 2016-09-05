package com.github.yingzhuo.kuruma.bill.service.impl

import com.github.yingzhuo.kuruma.bill.mapper.dao.BillDao
import com.github.yingzhuo.kuruma.bill.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("billService")
open class BillServiceImpl @Autowired constructor(val billDao: BillDao): BillService {

}
