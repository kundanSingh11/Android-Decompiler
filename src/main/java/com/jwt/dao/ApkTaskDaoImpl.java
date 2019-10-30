package com.jwt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.ApkTask;
import com.jwt.model.attributeconveters.ApkTaskStatus;
import com.jwt.service.DecompilerService;

@Repository
@Transactional
public class ApkTaskDaoImpl implements ApkTaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DecompilerService decompilerService;

	@Override
	public ApkTaskStatus getTaskStatus(String taskId) {
		ApkTask apkTask = (ApkTask) sessionFactory.getCurrentSession().get(ApkTask.class, Long.parseLong(taskId));
		if (apkTask != null) {
			return apkTask.getStatus();
		}
		return ApkTaskStatus.NOTFOUND;
	}

	@Override
	public long submitTask(String fileName, String fileLocation, boolean apkTool) {
		ApkTask apkTask = new ApkTask();
		apkTask.setFileLocation(fileLocation);
		apkTask.setFileName(fileName);
		apkTask.setIsapkTool(apkTool);
		apkTask.setFileDeleted(false);
		apkTask.setStatus(ApkTaskStatus.SUBMITED);
		Session session = sessionFactory.getCurrentSession();
		long id = (long) session.save(apkTask);
		decompilerService.executeAsynchronously(apkTask);
		return id;
	}

	@Override
	public String getDownloadLink(String id) {
		ApkTask apkTask = (ApkTask) sessionFactory.getCurrentSession().get(ApkTask.class, Long.parseLong(id));
		if (apkTask != null && apkTask.getStatus() == ApkTaskStatus.COMPLETED && !apkTask.isFileDeleted()) {
			return apkTask.getFileLocation();
		}
		return null;
	}

	@Override
	public ApkTask getTask(String taskId) {
		ApkTask apkTask = (ApkTask) sessionFactory.getCurrentSession().get(ApkTask.class, Long.parseLong(taskId));
		return apkTask;
	}

	@Override
	public void updateTask(ApkTask apkTask) {
		sessionFactory.getCurrentSession().update(apkTask);
	}

	@Override
	public List<ApkTask> getAllTaskForPurge() {
		sessionFactory.getCurrentSession().createQuery("from ApkTask where getAllTaskForPurge<");
		return null;
	}
}
