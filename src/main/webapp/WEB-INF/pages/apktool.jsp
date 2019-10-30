<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1 style="text-align: center">Apktool - Reverse engineer
				Android apk files</h1>
		</div>
		<!-- /.page-header -->



		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->


				<div class="row centered">
					<!-- <ins class="adsbygoogle"
         style="display:inline-block;width:728px;height:90px"
         data-ad-client="ca-pub-7898304081367697"
         data-ad-slot="7946652965"></ins> -->
				</div>




				<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/apktool"
					accept-charset="UTF-8" method="post">
					<div class="row">
						<div class="col-xs-12">
							<h3 class="header smaller lighter blue">
								<i class="icon-cloud-upload"></i> Decode resources from the apk
								file to its original form
							</h3>

							<div class="row">
								<div class="col-xs-12 col-md-5">
									<div class="row centered">
										<!-- Ad view-->
									</div>
								</div>

								<div class="col-xs-12 col-md-7">
									<div class="row">
										<div class="well">
											<input class="btn btn-info btn-sm ace" accept=".apk"
												type="file" name="file" id="upload_datafile" />
											</p>

											<button name="button" type="datafile"
												class="btn btn-info icon-cloud-upload bigger-110">
												Upload and Decompile</button>

											<!-- +1. -->
											<div class="g-plusone" href="apktool.html"
												data-size="standard" data-annotation="bubble"></div>



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
														value=apktool class="ace" checked /> <span class="lbl">
															Apktool - decoding assets</span>
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
					<h3 class="header smaller lighter blue">
						<i class="icon-bullhorn"></i> Apktool online
					</h3>
					<div class="col-xs-12 widget-container-span">
						<div class="widget-box">
							<div class="widget-header header-color-blue">
								<h5 class="smaller lighter">
									<i class="icon-cog"></i>
								</h5>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-xs-12">
											<h5>
												<i class="icon-bell blue"></i> Apktool
											</h5>
											The resources in an Adroid APK file are compressed and stored
											in binary format. <br /> <br />Apktool (<a
												href="https://ibotpeaches.github.io/Apktool/">https://ibotpeaches.github.io/Apktool/</a>)
											is an instrument for reverse engineering 3rd party, closed,
											binary Android apps. It can decode resources to its original
											form. <br /> <b>You may use this website to extract and
												research assets and the manifest file</b>. To produce Java
											source code, try <a href='apk.html'>Android apk
												decompiler</a> <br /> <br />Please, only use it for legitimate
											purposes.
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
				<a href="${pageContext.request.contextPath}/privacy" target="_top">Privacy Policy</a>
			</div>
		</div>
	</div>
</body>
</html>
