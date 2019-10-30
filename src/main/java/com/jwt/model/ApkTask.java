package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.jwt.model.attributeconveters.ApkTaskStatus;

/**
 * @author Kundan Singh
 *
 */

@Entity
@Table(name = "ApkTask")
public class ApkTask implements Serializable {

	private static final long serialVersionUID = -3465833222286302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private boolean isapkTool;

	public boolean isIsapkTool() {
		return isapkTool;
	}

	public void setIsapkTool(boolean isapkTool) {
		this.isapkTool = isapkTool;
	}

	@Column
	private String fileName;

	@Column
	private String fileLocation;

	@Column
	private String downLoadLink;

	@Column
	private ApkTaskStatus status;

	@Column
	private boolean fileDeleted;

	@Column
	@CreationTimestamp
	private Date createDateTime;

	@Column
	@UpdateTimestamp
	private Date updateDateTime;

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isFileDeleted() {
		return fileDeleted;
	}

	public ApkTaskStatus getStatus() {
		return status;
	}

	public void setStatus(ApkTaskStatus status) {
		this.status = status;
	}

	public void setFileDeleted(boolean fileDeleted) {
		this.fileDeleted = fileDeleted;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getDownLoadLink() {
		return downLoadLink;
	}

	public void setDownLoadLink(String downLoadLink) {
		this.downLoadLink = downLoadLink;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}