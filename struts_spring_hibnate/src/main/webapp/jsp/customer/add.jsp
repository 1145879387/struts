<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE><s:property value="#cstCustomerEntity==null?'添加':'修改'"/>
        客户
    </TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <%--使用ajax来加载数据字典，参数1是数据字典类型（dictTypeCode），参数2是下拉选放入的标签ID，参数三是生成下拉选时select标签的name属性值，参数4是回显时选中那个opention--%>
    <%--清除缓存用的--%>
    <%--<%--%>
    <%--response.addHeader("Pragma", "no-cache");--%>
    <%--response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");--%>
    <%--response.addHeader("Cache-Control", "pre-check=0, post-check=0");--%>
    <%--response.setDateHeader("Expires", 0);--%>
    <%--%>--%>
    <script type="text/javascript">
        function loadSelect(typecode, positionid, selectname, selectId) {
            //创建select对象，并指定name属性
            var $select = $("<select name=" + selectname + "></select>");
            //添加提示选项
            $select.append($("<option value=''>---请选择---</option>"));
            //使用jquery的ajax来访问后台的数据BaseDictaction
            // $.ajaxSetup({cache:false})
            $.post("${pageContext.request.contextPath}/BaseDictaction", {dictTypeCode: typecode},
                function (data) {
                    // alert(data);
                    //遍历jquery数组
                    $.each(data, function (i, json) {
                        // alert(json["dictItemName"]);
                        //封装到opention中
                        var $option = $("<option value='" + json['dictId'] + "' >" + json["dictItemName"] + "</option>");
                        if (json['dictId'] == selectId) {
                            //判断是否需要回显 ,如果需要使其被选中
                            $option.attr("selected", "selected");
                        }
                        //并添加到select对象
                        $select.append($option);
                    });
                }, "json");
            //遍历json,并创建opention对象并添加到select对象里，而且要判断是否需要回显，如果需要回显则回显在添加
            //将最终组装好的select对象放入指定的位置
            $("#" + positionid).append($select);
        }

        // $(document).ready(function(){
        //     // 在这里写你的代码...
        //     loadSelect("001", "level", "custLevel.dictId");
        //     loadSelect("002", "cccc", "custIndustry.dictId");
        //     // loadSelect("004", "dddd", "custSource.dictId");
        // });
        jQuery(function () {
            // 你可以在这里继续使用$作为别名...
            loadSelect("001", "level", "custLevel.dictId" <s:if test="#cstCustomerEntity.custLevel!=null"></s:if>, <s:property value="#cstCustomerEntity.custLevel.dictId"/>);
            loadSelect("002", "cccc", "custIndustry.dictId" <s:if test="#cstCustomerEntity.custIndustry!=null"></s:if>, <s:property value="#cstCustomerEntity.custIndustry.dictId"/>);
            loadSelect("004", "dddd", "custSource.dictId" <s:if test="#cstCustomerEntity.custSource!=null"></s:if>, <s:property value="#cstCustomerEntity.custSource.dictId"/>);
        });
    </script>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<%--表单必须是post提交，而且提交类型是entype,multipart/form-data，文件上传使用input file组建--%>
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/CustomerAction_add"
      method=post enctype="multipart/form-data">
    <%--使用了隐藏域保存了ID，这样就可以执行save-update这样的方法--%>
    <input type="hidden" name="custId" value="<s:property value="#cstCustomerEntity.custId"/>">

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
                        <TD class=manageHead>当前位置：客户管理 &gt; <s:property value="#cstCustomerEntity==null?'添加':'修改'"/>客户
                        </TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <TR>
                        <td>客户名称：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="custName"
                                   value="<s:property value="#cstCustomerEntity.custName"/>">
                        </td>
                        <td>客户级别 ：</td>
                        <td id="level">
                            <%--<INPUT class=textbox id=sChannel2--%>
                            <%--style="WIDTH: 180px" maxLength=50 name="cust_level">--%>
                        </td>
                    </TR>

                    <TR>
                        <td>信息来源 ：</td>
                        <td id="cccc">
                            <%--<INPUT class=textbox id=sChannel2--%>
                            <%--style="WIDTH: 180px" maxLength=50 name="cust_source">--%>
                        </td>
                        <td>联系人：</td>
                        <td id="dddd">
                            <%--<INPUT class=textbox id=sChannel2--%>
                            <%--style="WIDTH: 180px" maxLength=50 name="cust_linkman">--%>
                        </td>
                    </TR>

                    <TR>
                        <td>头像上传</td>
                        <td>
                            <%--<INPUT class=textbox id=sChannel2--%>
                            <%--style="WIDTH: 180px" maxLength=50 name="custPhone">--%>
                            <input name="photo" type="file" value="<s:property value="#cstCustomerEntity.custPhone"/>">
                        </td>
                        <%--<td>移动电话 ：</td>--%>
                        <%--<td>--%>
                        <%--<INPUT class=textbox id=sChannel2--%>
                        <%--style="WIDTH: 180px" maxLength=50 name="custMobile">--%>
                        <%--</td>--%>
                    </TR>
                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit
                                   value=" 保存 " name=sButton2>
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
