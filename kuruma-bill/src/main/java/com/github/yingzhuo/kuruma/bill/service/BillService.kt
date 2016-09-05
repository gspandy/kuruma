package com.github.yingzhuo.kuruma.bill.service

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
interface BillService {

}
