package com.jwt.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.management.Attribute;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.ApkTask;
import com.jwt.model.ProjectConstants;
import com.jwt.model.attributeconveters.ApkTaskStatus;
import com.jwt.service.ApkTaskService;

@Controller
public class ApkController {

	private static final Logger logger = Logger.getLogger(ApkController.class);

	@Autowired
	ApkTaskService apkTaskService;

	public ApkController() {
		System.out.println("ApkController()");
	}

	@RequestMapping(value = "/apkUpload", method = RequestMethod.GET)
	public ModelAndView apkDecompile() {
		return new ModelAndView("apk", "", "");
	}

	@RequestMapping(value = "/apkUpload", method = RequestMethod.POST)
	public Object upload(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		if (!ServletFileUpload.isMultipartContent(request)) {
			return new ModelAndView("preprocess", "msg", "Please don't fuck with the request");
		}

		try {
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator iter = upload.getItemIterator(request);
			File taskHome = new File(ProjectConstants.UPLOAD_FILE_PATH,
					System.currentTimeMillis() + "" + File.separator);

			if (!taskHome.exists()) {
				taskHome.mkdirs();
			}

			File file = null;

			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName().replaceAll(" ", "_");
				InputStream stream = item.openStream();
				if (!item.isFormField()) {
					String filename = item.getName().replaceAll(" ", "_");
					file = new File(taskHome, filename);
					if (!isFileSupported(getFileExtension(file.getName()))) {
						return new ModelAndView("preprocess", "msg", "Error !!! Please Select .dex, .jar or .apk file "
								+ getFileExtension(file.getName()) + " is not Supported");
					}
					OutputStream out = new FileOutputStream(file);
					IOUtils.copy(stream, out);
					stream.close();
					out.close();

					long taskId = apkTaskService.submitTask(file.getName(), file.getAbsolutePath(), false);
					Map<String, String> map = new HashMap<>();
					response.addCookie(new Cookie("taskId", String.valueOf(taskId)));
					response.addCookie(new Cookie("fileName", file.getName()));
					response.addCookie(new Cookie("decompiler", "jadx"));

					return "redirect:/processing";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("preprocess", "msg", "Unable to do shit try again later");
	}

	@RequestMapping(value = "/apktool", method = RequestMethod.POST)
	public Object uploadApkTool(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new ModelAndView("preprocess", "msg", "Please don't fuck with the request");
		}

		try {
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator iter = upload.getItemIterator(request);
			File taskHome = new File(ProjectConstants.UPLOAD_FILE_PATH,
					System.currentTimeMillis() + "" + File.separator);

			if (!taskHome.exists()) {
				taskHome.mkdirs();
			}

			File file = null;

			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName().replaceAll(" ", "_");
				;
				InputStream stream = item.openStream();
				if (!item.isFormField()) {
					String filename = item.getName().replaceAll(" ", "_");
					file = new File(taskHome, filename);
					if (!isFileSupported(getFileExtension(file.getName()))) {
						return new ModelAndView("preprocess", "msg", "Error !!! Please Select .dex, .jar or .apk file "
								+ getFileExtension(file.getName()) + " is not Supported");
					}
					OutputStream out = new FileOutputStream(file);
					IOUtils.copy(stream, out);
					stream.close();
					out.close();

					long taskId = apkTaskService.submitTask(file.getName(), file.getAbsolutePath(), true);
					Map<String, String> map = new HashMap<>();
					response.addCookie(new Cookie("taskId", String.valueOf(taskId)));
					response.addCookie(new Cookie("fileName", file.getName()));
					response.addCookie(new Cookie("decompiler", "ApkTool"));

					return "redirect:/processing";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("preprocess", "msg", "Unable to do shit try again later");
	}

	@RequestMapping(value = "/processing")
	public ModelAndView processing(@CookieValue(value = "fileName", defaultValue = "") String fileName,
			@CookieValue(defaultValue = "-1", value = "taskId") String taskId,
			@CookieValue(value = "decompiler", defaultValue = "jadx") String decompiler) {

		Map<String, String> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("taskId", taskId);
		map.put("decompiler", decompiler);

		// andView.addAllObjects(map);
		return new ModelAndView("/processing", "map", map);
	}

	private boolean isFileSupported(String fileExtension) {
		return ProjectConstants.SUPPORTED_FILE.contains(fileExtension);
	}

	private String getFileExtension(String name) {
		if (name.lastIndexOf(".") != -1) {
			System.out.println("extansion " + name.substring(name.lastIndexOf(".")));
			return name.substring(name.lastIndexOf("."));
		}
		return "";
	}

	@RequestMapping(value = "/taskStatus", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTaskStatus(String id, HttpServletResponse responce) {
		responce.setHeader("Content-Type", "application/json");
		System.out.println("called ");
		ApkTaskStatus apkTaskStatus = apkTaskService.getTaskStatus(id);
		return String.format("{\"jobstatuscode\":%d,\"jobstatus\":\"%s\"}", apkTaskStatus.ordinal(),
				apkTaskStatus.toString());
	}

	@RequestMapping(value = "/")
	public ModelAndView show(ModelAndView andView) {
		andView.setViewName("apk");
		return andView;
	}

	@RequestMapping(value = "/privacy")
	public ModelAndView privacy(ModelAndView andView) {
		andView.setViewName("privacy");
		return andView;
	}

	@RequestMapping(value = "/apktool")
	public ModelAndView apktool(ModelAndView andView) {
		andView.setViewName("apktool");
		return andView;
	}

	@RequestMapping(value = "/termsAndConditions")
	public ModelAndView termandcondiation(ModelAndView andView) {
		andView.setViewName("termandcondiation");
		return andView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView result(@CookieValue(value = "taskId", defaultValue = "-1") String taskId,
			@CookieValue(value = "fileName") String fileName) {
		Map<String, String> map = new HashMap<>();
		ApkTaskStatus apkTaskStatus = apkTaskService.getTaskStatus(taskId);
		map.put("status", apkTaskStatus.toString());
		map.put("fileName", fileName);
		map.put("download", taskId);
		return new ModelAndView("/result", "map", map);
	}

	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET, produces = "application/zip")
	@ResponseBody
	public FileSystemResource result(@PathVariable("id") String id, HttpServletResponse httpServletResponse) {
		File file = new File(apkTaskService.getDownloadLink(id));
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		return new FileSystemResource(file);
	}

	@RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
	public String getFavicon(HttpServletResponse re) {
		return "/favicon.ico";
	}

	@RequestMapping(value = "googlee237902653f5fbf0", method = RequestMethod.GET)
	public String reString() {
		return "/googlee237902653f5fbf0";
	}
}
