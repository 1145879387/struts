<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>添加联系人</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>


    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/LinkmanAction_add.action"
      method=post>


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
                        <TD class=manageHead>当前位置：联系人管理 &gt; 添加联系人</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <tr>
                        <td>所属客户：</td>
                        <td colspan="3">
                            <%--这样赋值有两个条件，一个是cstCustomerByLkmCustId必须是多对一的关系，并且在配置文件里配置了外键，另外一个则是在list页面中，他已经对这个隐藏的hidden标签给赋值了，也就是说，custid实际上是有值的window.opener对其进行了一个赋值，也就是说目前的input标签是一个游离的对象，通过调用save转换成了顺时状态的对象，所以才可以进行关系的维护--%>
                            <%--多说一嘴，除了name属性之外，其他地方赋值或者取值操作都需要用s:propty标签！--%>
                            <input type="hidden" name="cstCustomerByLkmCustId.custId" style="WIDTH: 180px"
                                   id="cust_id"/>
                            <input type="text" style="WIDTH: 180px" id="cust_name"/>
                            <%--select参数是虚拟的，这么一个虚拟的参数会被添加到context域中--%>
                            <input type="button" value="选择客户"
                                   onclick="window.open('${pageContext.request.contextPath}/CustomerAction_list?select=true','','width=500,height=400')"/>
                        </td>
                    </tr>
                    <TR>
                        <td>联系人名称：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmName">
                        </td>
                        <td>联系人性别：</td>
                        <td>
                            <input type="radio" value="1" name="lkmGender">男
                            <input type="radio" value="2" name="lkmGender">女
                        </td>
                    </TR>
                    <TR>
                        <td>联系人办公电话 ：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmPhone">
                        </td>
                        <td>联系人手机 ：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmMobile">
                        </td>
                    </TR>
                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit
                                   value="保存 " name=sButton2>
                        </td>
                    </tr>
                </TABLE>


            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
</FORM>
</BODY>
</HTML>
