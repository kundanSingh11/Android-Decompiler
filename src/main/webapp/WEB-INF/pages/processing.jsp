<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="page-content">
<div class="page-header">
			<h1 style="text-align: center"></h1>
		</div>
		<!-- /.page-header -->



		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->


				<div class="row centered">
				<!-- 	<ins class="adsbygoogle"
						style="display: inline-block; width: 728px; height: 90px"
						data-ad-client="ca-pub-7898304081367697" data-ad-slot="7946652965"></ins> -->
				</div>



				<div class="row">
					<div class="col-xs-12">
						<h3 class="header smaller lighter blue">
							<i class="icon-bullhorn"></i> Decompilation Results
						</h3>
						<div class="col-xs-12 col-sm-8 col-xs-10 widget-container-span">
							<div class="widget-box">
								<div class="widget-header header-color-blue">
									<h5 class="bigger lighter">
										<i class="icon-coffee"></i> Decompilation Results
									</h5>
								</div>

								<div class="widget-body">
									<div class="widget-main">
										<div class="row">
											<div class="col-xs-12 col-sm-9 col-xs-6"
												style="text-align: center">
												<h4 class="text-primary">File Name:
													${map['fileName']}</h4>
												<h4 class="text-primary">Decompiler: jadx</h4>
												<h4 class="text-primary">
													Job status: <span id="jobstatus"> Waiting in a queue</span>
												</h4>

												<br /> <br />
											</div>

											<div class="col-xs-12 col-sm-3 col-xs-2"
												style="text-align: center">
												</span><i class="icon-spinner icon-spin blue icon-5x"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- widget-box -->
						</div>
						<!-- /col -->

						<div class="col-xs-12 col-sm-4 col-xs-2 widget-container-span">
							<div class="row centered">
								<!-- <ins class="adsbygoogle"
									style="display: inline-block; width: 300px; height: 250px"
									data-ad-client="ca-pub-7898304081367697"
									data-ad-slot="1161539764"></ins> -->
							</div>
						</div>

					</div>
					<!-- /col -->
				</div>
				<!-- /row -->


				<br /> <br />
				<div class="row">
					<br />



					<form enctype="multipart/form-data" action="/upload/processfile"
						accept-charset="UTF-8" method="post">
						<div class="row">
							<div class="col-xs-12">
								<h3 class="header smaller lighter blue">
									<i class="icon-cloud-upload"></i>

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
													accept=".apk,.dex,.jar,.class" disabled="disabled"
													type="file" name="upload[datafile]" id="upload_datafile" />
												</p>

												<button name="button" type="datafile"
													class="btn btn-info icon-cloud-upload bigger-110"
													disabled="disabled">Upload and Decompile</button>

												<!-- +1. -->
												<div class="g-plusone"
													href="http://www.javadecompilers.com/processing"
													data-size="standard" data-annotation="bubble"></div>



												<br /> <br /> <span class="action-buttons"> <a
													href="http://twitter.com/home?status=http://www.javadecompilers.com/apk - Android APK Decompiler online"
													title="Share on Twitter" class="btn-twitter"
													target="_blank"> <i
														class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
														Twitter
												</a> <a
													href="https://www.facebook.com/sharer/sharer.php?u=http://www.javadecompilers.com/apk"
													title="Share on Facebook" class="btn-facebook"
													target="_blank"> <i
														class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
														Facebook
												</a> <a
													href="https://plus.google.com/share?url=http://www.javadecompilers.com/apk"
													title="Share on Google+" class="btn-googleplus"
													target="_blank"> <i class="fa fa-google-plus"></i>
														Google+
												</a> </a> <a
													href="http://www.stumbleupon.com/submit?url=http://www.javadecompilers.com/apk"
													title="Share on StumbleUpon" data-placement="top"
													class="btn-stumbleupon" target="_blank"> <i
														class="fa fa-stumbleupon"></i> Stumbleupon
												</a> </a> <a
													href="http://www.linkedin.com/shareArticle?mini=true&url=http://www.javadecompilers.com/apk/&title=Android APK Decompiler&summary=Decompile Apk and Dex Android files to Java online"
													title="Share on LinkedIn" class="btn-linkedin"
													target="_blank"> <i class="fa fa-linkedin"></i>
														LinkedIn
												</a> </a>
												</span>





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
														<label> <input type="radio" disabled
															name="selected_type" value=jadx class="ace" checked /> <span
															class="lbl"> Jadx decompiler for Android</span>
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
					<hr />
				</div>
			</div>

			<div class="row" style="text-align: center">
				<div class="col-xs-12">
					<a href="/privacy" target="_top">Privacy Policy</a>
				</div>
			</div>
		</div>
		<script type="text/javascript">
        // A $( document ).ready() block.
        $( document ).ready(function() {
            var doWork = false;
            doWork = true;
            setInterval(function(){
                if (doWork) {
                    $.ajax({
                        url:"${pageContext.request.contextPath}/taskStatus?id=${map['taskId']}", success: function (data) {
                            $("#jobstatus").html(data.jobstatus);
                            if (data.jobstatuscode == 3){
                                doWork = false;
                                window.location="${pageContext.request.contextPath}/result";
                            }else if(data.jobstatuscode>3){
                            	window.location="${pageContext.request.contextPath}/failed";
                            }
                        }, dataType: "json"
                    });
                }
            }, 3000);
        });
    </script>
</body>
</html>