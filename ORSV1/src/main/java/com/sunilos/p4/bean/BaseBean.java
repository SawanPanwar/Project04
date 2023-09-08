package com.sunilos.p4.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Parent class of all Beans in application. It contains generic attributes.
 * 
 * @author Rays Technologies
 * @version 1.0
 * @Copyright (c) Rays Technologies
 * 
 */

public abstract class BaseBean implements Serializable, DropdownListBean, Comparable<BaseBean> {

	/**
	 * Non Business primary key à¤‡à¤¸à¤®à¥‡à¤‚ à¤¨à¥‰à¤¨ à¤¬à¤¿à¥›à¤¨à¥‡à¤¸ à¤•à¥‡
	 * à¤¸à¥�à¤Ÿà¥‹à¤° à¤•à¥€ à¤œà¤¾à¤¤à¥€ à¤¹à¥ˆ
	 */
	protected long id;

	/**
	 * Contains USER ID who created this database record. à¤‡à¤¸à¤®à¥‡à¤‚
	 * à¤°à¤¿à¤•à¥‰à¤°à¥�à¤¡ à¤•à¥�à¤°à¤¿à¤�à¤Ÿ à¤•à¤°à¤¨à¥‡ à¤µà¤¾à¤²à¥‡
	 * à¤¯à¥‚à¤œà¤° à¤•à¤¾ ID à¤¸à¥�à¤Ÿà¥‹à¤° à¤•à¤¿à¤¯à¤¾ à¤œà¤¾à¤¤à¤¾ à¤¹à¥ˆ
	 */
	protected String createdBy;

	/**
	 * Contains USER ID who modified this database record
	 */
	protected String modifiedBy;

	/**
	 * Contains Created Timestamp of database record
	 */
	protected Timestamp createdDatetime;

	/**
	 * Contains Modified Timestamp of database record
	 */
	protected Timestamp modifiedDatetime;

	/**
	 * accessor
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	@Override
	public int compareTo(BaseBean next) {
		return getValue().compareTo(next.getValue());
	}

	public void setResultset(ResultSet rs) {
		try {
			this.setId(rs.getLong(1));
			this.setCreatedBy(rs.getString(15));
			this.setModifiedBy(rs.getString(16));
			this.setCreatedDatetime(rs.getTimestamp(17));
			this.setModifiedDatetime(rs.getTimestamp(18));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
