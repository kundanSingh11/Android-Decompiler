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
          <h1 style="text-align: center">
            
          </h1>
        </div><!-- /.page-header -->



        <div class="row">
          <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            

  <div class="row centered">
    <ins class="adsbygoogle"
         style="display:inline-block;width:728px;height:90px"
         data-ad-client="ca-pub-7898304081367697"
         data-ad-slot="7946652965"></ins>
  </div>



    <div class="row">
      <div class="col-xs-12">
      <h3 class="header smaller lighter blue">
        <i class="icon-bullhorn"></i>
        Decompilation Results
      </h3>
      <div class="col-xs-12 col-sm-8 col-xs-10 widget-container-span">
        <div class="widget-box">
          <div class="widget-header header-color-blue">
            <h5 class="bigger lighter">
              <i class="icon-coffee"></i>
              Decompilation Results
            </h5>
          </div>

          <div class="widget-body">
            <div class="widget-main">
              <div class="row">
                <div class="col-xs-12 col-sm-9 col-xs-6" style="text-align:center">
                  <h4 class="text-primary">File Name: ${map['fileName']}</h4>
                  <h4 class="text-primary">Decompiler: jadx</h4>
                  <h4 class="text-primary">Job status: <span id="jobstatus"> ${map['status']}.</span></h4>

                  <br/>
                  <br/>
                </div>

                <div class="col-xs-12 col-sm-3 col-xs-2" style="text-align:center">
                      <a href="${pageContext.request.contextPath}/download/${map['download']}"+>
                      <button class="btn btn-app btn-grey btn-xs radius-4">
                        <i class="icon-download bigger-160"></i>Save
                        <span class="badge badge-transparent"><i class="light-red icon-asterisk"></i>
                        </span>
                        </button></a>
                      <br/>
                </div>
              </div>
              <div style="text-align:center">
              
</div>
            </div>
          </div>
        </div>  <!-- widget-box -->
      </div><!-- /col -->

        <div class="col-xs-12 col-sm-4 col-xs-2 widget-container-span">
                <div class="row centered">
                 <!--  <ins class="adsbygoogle"
                       style="display:inline-block;width:300px;height:250px"
                       data-ad-client="ca-pub-7898304081367697"
                       data-ad-slot="1161539764"></ins> -->
                </div>
        </div>

      </div><!-- /col -->
    </div><!-- /row -->


        
<br/>

    <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/apkUpload" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="Op/IlQjFyiepV/wmdq1L0tQQohSeRdj0rhw6ZbVp2uyQsCB9stzXv11ArxN7n3o+5gVTV0DVtsxR8G0IV6fdsQ==" />
        <div class="row">
          <div class="col-xs-12">
            <h3 class="header smaller lighter blue">
              <i class="icon-cloud-upload"></i>
              
            </h3>

            <div class="row">
              <div class="col-xs-12 col-md-5">
                  <div class="row centered">
					<!-- <ins class="adsbygoogle"
						 style="display:inline-block;width:300px;height:250px"
						 data-ad-client="ca-pub-7898304081367697"
						 data-ad-slot="1161539764"></ins> -->
                  </div>
              </div>

            <div class="col-xs-12 col-md-7">
              <div class="row">			
              <div class="well">
                    <input class="btn btn-info btn-sm ace" accept=".apk,.dex,.jar,.class" type="file" name="file" id="upload_datafile" /></p>

                <button name="button" type="datafile" class="btn btn-info icon-cloud-upload bigger-110">
                    Upload and Decompile
</button>
                
    <!-- +1. -->
    <div class="g-plusone" href = "http://www.javadecompilers.com/result" data-size="standard" data-annotation="bubble"></div>



                <br/>
                <br/>
               </div><!-- /well -->	
            </div><!-- /row -->

             <div class="row">				
             <div class="well">
                <div class="control-group">
                  <label class="control-label bolder blue">Select a decompiler</label> <br/>


                      <div class="radio">
                        <label>
                          <input type="radio"  name="selected_type" value=jadx class="ace" checked/>
                          <span class="lbl"> Jadx decompiler for Android</span>
                        </label>
                      </div>
                </div>
              </div><!-- /well -->
            </div><!-- /row -->			  
            </div><!-- /span -->
            </div><!-- /row -->
          </div><!-- /col -->
        </div><!-- /row -->
</form>

<hr />
          </div>
        </div>

        <div class="row" style="text-align: center">
          <div class="col-xs-12">
            <a href="${pageContext.request.contextPath}/privacy" target="_top">Privacy Policy</a>
          </div>
        </div>
      </div><!-- /.page-content -->
</body>
</html>