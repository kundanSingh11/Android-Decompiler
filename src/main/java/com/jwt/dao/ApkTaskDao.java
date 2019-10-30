package com.jwt.dao;

import java.util.List;

import com.jwt.model.ApkTask;
import com.jwt.model.attributeconveters.ApkTaskStatus;

public interface ApkTaskDao {

	public ApkTaskStatus getTaskStatus(String taskId);

	public long submitTask(String FileName, String FileLocation, boolean apktool);

	public String getDownloadLink(String taskId);

	public ApkTask getTask(String taskId);

	public void updateTask(ApkTask apkTask);

	public List<ApkTask> getAllTaskForPurge();
}
