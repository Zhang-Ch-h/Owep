/*不带时分秒,需要在页面引入bootstrap-datepicker*/
function timeAllocation(object) {
    /*时间控件配置*/
     $(object).datepicker({
         language: "zh-CN",
         clearBtn: true,
         autoclose: true,
         todayHighlight: true,
         format: 'yyyy-mm-dd',
         todayBtn: true,
         weekStart: 1,
         startView: 2,
         forceParse: 0,
         showMeridian: 1,
         startDate: '1970-1-1',
         endDate: '2070-1-1'
     });
};
/*带时分秒，需要在页面引用bootstrap-datetimepicker*/
function timeAllocationForTime(object) {
    /*时间控件配置*/
    $(object).datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        clearBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minuteStep:5,
        format: 'yyyy-mm-dd hh:ii:ss'
    })
};