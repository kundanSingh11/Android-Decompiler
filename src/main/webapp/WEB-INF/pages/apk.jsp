<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<!-- <form method="POST" action="apkUpload" enctype="multipart/form-data">
		File to upload: <input type="file" name="file" accept=".apk" required><br />
		<br /> <input type="submit" value="Upload"> Press here to
		upload the file!
	</form> -->

	<div class="page-content">
		<div class="page-header">
			<h1 style="text-align: center">Android Apk decompiler</h1>
		</div>
		<!-- /.page-header -->



		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->


				<div class="row centered">
					<!-- <ins class="adsbygoogle"
						style="display: inline-block; width: 728px; height: 90px"
						data-ad-client="ca-pub-7898304081367697" data-ad-slot="7946652965"></ins> -->
				</div>

				<form enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/apkUpload"
					accept-charset="UTF-8" method="post">
					<div class="row">
						<div class="col-xs-12">
							<h3 class="header smaller lighter blue">
								<i class="icon-cloud-upload"></i> Decompile Apk and Dex Android
								files to Java
							</h3>

							<div class="row">
								<div class="col-xs-12 col-md-5">
									<div class="row centered">
										<!-- <ins class="adsbygoogle"
											style="display: inline-block; width: 300px; height: 250px"
											data-ad-client="ca-pub-7898304081367697"
											data-ad-slot="1161539764"></ins> -->
									</div>
								</div>

								<div class="col-xs-12 col-md-7">
									<div class="row">
										<div class="well">
											<input class="btn btn-info btn-sm ace"
												accept=".apk,.dex,.jar,.class" type="file" name="file"
												id="upload_datafile" />
											</p>

											<button name="button" type="datafile"
												class="btn btn-info icon-cloud-upload bigger-110">
												Upload and Decompile</button>

											<!-- +1. -->
											<br /> <br />
										</div>
										<!-- /well -->
									</div>
									<!-- /row -->

									<div class="row">
										<div class="well">
											<div class="control-group">
												<label class="control-label bolder blue">Select a
													decompiler</label> <br />


												<div class="radio">
													<label> <input type="radio" name="selected_type"
														value=jadx class="ace" checked /> <span class="lbl">
															Jadx decompiler for Android</span>
													</label>
												</div>
											</div>
										</div>
										<!-- /well -->
									</div>
									<!-- /row -->
								</div>
								<!-- /span -->
							</div>
							<!-- /row -->
						</div>
						<!-- /col -->
					</div>
					<!-- /row -->
				</form>




				<div class="row">
					<div class="col-xs-12 col-sm-5"></div>
					<div class="col-xs-12 col-sm-7">
						<h5>
							<i class="icon-bell blue"></i> apktool
						</h5>
						If you need to extract and decode resources to nearly original
						form, use <strong>apktool</strong>: <a href="apktool.html">tool
							to extract resources from the apk</a> <br /> <br />It does not
						decompile original Java source code and <strong>works
							much faster</strong>. <br />The limit on number of jobs is <strong>not
							applicable</strong>.
					</div>
				</div>


				<div class="row">
					<h3 class="header smaller lighter blue">
						<i class="icon-bullhorn"></i> Dex and apk to Java decompiler
						online.
					</h3>
					<div class="col-xs-12 widget-container-span">
						<div class="widget-box">
							<div class="widget-header header-color-blue">
								<h5 class="smaller lighter">
									<i class="icon-mobile-phone"></i>
								</h5>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-xs-12">
											<h5>
												<i class="icon-bell blue"></i> Jadx
											</h5>
											Android application package (APK) is the package file format
											used to distribute and install application software onto
											Google's Android operating system. <br /> <br />This site
											uses a perfect open-source APK and DEX decompiler called
											Jadx: <a href="https://github.com/skylot/jadx"
												target="_blank">https://github.com/skylot/jadx/</a> <br />
											<b>Jadx decompiles .class and .jar</b> files, but also it <b>produces
												Java source code from Android Dex and Apk</b> files. <br /> <br />There
											are a lot of reasons why you would like to decompile an APK,
											to learn how an application works, to increase the security
											and complexity of your code, to analyze it ... and others. <br />
											<br />Jadx is a powerful tool for directly converting an APK
											to its original sources.<br /> <br /> In no case shall we
											(Apkdecompilers.com) or the developer of this application be
											liable for direct, indirect, special or other consequential
											damages resulting from the use of this application or from
											the application packages (APKs) decompiled with it. Use it at
											your own risk. <br />Please, only use it for legitimate
											purposes.<br> <br> How to Decompile: <br /> <br />
											<ul>
												<li>Browse and select the file you want to decompile .</li>
												<li>Click on upload and decompile.</li>
												<li>Wait for the process to file then click on the save
													button to download the decompiled .zip files</li>
												<li>Open the zip file to get the source code and
													resource files</li>
											</ul>

											<h5>
												<i class="icon-bell blue"></i> Apktool
											</h5>
											The resources in an Adroid APK file are compressed and stored
											in binary format. <br /> <br />Apktool (<a
												href="https://ibotpeaches.github.io/Apktool/">https://ibotpeaches.github.io/Apktool/</a>)
											is an instrument for reverse engineering 3rd party, closed,
											binary Android apps. It can decode resources to its original
											form. <br /> <b>You may use this website to extract and
												research assets and the manifest file</b>.
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- widget-box -->
					</div>
					<!-- /span -->
				</div>
				<!-- /row -->
				<hr />
			</div>
		</div>

		<div class="row" style="text-align: center">
			<div class="col-xs-12">
				<a href="${pageContext.request.contextPath}/privacy" target="_top">Privacy
					Policy</a>
			</div>
		</div>
	</div>
</body>
</html>
