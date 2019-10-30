package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.ApkTaskDao;
import com.jwt.model.attributeconveters.ApkTaskStatus;

@Service
@Transactional
public class ApkTaskServiceImpl implements ApkTaskService {

	@Autowired
	private ApkTaskDao apkTaskDao;

	@Override
	@Transactional
	public ApkTaskStatus getTaskStatus(String taskId) {
		return apkTaskDao.getTaskStatus(taskId);
	}

	@Override
	@Transactional
	public long submitTask(String fileName, String fileLocation, boolean apktool) {
		return apkTaskDao.submitTask(fileName, fileLocation, apktool);
	}

	@Override
	@Transactional
	public String getDownloadLink(String taskId) {
		return apkTaskDao.getDownloadLink(taskId);
	}

}
