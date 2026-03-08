function initCheckTree(tree,url,id){
    $.ajax({
        url: url,
        data:{id:id},
        dataType: "json",
        method: "get",
        contentType: 'application/json; charset=utf-8',
        success: function (data) {
            console.log(data.toString());
            tree.treeview({
                data: data,
                levels: 1,
                showCheckbox: true,
                showIcon: false,
                showBorder: false,
                expandIcon: undefined,
                collapseIcon: undefined,
                multiSelect: 1,
                highlightSelected: 0,
                onNodeChecked: function (event, node) {
                    check(node);
                },
                onNodeUnchecked: function (event, node) {
                    uncheck(node);
                },
                onNodeSelected:function (event, node) {
                    check(node);
                },
                onNodeUnselected: function (event, node) {
                    uncheck(node);
                },
            });
        }
    });

   /************************选择节点************************/
   //点击节点选择框
    function check(node) {
        let root = tree.treeview('getParent', node);
        if (root.nodeId == undefined) {
            checkChildrenNodes(node);
        }
        else {
            checkChildrenNodes(node);
            checkParentNodes(node);
        }
    }

    /************************取消选择节点************************/
    // 取消选择节点
    function uncheck(node) {
        let root = tree.treeview('getParent', node);
        if (root.nodeId == undefined) {
            uncheckChildrenNodes(node);
        }
        else {
            uncheckChildrenNodes(node);
            uncheckParentNodes(node);
        }
    }

    /************************递归所有要选择的节点方法************************/
    // 向下递归：选择某节点及以下的全部子节点
    function checkChildrenNodes(node) {
        if (node.nodes == null) {
            tree.treeview('checkNode', [node.nodeId, { silent: true }]);
        }
        else {
            for (let i = 0; i < node.nodes.length; i++) {
                tree.treeview('checkNode', [node.nodeId, { silent: true }]);
                checkChildrenNodes(node.nodes[i]);
            }
        }
    }
    // 向上递归：判断某节点以上的根节点是否需要被选择
    function checkParentNodes(node) {
        let checkedNodes = tree.treeview('getChecked');
        let brotherNodes = tree.treeview('getSiblings', node);
        if (brotherNodes.length > 0) {
            let checked = [];
            for (let i = 0; i < brotherNodes.length; i++) {
                for (let j = 0; j < checkedNodes.length; j++) {
                    if (brotherNodes[i].nodeId == checkedNodes[j].nodeId) {
                        checked.push(true);
                    }
                }
            }
            if (checked.length == brotherNodes.length) {
                let parent = tree.treeview('getParent', node);
                tree.treeview('checkNode', [parent.nodeId, { silent: true }]);
                checkParentNodes(parent);
            }
        }
    }

    // 向下递归：取消选择某节点及以下的全部子节点
    function uncheckChildrenNodes(node) {
        if (node.nodes == null) {
            tree.treeview('uncheckNode', [node.nodeId, { silent: true }]);
        }
        else {
            for (let i = 0; i < node.nodes.length; i++) {
                tree.treeview('uncheckNode', [node.nodeId, { silent: true }]);
                uncheckChildrenNodes(node.nodes[i]);
            }
        }
    }

    // 向上递归：取消选择某节点以上的全部根节点
    function uncheckParentNodes(node) {
        let parent = tree.treeview('getParent', node);
        if (parent.nodeId != undefined) {
            tree.treeview('uncheckNode', [parent.nodeId, { silent: true }]);
            uncheckParentNodes(parent);
        }
    }
}