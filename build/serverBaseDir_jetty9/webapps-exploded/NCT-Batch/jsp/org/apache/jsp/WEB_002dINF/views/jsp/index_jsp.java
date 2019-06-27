package org.apache.jsp.WEB_002dINF.views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_url_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_url_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_url_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!--\n");
      out.write("\tCopyright 2017 Northeastern University\n");
      out.write("\n");
      out.write("\tLicensed under the Apache License, Version 2.0 (the \"License\");\n");
      out.write("\tyou may not use this file except in compliance with the License.\n");
      out.write("\tYou may obtain a copy of the License at\n");
      out.write("\n");
      out.write("\t  http://www.apache.org/licenses/LICENSE-2.0\n");
      out.write("\n");
      out.write("\tUnless required by applicable law or agreed to in writing, software\n");
      out.write("\tdistributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("\tWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("\tSee the License for the specific language governing permissions and\n");
      out.write("\tlimitations under the License.\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>NCTracer Batch</title>\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\"/>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${favIcon}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" rel=\"shortcut icon\" />\n");
      out.write("\n");
      out.write("<!-- c:url var=\"home\" value=\"/\" scope=\"request\" /-->\n");
      if (_jspx_meth_spring_url_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<!-- Latest compiled and minified CSS -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      if (_jspx_meth_spring_url_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mainCss}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"initRefreshLogEntries(); initWordCountPlugin(); initMatrixMultPlugin(); initFeatureExtractionPlugin(); initImageStitchingPlugin(); initImageJFilterPlugin(); initMatRegPlugin(); initMatFilterPlugin();\">\n");
      out.write("\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("\t<div class=\"row vertical-center\">\n");
      out.write("     \t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<h1>NCTracer Plug-In Development</h1>\n");
      out.write("     \t</div>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t");
      if (_jspx_meth_spring_url_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nctLogo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"NCT\" class=\"header-img\"/>\n");
      out.write("     \t</div>\n");
      out.write("   \t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container-fluid fill95\">\n");
      out.write("\t<div class=\"row fill100\">\n");
      out.write("\t\t<div id=\"canvasWrap\" class=\"col-sm-12 fill100\">\n");
      out.write("\t\t\t<label for=\"listProcMessages\">Process Messages</label>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<select multiple size=\"10\" class=\"form-control\" id=\"listProcMessages\" disabled></select>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"wordCountButton\">Word Count</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"wordCountButton\">Setup Word Count</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"matrixMultButton\">Matrix Multiplication&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"matrixMultButton\">Setup Matrix Multiplication</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"featureExtractionButton\">Feature Extraction&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"featureExtractionButton\">Setup Feature Extraction</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"zoomLevelnButton\">Zoom Level&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"zoomLevelButton\">Setup Zoom Level</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"imageStitchingButton\">Image Stitching&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"imageStitchingButton\">Setup Image Stitching</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"imagejFiltersButton\">ImageJ Filters&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"imagejFiltersButton\">Setup ImageJ Filters</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"matRegButton\">Matlab Registration&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"matRegButton\">Setup Matlab Registration</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row no-gutters\">\n");
      out.write("\t\t\t\t<label for=\"matFilterButton\">Matlab Filters&nbsp;</label>\n");
      out.write("\t\t\t\t<button class=\"btn btn-sm btn-default\" id=\"matFilterButton\">Setup Matlab Filters</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("\t<div class=\"row vertical-center\">\n");
      out.write("\t\t<div class=\"col-sm-12\">\n");
      out.write("\t\t\t");
      if (_jspx_meth_spring_url_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${neuLogo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"NEU\" class=\"footer-img pull-right\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Word Count Launch Dialog -->\n");
      out.write("<div id=\"launchWordCountModal\" class=\"modal fade\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Word Count</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"inputDir\">Input Dir</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"inputDir\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/word-count/input\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"outputDir\">Output Dir</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"outputDir\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/word-count/output\">\n");
      out.write("                    </div>\n");
      out.write("                 </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Matrix Multiplication Launch Dialog -->\n");
      out.write("<div id=\"launchMatrixMultModal\" class=\"modal fade\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;Matrix Multiplication (A * B)</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"inputDir1\">Input Dir (Matrix A)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputDir1\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matrix-mult/input1\">\n");
      out.write("\t\t\t\t\t\t<label for=\"inputDir2\">Input Dir (Matrix B)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputDir2\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matrix-mult/input2\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label for=\"intermResultDir\">Intermediate Result Dir (When B=1, this is the final result.)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"intermResultDir\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matrix-mult/intermOuput\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matrixProductDir\">Output Dir (Matrix Product)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matrixProductDir\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matrix-mult/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br/>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label>Matrix Sizes (Matrix A: N0 by N1, Matrix B: N1 by N2)</label>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label for=\"matrixSize0\">N0<input type=\"number\" class=\"form-control\" id=\"matrixSize0\" style=\"width: 150px;\"></label>\n");
      out.write("\t\t\t\t\t\t<label for=\"matrixSize1\">N1<input type=\"number\" class=\"form-control\" id=\"matrixSize1\" style=\"width: 150px;\"></label>\n");
      out.write("\t\t\t\t\t\t<label for=\"matrixSize2\">N2<input type=\"number\" class=\"form-control\" id=\"matrixSize2\" style=\"width: 150px;\"></label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label>How to partition (B0 by B1 by B2)</label>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label for=\"B0\">B0<input type=\"number\" class=\"form-control\" id=\"B0\" value=1 style=\"width: 100px;\"> </label>\n");
      out.write("\t\t\t\t\t\t<label for=\"B1\">B1<input type=\"number\" class=\"form-control\" id=\"B1\" value=1 style=\"width: 100px;\"> </label>\n");
      out.write("\t\t\t\t\t\t<label for=\"B2\">B2<input type=\"number\" class=\"form-control\" id=\"B2\" value=1 style=\"width: 100px;\"> </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<label for=\"matrixPropFile\">Property file (set system parameters)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matrixPropFile\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matrix-mult/10t20t10.properties\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("\t           \t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Feature Extraction Launch Dialog -->\n");
      out.write("<div id=\"launchFeatureExtractionModal\" class=\"modal fade\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Feature Extraction</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"inputDirFE\">Input Dir</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputDirFE\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/feature-extraction/input\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"outputDirFE\">Output Dir</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"outputDirFE\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/feature-extraction/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"featureFilterClassFE\">Feature Filter Class</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"featureFilterClassFE\" value=\"nctracer.features.filters.GaussianBlur3DWrapper\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"featureNeighborhoodSizeFE\">Feature Neighborhood Size</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"featureNeighborhoodSizeFE\" value=3>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"featureThresholdFE\">Feature Threshold</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"featureThresholdFE\" value=\"AUTO\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"featureScalingFactorFE\">Feature Scaling Factor</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"featureScalingFactorFE\" value=\"AUTO\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Zoom Level Launch Dialog -->\n");
      out.write("<div id=\"launchZoomLevelModal\" class=\"modal fade\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Zoom Level</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"inputDirZL\">Input Directory</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputDirZL\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/zoom-level/input\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"outputDirZL\">Output Directory</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"outputDirZL\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/zoom-level/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"OriginZL\">Global Origin</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"OriginZL\" value=\"1,1,1\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"tileDimZL\">Input Tile Dimention</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"tileDimZL\" value=\"256,256,64\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"intensityZL\">Dummy Tile Pixel Intensity</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"intensityZL\" value=\"111\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Image Stitching Launch Dialog -->\n");
      out.write("<div id=\"launchImageStitchingModal\" class=\"modal fade\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;ImageStitching</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"inputDirIS\">Input Dir</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputDirIS\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-stitching/input\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"outputDirIS\">Output Dir</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"outputDirIS\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-stitching/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matchCalculatorClassIS\">Match Calculator Class</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matchCalculatorClassIS\" value=\"neu.nctracer.dm.TranslationMatchCalculator\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"offsetIS\">Microscopic Offset</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"offsetIS\" value=40>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"gridDimensionIS\">Grid Dimension</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"gridDimensionIS\" value=2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"kIS\">K value</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"kIS\" value=2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"epsilonRangeIS\">Epsilon Range</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"epsilonRangeIS\" value=2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"nearestNeighborThresholdDistanceIS\">Nearest Neighbor Threshold Distance</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"nearestNeighborThresholdDistanceIS\" value=2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"nearestNeighborClassIS\">Nearest Neighbor Class</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"nearestNeighborClassIS\" value=\"neu.nctracer.dm.KNearestNeighbors\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"binIS\">Bin</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"binIS\" value=\"true\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- ImageJ Filters Launch Dialog -->\n");
      out.write("<div id=\"launchImageJFiltersModal\" class=\"modal fade\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;ImageJ Filters</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"ijfilterInput\">Input Dir (JPEG images)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"ijfilterInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-filter/jpeg-subset\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"ijfilterOutput\">Output Dir (for filtered images)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"ijfilterOutput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-filter/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"filter-parameter\">\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t<legend>Choose a filter:</legend>\n");
      out.write("\t\t\t\t\t\t\t<label for=\"ijGaussianBlur3D\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" class=\"filter-parameter\" id=\"ijGaussianBlur3D\" name=\"ijfilter\" value=\"ijGaussian\" />  \n");
      out.write("\t\t\t\t\t\t\t\tGaussianBlur3D&nbsp;\n");
      out.write("\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t\t\t<label for=\"ijFFT\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" class=\"filter-parameter\" id=\"ijFFT\" name=\"ijfilter\" value=\"ijFFT\" /> \n");
      out.write("\t\t\t\t\t\t\t\tFFT bandpass&nbsp;\n");
      out.write("\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t\t\t<label for=\"ijThreshold\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" class=\"filter-parameter\" id=\"ijThreshold\" name=\"ijfilter\" value=\"ijThreshold\" /> \n");
      out.write("\t\t\t\t\t\t\t\tThreshold adjuster&nbsp;\n");
      out.write("\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div id=\"divIjGaussianBlur3D\" class=\"filter-parameter\"  style=\"display:none\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for GaussianBlur3D:</p>\n");
      out.write("  \t\t\t\t\t\t<label for=\"gaussianSigmaX\">SigmaX<input type=\"number\" class=\"filter-parameter\" id=\"gaussianSigmaX\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<label for=\"gaussianSigmaY\">SigmaY<input type=\"number\" class=\"filter-parameter\" id=\"gaussianSigmaY\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<label for=\"gaussianSigmaZ\">SigmaZ<input type=\"number\" class=\"filter-parameter\" id=\"gaussianSigmaZ\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div id=\"divIjFFT\" class=\"form-group\"  style=\"display:none\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for FFT bandpass:</p>\n");
      out.write("  \t\t\t\t\t\t<label for=\"fftLargeDia\">Large Diameter<input type=\"number\" class=\"filter-parameter\" id=\"fftLargeDia\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<label for=\"fftSmallDia\">Small Diameter<input type=\"number\" class=\"filter-parameter\" id=\"fftSmallDia\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<br/>\n");
      out.write("  \t\t\t\t\t\t<label for=\"fftChoices\">Choice Diameter</label>\n");
      out.write("  \t\t\t\t\t\t<select class=\"filter-parameter\" id=\"fftChoices\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='none'>None</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='horizontal'>Horizontal</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='vertical'>Vertical</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("  \t\t\t\t\t\t<br/>\n");
      out.write("  \t\t\t\t\t\t<label for=\"fftTolDia\">Tolerance Diameter<input type=\"number\" class=\"filter-parameter\" id=\"fftTolDia\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t&nbsp;\n");
      out.write("\t\t\t\t\t\t<label for=\"fftScalingDia\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"filter-parameter\" id=\"fftScalingDia\" name=\"fftParam\" value=\"fftScalingDia\"/>\n");
      out.write("\t\t\t\t\t\t\tScaling &nbsp; \n");
      out.write("\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp; \n");
      out.write("\t\t\t\t\t\t<label for=\"fftSaturateDia\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"filter-parameter\" id=\"fftSaturateDia\" name=\"fftParam\" value=\"fftSaturateDia\"/>\n");
      out.write("\t\t\t\t\t\t\tSaturate &nbsp; \n");
      out.write("\t\t\t\t\t\t</label>\n");
      out.write("  \t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div id=\"divIjThreshold\" class=\"form-group\"  style=\"display:none\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for Threshold adjuster:</p>\n");
      out.write("  \t\t\t\t\t\t<label for=\"thresholdMethod\">Method</label>\n");
      out.write("  \t\t\t\t\t\t<select class=\"filter-parameter\" id=\"thresholdMethod\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='Huang'>Huang</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Intermodes'>Intermodes</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='IsoData'>IsoData</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Li'>Li</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Mean'>Mean</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='MinError(I)'>MinError(I)</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='MaxEntropy'>MaxEntropy</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Minimum'>Minimum</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Moments'>Moments</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Otsu'>Otsu</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Percentile'>Percentile</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='RenyiEntropy'>RenyiEntropy</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Shanbhag'>Shanbhag</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Triangle'>Triangle</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Yen'>Yen</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("  \t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for database</p>\n");
      out.write("\t\t\t\t\t\t<!-- <label for=\"imageID\">Image ID<input type=\"number\" class=\"form-control\" id=\"imageID\"></label> -->\n");
      out.write("\t\t\t\t\t\t<label for=\"imageName\">Image Name<input type=\"text\" class=\"form-control\" id=\"imageName\"></label>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-db\" data-dismiss=\"modal\">Launch(Write to DB)</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("\t           \t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Matlab Registration Launch Dialog -->\n");
      out.write("<div id=\"launchMatlabRegistrationModal\" class=\"modal fade\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Matlab Registration</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"matRegCSV\">Input CSV File</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"matRegCSV\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matlab-registration/example-new2-after-feature-extraction/LiMBP_Neocortical2_StackList.csv\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matRegTrans\">Transformation</label>\n");
      out.write("                        <select class=\"filter-parameter\" id=\"matRegTrans\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='Translation'>Translation</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Rigid'>Rigid</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Affine'>Affine</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='NonRigid'>Non-Rigid</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matRegParallel\">Sequential/Parallel</label>\n");
      out.write("                        <select class=\"filter-parameter\" id=\"matRegParallel\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='Sequential'>Sequential</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Parallel'>Parallel</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matRegType\">Type of Registration</label>\n");
      out.write("                        <select class=\"filter-parameter\" id=\"matRegType\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='Space'>Space</option>\n");
      out.write("  \t\t\t\t\t\t\t<option value='Timelapse'>Timelapse</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matRegMu\">mu<input type=\"number\" class=\"filter-parameter\" id=\"matRegMu\" style=\"width: 100px;\"></label>\n");
      out.write("                    </div>\n");
      out.write("                 </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Matlab Filter Launch Dialog -->\n");
      out.write("<div id=\"launchMatlabFilterModal\" class=\"modal fade\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Matlab Filter</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matfilterInput\">Input Dir (JPEG images)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matfilterInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-filter/jpeg-subset\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matfilterOutput\">Output Dir (for filtered images)</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matfilterOutput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pluginRoot}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/image-filter/output\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"filter-parameter\">\n");
      out.write("\t\t\t\t\t\t<label for=\"matFiltersChoice\">Choose a filter:&nbsp;</label>\n");
      out.write("                        <select class=\"filter-parameter\" id=\"matFiltersChoice\">\n");
      out.write("  \t\t\t\t\t\t\t<option value='Gaussian3D'>Gaussian3D</option>\n");
      out.write("  \t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div id=\"divMatlabGaussian3D\" class=\"filter-parameter\"  style=\"display:block\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for MATLAB Gaussian3D:</p>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matGaussianSigmaX\">SigmaX<input type=\"number\" class=\"filter-parameter\" id=\"matGaussianSigmaX\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matGaussianSigmaY\">SigmaY<input type=\"number\" class=\"filter-parameter\" id=\"matGaussianSigmaY\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t\t<label for=\"matGaussianSigmaZ\">SigmaZ<input type=\"number\" class=\"filter-parameter\" id=\"matGaussianSigmaZ\" style=\"width: 100px;\"></label>\n");
      out.write("  \t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("  \t\t\t\t\t\t<hr><p>Parameters for database</p>\n");
      out.write("\t\t\t\t\t\t<label for=\"matfilterImageName\">Image Name</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"matfilterImageName\" value=\"matlab-filtered\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                 </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-db\" data-dismiss=\"modal\">Launch(Write to DB)</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Launch</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("<!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script> -->\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${indexJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_6(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${wordCountJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_7(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${matrixMultJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_8(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${featureExtractionJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_9(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${zoomLevelJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_10(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imageStitchingJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_11(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imagejFilterJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_12(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${matRegJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      if (_jspx_meth_spring_url_13(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${matFilterJs}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_0 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_0.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_0.setParent(null);
    _jspx_th_spring_url_0.setValue("/resources/core/images/favicon.ico");
    _jspx_th_spring_url_0.setVar("favIcon");
    int[] _jspx_push_body_count_spring_url_0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_0 = _jspx_th_spring_url_0.doStartTag();
      if (_jspx_th_spring_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_0.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_1 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_1.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_1.setParent(null);
    _jspx_th_spring_url_1.setValue("/");
    _jspx_th_spring_url_1.setVar("home");
    int[] _jspx_push_body_count_spring_url_1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_1 = _jspx_th_spring_url_1.doStartTag();
      if (_jspx_th_spring_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_1.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_2 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_2.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_2.setParent(null);
    _jspx_th_spring_url_2.setValue("/resources/core/css/styles.css");
    _jspx_th_spring_url_2.setVar("mainCss");
    int[] _jspx_push_body_count_spring_url_2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_2 = _jspx_th_spring_url_2.doStartTag();
      if (_jspx_th_spring_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_2.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_2);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_3 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_3.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_3.setParent(null);
    _jspx_th_spring_url_3.setValue("/resources/core/images/nct.png");
    _jspx_th_spring_url_3.setVar("nctLogo");
    int[] _jspx_push_body_count_spring_url_3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_3 = _jspx_th_spring_url_3.doStartTag();
      if (_jspx_th_spring_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_3.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_4 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_4.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_4.setParent(null);
    _jspx_th_spring_url_4.setValue("/resources/core/images/neu2.png");
    _jspx_th_spring_url_4.setVar("neuLogo");
    int[] _jspx_push_body_count_spring_url_4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_4 = _jspx_th_spring_url_4.doStartTag();
      if (_jspx_th_spring_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_4.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_4);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_5 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_5.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_5.setParent(null);
    _jspx_th_spring_url_5.setValue("/resources/core/js/index.js");
    _jspx_th_spring_url_5.setVar("indexJs");
    int[] _jspx_push_body_count_spring_url_5 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_5 = _jspx_th_spring_url_5.doStartTag();
      if (_jspx_th_spring_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_5.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_5);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_6 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_6.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_6.setParent(null);
    _jspx_th_spring_url_6.setValue("/resources/core/js/word-count.js");
    _jspx_th_spring_url_6.setVar("wordCountJs");
    int[] _jspx_push_body_count_spring_url_6 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_6 = _jspx_th_spring_url_6.doStartTag();
      if (_jspx_th_spring_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_6.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_6);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_7 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_7.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_7.setParent(null);
    _jspx_th_spring_url_7.setValue("/resources/core/js/matrix-mult.js");
    _jspx_th_spring_url_7.setVar("matrixMultJs");
    int[] _jspx_push_body_count_spring_url_7 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_7 = _jspx_th_spring_url_7.doStartTag();
      if (_jspx_th_spring_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_7.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_7);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_8 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_8.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_8.setParent(null);
    _jspx_th_spring_url_8.setValue("/resources/core/js/feature-extraction.js");
    _jspx_th_spring_url_8.setVar("featureExtractionJs");
    int[] _jspx_push_body_count_spring_url_8 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_8 = _jspx_th_spring_url_8.doStartTag();
      if (_jspx_th_spring_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_8.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_8);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_9 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_9.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_9.setParent(null);
    _jspx_th_spring_url_9.setValue("/resources/core/js/zoom-level.js");
    _jspx_th_spring_url_9.setVar("zoomLevelJs");
    int[] _jspx_push_body_count_spring_url_9 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_9 = _jspx_th_spring_url_9.doStartTag();
      if (_jspx_th_spring_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_9.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_9);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_10 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_10.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_10.setParent(null);
    _jspx_th_spring_url_10.setValue("/resources/core/js/image-stitching.js");
    _jspx_th_spring_url_10.setVar("imageStitchingJs");
    int[] _jspx_push_body_count_spring_url_10 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_10 = _jspx_th_spring_url_10.doStartTag();
      if (_jspx_th_spring_url_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_10.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_10);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_11 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_11.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_11.setParent(null);
    _jspx_th_spring_url_11.setValue("/resources/core/js/imagej-filter.js");
    _jspx_th_spring_url_11.setVar("imagejFilterJs");
    int[] _jspx_push_body_count_spring_url_11 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_11 = _jspx_th_spring_url_11.doStartTag();
      if (_jspx_th_spring_url_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_11[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_11.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_11.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_11);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_12 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_12.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_12.setParent(null);
    _jspx_th_spring_url_12.setValue("/resources/core/js/matlab-registration.js");
    _jspx_th_spring_url_12.setVar("matRegJs");
    int[] _jspx_push_body_count_spring_url_12 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_12 = _jspx_th_spring_url_12.doStartTag();
      if (_jspx_th_spring_url_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_12[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_12.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_12.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_12);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_13 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_var_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_13.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_13.setParent(null);
    _jspx_th_spring_url_13.setValue("/resources/core/js/matlab-filter.js");
    _jspx_th_spring_url_13.setVar("matFilterJs");
    int[] _jspx_push_body_count_spring_url_13 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_13 = _jspx_th_spring_url_13.doStartTag();
      if (_jspx_th_spring_url_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_13[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_13.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_13.doFinally();
      _jspx_tagPool_spring_url_var_value_nobody.reuse(_jspx_th_spring_url_13);
    }
    return false;
  }
}
