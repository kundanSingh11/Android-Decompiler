package com.jwt.service;

import com.jwt.model.attributeconveters.ApkTaskStatus;

public interface ApkTaskService {

	public ApkTaskStatus getTaskStatus(String taskId);

	public long submitTask(String filename, String fileLocation, boolean apkTool);

	public String getDownloadLink(String taskId);

}