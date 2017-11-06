package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yonyou.entity.UhDcOrdLisitem;

public interface UhDcOrdLisitemDao  extends JpaRepository<UhDcOrdLisitem,String> {

	@Query("select lisitem from UhDcOrdLisitem lisitem where lisitem.pkRepLis=:pkRepLis and lisitem.codeInstrument=:codeInstrument and lisitem.flagDel='0'")
	UhDcOrdLisitem getgetUhDcOrdLisitemByPkRepLisAndCodeInstrume(String pkRepLis, String codeInstrument);

}
