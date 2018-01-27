<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>客户列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <SCRIPT language=javascript>
        function selectcustomer(cust_id, cust_name) {
            // alert(cust_id);
            // alert(cust_name);
            //这实际上是获得了父类页面的win对象，这个页面是在add的页面里点按钮传过来的，所以获得了父类页面add的win对象
            var opener = window.opener;
//        获得添加页面的document对象
            var document = opener.document;
//		获得隐藏域对象和文本框并赋值
            document.getElementById("cust_id").value = cust_id;
            document.getElementById("cust_name").value = cust_name;
            window.close();
        }

        function changePage(pageNum) {
            //1 将页码的值放入对应表单隐藏域中
            $("#currentPageInput").val(pageNum);
            //2 提交表单
            $("#pageForm").submit();
        }

        function changePageSize(pageSize) {
            //1 将页码的值放入对应表单隐藏域中
            $("#pageSizeInput").val(pageSize);
            //2 提交表单
            $("#pageForm").submit();
        }
    </SCRIPT>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                          border=0></TD>
        <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
            height=20></TD>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                          border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
        <TD vAlign=top width="100%" bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                <TR>
                    <TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
                </TR>
                <TR>
                    <TD height=2></TD>
                </TR>
            </TABLE>
            <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
                   width="100%" align=center border=0>
                <TBODY>
                <TR>
                    <TD height=25>
                        <FORM id="pageForm" name="customerForm"
                              action="${pageContext.request.contextPath }/CustomerAction_list"
                              method=post>
                            <!-- 隐藏域.当前页码 -->
                            <input type="hidden" name="currentpage" id="currentPageInput"
                                   value="<s:property value="#pagebean.currentpage" />"/>
                            <%--value想当于表单回显--%>
                            <!-- 隐藏域.每页显示条数 -->
                            <input type="hidden" name="pagesize" id="pageSizeInput"
                                   value="<s:property value="#pagebean.pagesize" />"/>
                            <input type="hidden" name="select" value="<s:property value="#parameters.select==null"/>"/>
                            <TABLE cellSpacing=0 cellPadding=2 border=0>
                                <TBODY>
                                <TR>
                                    <TD>客户名称：</TD>
                                    <TD><INPUT class=textbox id=sChannel2
                                    <%--这里需要把属性改成跟pagebean里的属性值一致，不写了--%>
                                               style="WIDTH: 80px" maxLength=50 name="custName"
                                               value="${param.custName}"></TD>

                                    <TD><INPUT class=button id=sButton2 type=submit
                                               value=" 筛选 " name=custName></TD>
                                </TR>
                                </TBODY>
                            </TABLE>
                        </FORM>
                    </TD>
                </TR>

                <TR>
                    <TD>
                        <TABLE id=grid
                               style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                               cellSpacing=1 cellPadding=2 rules=all border=0>
                            <TBODY>
                            <TR
                                    style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                <TD>客户名称</TD>
                                <TD>客户级别</TD>
                                <TD>客户来源</TD>
                                <TD>联系人</TD>
                                <TD>电话</TD>
                                <TD>手机</TD>
                                <TD>操作</TD>
                            </TR>
                            <s:iterator value="#pagebean.list" var="cust">
                                <TR
                                        style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                    <TD>
                                        <s:property value="#cust.custName"/>
                                    </TD>
                                    <TD>
                                        <s:property value="#cust.custLevel.dictTypeName"/>
                                    </TD>
                                    <TD>
                                        <s:property value="#cust.custSource.dictTypeName"/>
                                    </TD>
                                    <TD>
                                        <s:property value="#cust.custLinkman"/>
                                    </TD>
                                    <TD>
                                        <s:property value="#cust.custPhone"/>
                                    </TD>
                                    <TD>
                                        <s:property value="#cust.custMobile"/>
                                    </TD>
                                    <TD>
                                            <%--注意：这里穿过来的参数是放到parameter域对象里的，所以要获取到域对象才可以--%>
                                        <s:if test="#parameters.select==null">
                                            <%--这个路径是错的，先不修改--%>
                                            <a href="${pageContext.request.contextPath }/CustomerAction_toEdit?custId=<s:property value="#cust.custId" />">修改</a>
                                            &nbsp;&nbsp;
                                            <a href="${pageContext.request.contextPath }/customerServlet?method=delete&custId=${customer.cust_id}">删除</a>
                                        </s:if>
                                        <s:else>
                                            <input type="button" value="选择"
                                                   onclick="selectcustomer(<s:property value="#cust.custId"/>,'
                                                       <s:property value="#cust.custName"/>')">
                                        </s:else>
                                    </TD>
                                </TR>
                            </s:iterator>

                            </TBODY>
                        </TABLE>
                    </TD>
                </TR>

                <TR>
                    <TD><SPAN id=pagelink>
											<DIV
                                                    style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="#pagebean.totalcount"/> </B>]条记录,[<B><s:property
                                                    value="#pagebean.totalpage"/></B>]页
												,每页显示 <%-- changePageSize($('#pageSizeSelect option').filter(':selected').val()) --%> 
												<select name="pageSize"
                                                        onchange="changePageSize($('#pageSizeSelect option:selected').val())"
                                                        id="pageSizeSelect">
													<option value="3" <s:property
                                                            value="#pagebean.pagesize==3?'selected':''"/> >3</option>
													<option value="5" <s:property
                                                            value="#pagebean.pagesize==5?'selected':''"/> >5</option>
												</select>
												条
												[<A href="javaScript:void(0)"
                                                    onclick="changePage(<s:property value='#pagebean.currentpage-1'/>)">前一页</A>]
												<B><s:property value="#pageBean.currentPage"/></B>
												[<A href="javaScript:void(0)"
                                                    onclick="changePage(<s:property value='#pagebean.currentpage+1'/>)">后一页</A>]
												到
												<input type="text" size="3" id="page" name="page"
                                                       value="<s:property value="#pagebean.currentpage" />"/>
												页
												
												<input type="button" value="Go" onclick="changePage($('#page').val())"/>
											</DIV>
									</SPAN></TD>
                </TR>
                </TBODY>
            </TABLE>
        </TD>
        <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
                src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                          border=0></TD>
        <TD align=middle width="100%"
            background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                          border=0></TD>
    </TR>
    </TBODY>
</TABLE>

</BODY>
</HTML>
