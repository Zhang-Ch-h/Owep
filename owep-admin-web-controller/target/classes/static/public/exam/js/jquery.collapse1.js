/*******************************8
 * author: yejf
 * date: 2020/6/17
 * description: 一个可以自由折叠的panel组件，基于bootstrap和jquery, 本插件采用 class 来封装,基于ES6语法
 *
 */
;(function ($, window, document, undefined) {

    //全局函数
    /***
     * 产生唯一性字符串
     * @returns {string}
     */
    function guid() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            let r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    }

    /****
     * 全局函数，判断是否为json对象 [未使用]
     * @param str
     * @returns {boolean}
     */
    function isJsonString(str) {
        try {
            if (typeof JSON.parse(str) == "object") {
                return true;
            }
        } catch (e) {
        }
        return false;
    }

    //定义一个Collapse类型
    class Collapse {
        //定义构造器
        constructor(element, options) {
            //定义一个数组来存放新增的每一个 panel
            this.panelList = [];
            //定义一个属性来存放当前添加试题的面板
            this.currentPanel = {};
            //通过属性来存储传递进来的参数
            this.$element = element;
            //定义默认的选项
            this.default = {
                'className': '.panel-group',  //折叠组件的父元素
                'inputWidth': '80%',  //输入框的宽度, 也可以传入具体的像素
                'modalName': '#myModal',  //增加题目按钮 对应的模态框名字, 记得以 #开头,默认是 #myModal
                'review': function () {
                    //
                    alert("请通过 review 属性来定义预览函数");
                },
                'delete': function (_target) {   //移除某个条目
                    //直接移除掉当前元素的父元素
                    if (window.confirm("你确定要移除此条记录吗？")) {
                        //移除
                        $(_target).parent().remove();
                    }
                },
                'itemDatas': [],  //表示panel-body中的条目数据
                'formatter': function (id) {
                    console.log("当前的条目ID:" + id);
                    return "<button type='button' class='btn btn-default' data-trigger='review' data-id='" + id + "'>" +
                        "<i class='glyphicon glyphicon-eye-open'></i></button>" +
                        "<button type='button' class='btn btn-default' data-trigger='delete'><i class='glyphicon glyphicon-remove'></i></button>";
                },
                'method': 'get',  //默认采用 get
                'batchInsertId': '#myModalBatchAddBtn',
                'batchInsertHandler': function (_this) {
                    //默认实现
                    //1. 判断用户传入的是否是json
                    if (typeof _this.options.itemDatas == 'object') {
                        console.log("传入的为json对象");
                    } else {
                        //如果不是json对象，则需要 通过 ajax 方法去获取对象
                        console.log(_this.options.itemDatas);
                        // 调用 ajax 方法去获取
                        $.ajax({
                            url: _this.options.itemDatas,
                            async: false,    //todo: 此处如果采用异步的话，则数据不能迭代
                            method: _this.options.method,
                            success: function (data) {
                                //
                                console.log("...加载数据成功....");
                                _this.options.itemDatas = data;
                            },
                            error: function (jqXHR) {
                                //
                                console.log("加载数据失败：" + jqXHR);
                            },
                            dataType: "json"
                        });
                    }
                    //判断当前的panel-body中是否存在 ul 元素
                    let ul = {};
                    if ($("ul[class='list-group']", _this.currentPanel).length > 0) {
                        ul = $("ul[class='list-group']", _this.currentPanel);
                    } else {
                        ul = $("<ul>").addClass("list-group");
                    }
                    //迭代用户指定的数据
                    $.each(_this.options.itemDatas, function (index, element) {
                        let li = $("<li>").addClass("list-group-item").addClass("li-item");
                        li.append($('<input type="text" name="score" value="' + element.score + '">'));
                        li.append($('<span>').text(element.item));
                        //li.append('<button type="button" class="btn btn-default" data-trigger="review" data-id="'+element.id+'"><i class="glyphicon glyphicon-eye-open"></i></button>');
                        //li.append('<button type="button" class="btn btn-default" data-trigger="delete"><i class="glyphicon glyphicon-remove"></i></button>');
                        li.append(_this.options.formatter(element.id));
                        //把li插入到 ul中
                        ul.append(li);
                    });
                    //把ul插入到 当前面板的 panel-body中
                    $(".panel-body", _this.currentPanel).append(ul);
                }
            }
            //通过jquery的 extend方法来存储数据
            this.options = $.extend({}, this.default, options);
            //获取面板组
            this.panelGroup = $(this.default.className);
        }

        /***********
         * 初始化方法，此方法负责初始化， 把折叠按钮和关闭按钮的事件绑定好
         */
        init() {
            console.log("执行初始化 init() 方法...");
            console.log(this.panelGroup);
            //把已有的panel添加到数组中
            this.panelList.push($(".panel.panel-default"));
            //给所有的panel添加 data-index 属性
            this.setDataIndex();
            //1. 给添加按钮绑定事件
            this.$element.on("click", this, this.clonePanel);
            //2.给关闭按钮添加事件
            this.panelGroup.on('click', 'button[class="close"]', this, this.closePanel);
            //3.批量设置分值事件
            this.panelGroup.on("click", "a[data-trigger='setScore']", this, this.setScore);
            //4.预览试题按钮 事件
            this.panelGroup.on("click", "button[data-trigger='review']", this, this.reviewItem);
            //5.删除试题按钮 事件
            this.panelGroup.on("click", "button[data-trigger='delete']", this, this.deleteItem);
            //6.打开模态框
            this.panelGroup.on("click", "button[data-toggle='modal']", this, this.openModal);
            //7.模态框中的插入按钮
            $(this.options.batchInsertId).on("click", this, this.batchInsert);
        } // end of init method

        /*****
         * 给所有panel添加下标
         */
        setDataIndex() {
            $.each(this.panelList, function (index, element) {
                //
                $(element).attr("data-index", index);
            })
        }

        //关闭按钮
        closePanel(event) {
            //阻止事件的冒泡传递，只需要针对当前的x 执行本方法即可
            event.stopImmediatePropagation();
            if (confirm("确定要删除该章节吗？")) {
                //
                if ($(".panel.panel-default").length <= 1) {
                    //
                    alert("请至少要保留一个章节!");
                } else {
                    let panel = $(event.currentTarget).parents(".panel.panel-default");
                    panel.remove();
                    //从event中取出传递过来的数据
                    let _this = event.data;
                    //从数组中移除一个
                    let remainPanelList = $.grep(_this.panelList, function (element, index) {
                        return $(element).attr("data-index") != panel.attr("data-index");
                    });
                    //把留下来的数组赋值给原来的属性
                    _this.panelList = remainPanelList;
                    console.log("还剩下：" + _this.panelList.length);
                }
            }
        }

        //设置分值
        setScore(event) {
            event.stopImmediatePropagation();
            //取值
            var score = $(event.currentTarget).siblings(".input_score").val();
            console.log("获取的分值：" + score);
            //赋值：
            let inputList = $(".panel-body input", $(event.currentTarget).parents(".panel.panel-default"));
            if (inputList.length > 0) {
                //迭代
                inputList.each(function (index, element) {
                    console.log("第" + index + "个：" + element);
                    $(element).val(score);
                });
            } else {
                //提示
                alert("没有加入任何的题目！");
            }

        }

        /*******************************************************
         * 预览试题条目
         * @param event   这个参数是当前的插件对象，也注是 Collapse 对象
         */
        reviewItem(event) {
            //判断
            if ($(this).attr("data-id")) {
                //invoke
                event.data.options.review($(this).attr("data-id"));
            } else {
                alert("错误：你在按钮上没有添加 data-id属性，请添加上!");
            }
        }

        /*****
         * 删除试题条目
         * @param event  这个参数是当前的插件对象，也注是 Collapse 对象
         */
        deleteItem(event) {
            //调用, 注：上面click方法中的this是指当前的插件对象，而下面的 this 则是指当前被点击的对象
            event.data.options.delete(this);
        }

        /*****************************
         * 打开模态框
         * @param event
         */
        openModal(event) {
            //获取插件对象
            let _this = event.data;
            //获取当前操作的面板
            _this.currentPanel = $(this).parents(".panel.panel-default");
            console.log("当前点选的面板的data-index是： " + _this.currentPanel.attr("data-index"));
            //打开模态框
            $(_this.options.modalName).modal('show');
        }

        /*******************
         * 模态框中的插入按钮
         * @param event
         */
        batchInsert(event) {
            //调用, 把 event.data 也就是 封装的插件对象本身传递过去
            let _this = event.data;
            //隐藏弹出框
            $(_this.options.modalName).modal('hide');
            //调用默认或用户传递过来的 批量插入 函数,并以当前所在的面板组为参数
            event.data.options.batchInsertHandler(_this);
        }

        /************************************************************************
         * 克隆面板[panel]
         * @param event
         */
        clonePanel(event) {
            let _this = event.data;
            //选出第一个 章节组件
            let newPanel = $(".panel.panel-default", _this.panelGroup).eq(0).clone();
            //修改此元素中的 <a> 中的id值以及 内容区的id
            let target = guid();
            //修改下拉小按钮的 href值，保证与 下面的 panel-collapse中的id值一样
            $("a", newPanel).attr("href", "#" + target);
            //
            $(".panel-collapse", newPanel).attr("id", target);
            //把复制出来的元素中的 panel-body 元素清空
            // $(".panel-body", newPanel).children().remove();
            $('.simditor-body.changed', newPanel).children().remove();
            //再把这个复制出来的元素添加到父元素中
            _this.panelGroup.append(newPanel);
            //找到父级元素
            // var parent = $('.append_panel').find('div:eq(6)');
            // newPanel.appendTo(parent);
            //把这个元素添加数组 panelList中
            _this.panelList.push(newPanel);
            //更新索引
            _this.setDataIndex();
            //
            console.log("当前panel的个数：" + event.data.panelList.length);
        }
    } //end of class

    //扩展至 jquery框架
    $.fn.collapsePanel = function (options) {
        // 创建对象
        let collapse = new Collapse(this, options);
        //调用方法
        return collapse.init();
    }
})(jQuery, window, document);
