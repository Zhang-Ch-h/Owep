function initCheckTree(o,id){
    console.log("id"+id);
    $.ajax({
        // url: '../../static/js/demo/privilege/menuAction_treeCheck_test.json',
        url:"/owep/privilege/menuAction/treeCheck",
        data:{id:id},
        dataType: "json",
        method: "get",
        contentType: 'application/json; charset=utf-8',
        success: function (data) {
            o.treeview({
                data: data,
                levels: 2,
                showCheckbox: 1,
                showIcon: false,
                showBorder: false,
                expandIcon: undefined,
                collapseIcon: undefined,
                multiSelect: 1,
                highlightSelected: 0,
                /*节点选中事件*/
                onNodeChecked: function (event, node) {
                    let selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则选中所有子节点
                        o.treeview('checkNode', [selectNodes, {silent: true}]);
                    }
                    setParentNodeCheck(node);
                },
                onNodeSelected:function(event,node){
                    let selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则选中所有子节点
                        o.treeview('checkNode', [selectNodes, {silent: true}]);
                    }
                    setParentNodeCheck(node);
                    o.treeview('checkNode',[node.nodeId,{silent:true}]);
                },
                onNodeUnselected:function(event,node){
                    o.treeview('uncheckNode',[node.nodeId,{silent:true}]);
                    let selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则取消选中所有子节点
                        o.treeview('uncheckNode', [selectNodes, {silent: true}]);
                    }
                    /*如果父节点选中，子节点部分选中，则取消父节点选中状态*/
                    if (node.parentId !=undefined) {
                        o.treeview('uncheckNode', [node.parentId, {silent: true}]);
                    }
                },
                onNodeUnchecked: function (event, node) { //取消选中节点
                    let parent = o.treeview('getParent', node);
                    let selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则取消选中所有子节点
                        o.treeview('uncheckNode', [selectNodes, {silent: true}]);
                    }
                    /*如果父节点选中，子节点部分选中，则取消父节点选中状态*/
                    if (node.nodeId !== 0) {
                        o.treeview('uncheckNode', [parent, {silent: true}]);
                    }
                }
            });
        }
    });

//当子节点全被选中时 其父节点被选中  如若还有祖先节点则递归
    function setParentNodeCheck(node) {
        let parentNode = o.treeview("getParent", node);
        if (parentNode.nodes) {
            let checkedCount = 0;
            for (let x in parentNode.nodes) {
                if (parentNode.nodes[x].state.checked) {
                    checkedCount++;
                } else {
                    break;
                }
            }
            if (checkedCount === parentNode.nodes.length) {
                o.treeview("checkNode", parentNode.nodeId);
                setParentNodeCheck(parentNode);
            }
        }
    }

    /*获取所有子节点*/
    function getChildNodeIdArr(node) {
        let ts = [];
        if (node.nodes) {
            for (let x in node.nodes) {
                ts.push(node.nodes[x].nodeId);
                if (node.nodes[x].nodes) {
                    let getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                    for (j in getNodeDieDai) {
                        ts.push(getNodeDieDai[j]);
                    }
                }
            }
        } else {
            ts.push(node.nodeId);
        }
        return ts;
    }
}