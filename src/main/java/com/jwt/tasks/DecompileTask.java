package com.jwt.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jwt.dao.ApkTaskDao;
import com.jwt.model.ApkTask;
import com.jwt.model.ProjectConstants;
import com.jwt.model.attributeconveters.ApkTaskStatus;

@Component
@Scope("prototype")
public class DecompileTask implements Runnable {

	private ApkTask apkTask;

	@Autowired
	private ApkTaskDao apkTaskDao;

	@Override
	public void run() {
		System.out.println("Yess the pool thread called " + apkTask.getFileName());
		System.out.println("Finished call to jadx");
		apkTask.setStatus(ApkTaskStatus.RUNNING);
		apkTaskDao.updateTask(apkTask);
		try {
			executeTaskz();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Status Failed " + apkTask.getStatus());
			apkTask.setStatus(ApkTaskStatus.FAILED);
			apkTaskDao.updateTask(apkTask);
		}

		apkTask.setStatus(ApkTaskStatus.COMPLETED);
		apkTaskDao.updateTask(apkTask);
		System.out.println("Status Running " + apkTask.getStatus());
	}

	private void executeTaskz() throws Exception {
		File source = new File(apkTask.getFileLocation());
		File parent = source.getParentFile();
		File output = new File(parent,
				apkTask.getFileName() + ProjectConstants.SOURCE_FROM_ANDROID_DECOMPILERS + File.separator);
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime
				.exec(ProjectConstants.JAVA_PATH + " -jar " + ProjectConstants.APKTOOL_JAR_PATH + String.format(
						ProjectConstants.APKTOOL_AURGUMENTS, output.getAbsolutePath(), source.getAbsolutePath()));

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = null;
		System.out.println("-------------- APKTOOL -------------");
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		process.waitFor();
		if (!apkTask.isIsapkTool()) {
			process = runtime.exec(ProjectConstants.JADX_LOCATION + String.format(ProjectConstants.JADX_AURGUMENTS,
					output.getAbsolutePath(), output.getAbsolutePath(), source.getAbsolutePath()));
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			line = null;
			System.out.println("-------------- JADX -------------");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			process.waitFor();
		}
		for (File file : output.listFiles()) {
			if (file.getName().endsWith(".dex")) {
				file.delete();
			}
		}
		String outZip = output.getAbsolutePath() + ".zip";
		process = runtime.exec(ProjectConstants.Z_PATH + " a -tzip " + outZip + " " + output.getAbsolutePath());
		bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		line = null;
		System.out.println("-------------- 7z -------------");
		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
		}

		process.waitFor();
		FileUtils.deleteDirectory(output);

		for (File f : parent.listFiles()) {
			if (f.getName().endsWith(".jobf"))
				f.delete();
		}
		apkTask.setFileLocation(outZip);
	}

	public void setTask(ApkTask taskID) {
		this.apkTask = taskID;
	}

	public ApkTask getTask() {
		return this.apkTask;
	}
}
