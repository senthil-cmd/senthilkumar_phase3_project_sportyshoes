package com.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Brand;
import com.bean.PurchaseReport;

@Repository
public interface PurchaseReportDao extends CrudRepository<PurchaseReport,Integer> {

}
