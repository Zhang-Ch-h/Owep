<!-- 创建试题中的增加选项-->

/*0:单选题 1:多选题 3:填空题     questionType*/
function testItemList(questionType) {

    /*新建一个数组*/
    let panelList = typelist(questionType);
    /*把原元素放进去*/
    panelList.push($(".col-sm-5"));
    /*给添加按钮点击事件*/
    $("#add_section_btn").on("click", function (event) {
            let $container = $(".panel-group");
            //1. 克隆一个 panel
            let newPanel = $(".col-sm-5", $container).eq(questionType).clone();
            //1.1 添加到数组中
            panelList.push(newPanel);
            console.log("添加后数组长度" + panelList.length);
            //2. 重置此数组中的需要修改的DOM元素
            updateId1(panelList, questionType);
            //3. 添加到容器中
            $container.append(newPanel);
            //4. 给关闭按钮重新绑定事件
            $.each(panelList, function (index, element) {
                $(".close").on("click", function (event) {
                    event.stopImmediatePropagation();
                    if (confirm("是否删除当前选项?")) {
                        if (panelList.length <= 1) {
                            alert("至少保留一个选项");
                        } else {
                            $(this).parents('.col-sm-5').remove();
                            panelList.splice(index, 1);
                            updateId1(panelList, questionType);
                        }
                    }
                })
            })
        }
    );
}

/*更新数组并修改元素*/
function updateId1(panelList, questionType) {
    //修改此元素中的id值和内容去的id
    //遍历数组改label值
    let x = 64;
    for (let i = 0; i < panelList.length; i++) {
        //debugger
        x = x + 1;
        let value = "选项" + String.fromCharCode(x);
        /*判断题型*/
        if (questionType === 0) {
            //ascii码转字符：用fromCharCode(); //有问题
            panelList[i].find('.radio.radio-success').find('.options').text(value);
            panelList[i].find('.radio.radio-success').find('.options').attr("for", x);
            panelList[i].find('.radio.radio-success').find('.radio_select').attr("id", x);

        }
        /*多选题*/
        if (questionType === 1) {
            panelList[i].find('.checkbox').find('.selects').text(value);
            panelList[i].find('.checkbox').find('.selects').attr("for", x);
            panelList[i].find('.checkbox').find('.choice').attr("id", x);
        }
        if (questionType === 3) {
            panelList[i].find('h3').text("填空" + (i + 1));
        }
    }
}

/*判断传入的选项生成对应的数组*/

/*0:单选题 1:多选题 3:填空题*/
function typelist(questionType) {
    /*判断传入的是选项几*/
    if (questionType === 0) {
        let radiolList = [];
        return radiolList;
    }
    if (questionType === 1) {
        let multipleChoice = [];
        return multipleChoice;
    }
    if (questionType === 3) {
        let fvp = [];
        return fvp;
    }
}
