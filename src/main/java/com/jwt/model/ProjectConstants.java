package com.jwt.model;

import java.util.Arrays;
import java.util.List;

public class ProjectConstants {

	// widows configuration
	public static final String UPLOAD_FILE_PATH = "E:/uploads/";
	public static final String SOURCE_FROM_ANDROID_DECOMPILERS = "_SOURCE_FROM_ANDROID_DECOMPILERS";
	public static final List<String> SUPPORTED_FILE = Arrays.asList(".apk", ".jar", ".dex");
	public static final String JADX_LOCATION = "E:\\New folder\\jadx-0.7.1\\bin\\jadx.bat";
	public static final String JADX_AURGUMENTS = " -r -d %s -ds %s --deobf %s";
	public static final String JAVA_PATH = "C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\java.exe";
	public static final String APKTOOL_JAR_PATH = "E:\\apktool_2.3.3.jar";
	public static final String APKTOOL_AURGUMENTS = " d -s -f -o %s %s";
	public static final String Z_PATH = "C:\\Program Files\\7-Zip\\7z.exe";

	// server Configuration

	// public static final String UPLOAD_FILE_PATH = "/home/kundan/upload/";
	// public static final String SOURCE_FROM_ANDROID_DECOMPILERS =
	// "_SOURCE_FROM_ANDROID_DECOMPILERS";
	// public static final List<String> SUPPORTED_FILE = Arrays.asList(".apk",
	// ".jar", ".dex");
	// public static final String JADX_LOCATION =
	// "/home/kundan/jadx-0.7.1/bin/jadx";
	// public static final String JADX_AURGUMENTS = " -r -d %s -ds %s --deobf %s";
	// public static final String JAVA_PATH = "java";
	// public static final String APKTOOL_JAR_PATH =
	// "/home/kundan/jadx-0.7.1/apktool_2.3.3.jar";
	// public static final String APKTOOL_AURGUMENTS = " d -s -f -o %s %s";
	// public static final String Z_PATH = "7z";
}
