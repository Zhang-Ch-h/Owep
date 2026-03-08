/*预览试卷的方法(该方法只能在考试管理中试卷管理和考试汇总这两个页面使用
* e,value,row,index->bootstrap-table列中参数
* */
function detailedTestPaper(e, value, row, index) {
    $('#modal_1 .testPaperName_1').val(row.testPaperName);
    row.state == "禁用" ? $('#modal_1 .state_1').attr("class", 'form-control state_1 text-danger') :
        $('#modal_1 .state_1').attr('class', 'form-control state_1 text-success');
    $('#modal_1 .state_1').val(row.state);
    if (row.adminPermissions == '0') {
        $('#modal_1 .adminPermissions_1').val("完全私有(只有您本人可以管理和使用该试卷)");
    } else {
        $('#modal_1 .adminPermissions_1').val("只读共享(其他管理员可以浏览和引用该试卷进行考试)");
    }
    $('#modal_1 .totalScore').val(row.totalScore + "分");
    $('#modal_1 .nameSection').text(row.nameSection);
    $('#modal_1 .questionBank').text(row.questionBank);
    $('#modal_1 .topic').text(row.topic);
    $('#modal_1 .difficulty').text(row.difficulty);
    $('#modal_1 .titleNumber').text(row.titleNumber);
    $('#modal_1 .singleTopicScore').text(row.singleTopicScore + "分");
    $('#modal_1').modal()

}

/*删除一条记录的方法(通用，使用案例在考试汇总中表删除操作)
* e,value,row,index->bootstrap-table列中参数
* url->ajax请求路径
* event->页面选择器
* */
function deleteRecord(e, value, row, index, url, event) {
    swal({
        title: '您确定要删除该信息吗？',
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "删除",
        closeOnConfirm: false
    }, function () {
        var id = row.id;
        alert(id);
        console.log(row);
         //发送ajax 删除
              $.ajax({
                  url: url+"?id="+id,
                  method: "get",
                  async: true,
                  data: id,
                  dataType: "text",   //期望服务端返回的数据类型
                  contentType: "application/json",
                  success: function (data) {
                      console.log(data.toString());
                      swal("删除成功！", "您已经永久删除已选信息", "success");
                      //window.location.reload();
                      $(event).bootstrapTable("refresh");

                      //根据Id字段删除对应的数据
                      $(event).bootstrapTable('removeByUniqueId', id);

                  },

                  error: function (jqXHR) {
                      swal("删除失败！", "未知错误", "error");
                  }

              });


        swal("删除成功！", "您已经永久删除信息", "success");
    });
}

/*删除多条记录的方法(通用，使用案例在用户管理中表删除操作)
* url->ajax请求路径
* event->页面选择器
* */
function deleteAllRecords(url, event) {
    var rows = $(event).bootstrapTable('getAllSelections');
    console.log(rows);
    if (rows.length == 0) {
        swal("至少选中一行！", "", "error");
        return false;
    }
    let userIds = [];
    for (let i = 0; i < rows.length; i++) {
        userIds.push(rows[i].id)
    }
    swal({
        title: "您确定要删除这" + userIds.length + "条信息？",
        text: "删除后将无法恢复，请谨慎操作！",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "删除",
        closeOnConfirm: false
    }, function () {
        alert(userIds);
         //发送ajax 删除
        $.ajax({
            url: url,
            method: "post",
            async: true,
            data: JSON.stringify(userIds),
            dataType: "text",   //期望服务端返回的数据类型
            contentType: "application/json",
            success: function (data) {
                console.log(data.toString());
                swal("删除成功！", "您已经永久删除已选信息", "success");
                //重新加载页面
                window.location.reload();
            },
            error: function (jqXHR) {
                swal("删除失败！", "未知错误", "error");
            }
        });
        //获取对象
        let ids = $.map(rows, function (row) {
            return row.id
        });
        //根据Id字段删除对应的数据
        $(event).bootstrapTable('remove', {field: 'id', values: ids});
        swal("删除成功！", "您已经永久删除已选信息", "success");
    });
}

/*导出记录的方法(通用，使用案例在用户管理中表记录导出操作)
* url->ajax请求路径
* title->提示信息
* format->转出文件名后缀名(可不填)
* */
function exportRecord(url, title) {
    swal({
        title: "确定要导出" + title + "吗？",
        text: "该操作将导出" + title + "，如果数据较多可能需要较长的时间。",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#1E90FF",
        confirmButtonText: "导出",
        closeOnConfirm: false
    }, function () {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.responseType = 'blob';

        xhr.onload = function () {
            if (xhr.status === 200) {
                var blob = xhr.response;
                var link = document.createElement('a');
                link.href = window.URL.createObjectURL(blob);
                link.download = title + ".xlsx";
                link.click();
                swal("导出成功！", "您已经成功导出信息", "success");
            } else {
                swal("导出失败！", "发生未知错误，请稍后再试。", "error");
            }
        };

        xhr.send();
    });
}

/*function exportRecord(url, title, format) {
    format == null ? format = "EXCEL表格" : format;
    swal({
        title: "确定要导出" + title + "吗？",
        text: "该操作将导出" + title + format + "，如果数据较多可能需要较长的时间。",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#1E90FF",
        confirmButtonText: "导出",
        closeOnConfirm: false
    }, function () {
        fetch(url)
            .then(response => response.blob())
            .then(blob => {
                var link = document.createElement('a');
                link.href = window.URL.createObjectURL(blob);
                link.download = title + ".xlsx";
                link.click();
                swal("导出成功！", "您已经永久导出信息", "success");
            })
            .catch(error => {
                swal("导出失败！", "导出信息时出错", "error");
            });
    });
}*/

/*function exportRecord(url, title, format) {
    format == null ? format = "EXCEL表格" : format;
    swal({
        title: "确定要导出" + title + "吗？",
        text: "该操作将导出" + title + format + "，如果数据较多可能需要较长的时间。",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#1E90FF",
        confirmButtonText: "导出",
        closeOnConfirm: false
    }, function () {
        $.ajax({
            url: url,
            type: 'GET',
            xhrFields: {
                responseType: 'blob'
            },
            success: function (data, textStatus, xhr) {
                var blob = xhr.response;  // 直接使用 xhr.response
                var link = document.createElement('a');
                link.href = window.URL.createObjectURL(blob);
                link.download = title + ".xlsx";
                link.click();
                swal("导出成功！", "您已经永久导出信息", "success");
            },
            error: function (xhr, textStatus, errorThrown) {
                swal("导出失败！", "导出信息时出错", "error");
            }
        });
    });
}*/

/*普通弹框方法*/
function promptMessage(url, title, text, btnText) {
    swal({
        title: title,
        text: text,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#1E90FF",
        confirmButtonText: btnText,
        closeOnConfirm: false
    }, function () {
        //ajax请求
        swal("操作成功！", "", "success");
    });
}

/*查询记录操作*/
function queryRecords(eventParentName, dataList, url) {
    let queryList = dataList;
    let queryMap = new Map();
    let queryNullList = new Array()
    queryList.forEach(function (item, index) {
        let event = $('' + eventParentName + ' input[name=' + item + ']');
        event.val() == "" ?
            queryNullList.push($('' + eventParentName + ' input[name=' + item + ']'))
            : queryMap.set(event.attr('name'), event.val());
    })

    let formData="";
        queryMap.forEach(function (value, key){
        formData += key +'='+value +'&';
    });
        formData = formData.substr(0,formData.length - 1);

    //静态假数据
    /*let fakeData = [
        {id: 1, userName: 'John', realName: 'John', userPhone: 18812345678, userEmail: "zch@163.com", status: 1, lastAccessTime: "2019-01-01"},
        //...可以添加更多的假数据...
    ];*/
     //发送ajax 查询
         $.ajax({
             url: url,
             method: "get",
             async: true,
             //sidePagination:'client',
             data:formData,
             dataType: "json",   //期望服务端返回的数据类型
             //contentType: "application/json",
             success: function (data) {
                 let jsonString = JSON.stringify(data.data);
                 console.log("这是Result里的data数据:"+jsonString);
                 //重新加载页面
                 //console.log($('#tb_departments'));
                 if (data.status === "701") {
                 $('#tb_departments').bootstrapTable("load", []);  // 清空表格数据
                 } else if (data.status === "200") {
                     console.log(data.data.length);
                         $('#tb_departments').bootstrapTable("load", data.data);
                     }
             },
             error: function (jqXHR) {
                 swal("搜索失败！", "未知错误", "error");
             }
         });
    if (queryNullList.length > 0) {
        swal("搜索失败", "搜索数据不允许为空", "error");
    } else {
        swal("搜索成功！", "已为你重新加载数据", "success")
    }
        queryMap.forEach(function (key,value) {
            console.log(value);
            $(''+eventParentName+' input[name='+value+']').css('border-color',"");
        })
}

/*创建最基本的bootstrap-table表格(通用，使用案例在考试汇总中表创建操作)*/
function createTable(event, url, toolbar, search, data, method) {
    $(event).bootstrapTable({
        url: url,       //请求后台的URL（*）
        method: method,                      //请求方式（*）
        toolbar: toolbar,                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 15, 20],        //可供选择的每页的行数（*）
        search: search,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端
        showSearchButton: true,
        searchAlign: "left",
        toolbarAlign: "left",
        searchFields: "customerBelongs",
        minimumCountColumns: 2,             //最少允许的列数
        columns: data,
        uniqueId: "id",
    });
}

/*回显表单中的数据(通用)
* eventParentName->父级控件名
* echoDataList->数据集合  数据格式为
* let echoDataList = new Array(["testPaperName_1","testPaperName"],[switchery_NoTable,"state","true"],"classification")
* echoDataList参数一为该input的name,参数二为json对应的字段名,参数三是否是滑动按钮(只有时滑动按钮时，参数3才可以选择)
* 在input的name和json对应的字段名对应一致时,只需参数1
* 在input的name和json对应的字段名对应不一致时,则需要填写参数1和2
* 使用按钮详见exam->paperManagementList页面
* */
function echoDataForm(eventParentName, echoDataList, row) {
    // console.log(eventParentName);
    // console.log(echoDataList);
    // console.log(row);

    function value(item, row) {
        console.log("item:"+item);
        let value = "";
        for (let i in row) {

            if(i === item ){
                console.log("i："+i);
                value = row[i];
            } //从row中找item,找到则复制值
        }
        value === "" ? value = item : "";//值若为空(row中没有对应值)，用item顶位
        console.log("value"+value);
        return value;
    }

    echoDataList.forEach(function (item, index) {
        if(item === "gender"){//性别特别处理
            $(eventParentName + ' input[value='+value("gender",row)+']').prop("checked", true);
        }
        if(item === "status"){//用户状态特别处理
            let status_val = value("status", row); // 直接使用"status"作为key来获取值
            //console.log(status_val);
            if (status_val == 1){
                // 确保滑动按钮处于正确的状态。您可能需要根据实际的滑动按钮插件进行调整
                $(eventParentName + ' .js-switch').prop("checked", true);
            } else {
                $(eventParentName + ' .js-switch').prop("checked", false);
            }
        }
        $(eventParentName + ' input[name=\"' + item + '\"]').val(value(item, row));//其他普通文本


        //这个不对应
        // (typeof item) == "object" ?
        //     item.length == "3" && item[2] == "sweetalert" ?
        //         (value(item[1], row) == '启用' && !item[0].isChecked()) || (value(item[1], row) == '禁用' && item[0].isChecked()) ?
        //             item[0].setPosition(true) : ""
        //         : item[1] == "sex" ? $(eventParentName + ' input[value=\"' + value(item[0], row) + '\"]').prop("checked", true) :
        //         $(eventParentName + ' input[name=\"' + item[0] + '\"]').val(value(item[1], row)) :
        //     $(eventParentName + ' input[name=\"' + item + '\"]').val(value(item, row));
    })
}

/*获取json数据的方法,通过同步请求*/
function getAjaxSynchronousData(url, type) {
    let pageData = "";
    $.ajax({
        url: url, //json文件位置
        type: type, //请求方式为get/post
        dataType: "json", //返回数据格式为json
        async: false,
        success: function (data) { //请求成功完成后要执行的方法
            console.log("获取json数据的方法成功(同步)")
            pageData = data;
        },
        error: function (data) {
            console.log("获取json数据的方法失败(同步)")
        }
    })
    return pageData;
}

/*获取json数据的方法，通过异步请求*/
function getAjaxAsynchronousData(url, type , ceshi) {
        let pageData = '';
        (function () {
            getPageData(function (result) {
                console.log("已经回调方法")
                ceshi(result);
            });
        })();
        function getPageData(callbackData) {
            $.ajax({
                url: url,
                type: type,
                dataType: "json",
                async: true,
                success: function(result) {
                    pageData = result;
                    callbackData(pageData);
                    console.log("获取json数据的方法成功(异步)")
                },
                error: function () {
                    console.log("获取json数据的方法失败(异步)")
                }
            })
        }
        return pageData;
}

//获取主观题的方法,为考试管理的考试记录中批改试卷做准备(不通用)
function getSubjectiveItem(data,pageNumber) {
    console.log("data.length"+data.length,"pageNumber:"+pageNumber);
    if(pageNumber<0||pageNumber>data.length-1){
        pageNumber = 0;
    }
    parent.layer.open({
        type: 2,
        content: 'exam/markExamPapersIFrame.html',
        area: ['85%', '85%'],
        shadeClose: true,
        anim: 3,
        isOutAnim: false,
        maxmin: true,
        title: "《快速批改主观题》---该功能仅用于提高主观题的人工批改效率，其批改效果与“批阅试卷”功能相同",
        success: function (layero, index) {
            let body = parent.layer.getChildFrame('body', index);
            let iframeWin = window[layero.find('iframe')[0]['name']];
            body.find('.buttons').fadeIn(1000);
            body.find('.tabs-container').slideUp(1000);
            //表头个人信息
            body.find('table').attr('students_tag',data[pageNumber]['id'])
            body.find('table').attr('pageNumber',pageNumber)
            body.find('table').attr('index',index)
            console.log(layero,index);
            body.find('input[name=current_page]').attr('placeholder',data[pageNumber]['id'])
            body.find('a[name=total_pages]').text(data.length)
            getAjaxAsynchronousData('../../static/js/demo/exam/testQuestionsListTest.json', 'get', function (result) {
                body.find('table a[name=testSubjects]').text(result[0]['testSubjects']);
            });
            /*                  let name = new Array('name', 'examinee', 'canTestTimes', 'currentNumber', 'examTime', 'totalPoints', 'score',
                                  'passMark', 'testTime', 'startTime', 'endTime');
                              name.forEach(function (item, index) {
                                  body.find('table a[name=' + item + ']').text(row[item]);
                              });*/
            //试题部分
            getData(body,data[pageNumber]);
            //关闭上一层
            index>1?parent.layer.close(index-1):"";
        }
    });
    function getData(body,result) {
        let mapData = new Map();
        mapData.set(result['value'][0]['question_types'], new Array(result['value'][0]));
        //将得到的数据进行分类
        for (let i in result['value']) {
            getData(mapData, result['value'][i]['question_types'], 'question_types') &&
            !getData(mapData, result['value'][i]['id'], 'id') ?
                mapData.forEach(function (value, key) {
                    key == result['value'][i]['question_types'] ?
                        value.push(result['value'][i]) : ""
                }) :
                mapData.set(result['value'][i]['question_types'], new Array(result['value'][i]));
        }
        //生成内容
        let question_types_number = 0;
        let tab_id = 1;
        mapData.forEach(function (value, key) {
            //动态生成题目类型
            body.find('.particulars:last').after(body.find('.types:eq(0)').clone())
            body.find('.types:last').find('p[name=question_types]').html("&nbsp;&nbsp;&nbsp;" + key);
            body.find('.tabs-container li:last').after(
                body.find('.tabs-container li:first').clone()
            );
            body.find('.tabs-container .tab-content .tab-pane:last').after(
                body.find('.tabs-container .tab-content .tab-pane:first').clone()
            );
            body.find('.tabs-container li:last a').attr('href','#tab-'+tab_id).text(key);
            body.find('.tabs-container .tab-content .tab-pane:last').attr('id','tab-'+tab_id);
            for (let i in value) {
                question_types_number++;
                //动态生成题目
                //克隆题目内容的样式
                body.find('.types:last').after(body.find('.particulars:eq(0)').clone().attr('sign', value[i]["id"]));
                if (key == "单选题") {
                    body.find('div[sign=' + value[i]["id"] + '] .topic hr').after(
                        body.find('div[name=option]:last').clone()
                    );
                    Object.values(value[i]["option"]).forEach(function (item, index) {
                        body.find('div[sign=' + value[i]["id"] + ']  .topic div[name=option] .col-md-11').append(
                            "<p>" + String.fromCharCode(65 + index) + "." + item + "</p>"
                        );
                    })
                }
                if (key == "编程题") {
                    Object.keys(value[i]).forEach(function (key) {
                        //往样式里传值html("<pre class=\"layui-code\">"+value[i]['stu_answer']+"</pre>"
                        if (key == 'stu_answer') {
                            body.find('div[sign=' + value[i]["id"] + '] a[name=stu_answer]').append(
                                body.find('.layui-code:last').clone()
                            );
                            body.find('div[sign=' + value[i]["id"] + '] a[name=stu_answer]  .layui-code span').text(
                                value[i]['stu_answer']
                            )
                        } else if (key == 'sta_answer') {
                            body.find('div[sign=' + value[i]["id"] + '] a[name=sta_answer]').append(
                                body.find('.layui-code:last').clone()
                            );
                            body.find('div[sign=' + value[i]["id"] + '] a[name=sta_answer]  .layui-code span').text(
                                value[i]['sta_answer']
                            );
                        } else {
                            body.find('div[sign=' + value[i]["id"] + '] a[name=' + key + ']').text(value[i][key]);
                        }
                    })
                }
                else {
                    Object.keys(value[i]).forEach(function (key) {
                        //往样式里传值
                        body.find('div[sign=' + value[i]["id"] + '] a[name=' + key + ']').text(value[i][key]);
                    })
                }
                //动态生成按钮
                body.find('#tab-'+tab_id+' .col-md-1:last').after(
                    body.find('#tab-'+tab_id+' .col-md-1:first').clone()
                )
                value[i]['points_scored'] == "0"?
                    body.find('#tab-'+tab_id+' .col-md-1:last button').attr({'butMark':question_types_number,'class':'btn btn-danger'}).text(question_types_number):
                    body.find('#tab-'+tab_id+' .col-md-1:last button').attr({'butMark':question_types_number,'class':'btn btn-success'}).text(question_types_number);
                //给定id
                body.find('div[sign=' + value[i]["id"] + '] .points_scored').attr('id', value[i]["id"]);
                //改变样式
                value[i]['points_scored'] == "0"?body.find('div[sign=' + value[i]["id"] + '] a[name=points_scored]').attr('class','text-danger'):"";
                value[i]['stu_answer'] == "未作答"?body.find('div[sign=' + value[i]["id"] + '] a[name=stu_answer]').attr('class','text-danger'):"";
            }
            //隐藏第一个参考按钮
            body.find('#tab-'+tab_id+' .col-md-1:first').css('display', 'none');
            tab_id++;
        });
        //隐藏参考数据
        body.find('.types:first').css('display', 'none');
        body.find('.particulars:first').css('display', 'none');
        body.find('div[name="option"]:last').css('display', 'none');
        body.find('pre:last').css('display', 'none');
        body.find('.tabs-container .tab-content .tab-pane:first').css('display', 'none');
        body.find('.tabs-container li:first').css('display', 'none');
        body.find('.tabs-container li:eq(1)').attr('class','active');
        body.find('.tabs-container .tab-pane:eq(1)').attr('class','tab-pane active');
        //给定序号
        console.log(question_types_number)
        for(let i = 0;i <= question_types_number;i++){
            body.find('button[name=number]:eq('+i+')').text(i);
            body.find('button[name=number]:eq('+i+')').attr('number',i);
        }
        function getData(gather, character, keyword) {
            let judge = false;
            mapData.forEach(function (value, key) {
                for (let i in value) {
                    if (judge) {
                        break;
                    }
                    judge = (character == value[0][keyword]);
                }
            })
            return judge;
        }
    }
}

//产生唯一性id
function  guid(){
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        let r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}
