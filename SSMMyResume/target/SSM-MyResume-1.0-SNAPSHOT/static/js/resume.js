var $editPanel;
$(function() {
    //设置 bootbox 插件的语言环境
    bootbox.setLocale(language);

    $editPanel = $('#editPanel');
    //关闭编辑窗口
    $('#editPanel').on('click', '.close', function(event) {
        event.preventDefault();
        closeEditContentWindow();
    });
    //首页
    loadHomeContent();
    //关于我
    loadAboutMeContent();
    // //专业技能
    // loadMySkillsContent();
    // //教育经历
    // loadEducationContent();
    // //工作经验
    // loadExperienceContent();
    // //荣誉
    // loadHonorContent();
    // //爱好
    // loadHobbyContent();
    // //联系我
    // loadContactContent();
    //下载简历
    // loadDownloadResumeContent();
});

function loadHomeContent() {
    loadViewContent($('#home'), '/home/content');
}

function loadAboutMeContent() {
    loadViewContent($('#about'), '/about/findAboutMe');
}
//
// function loadMySkillsContent() {
//     loadViewContent($('#skills'), '/skill/content');
// }
//
// function loadEducationContent() {
//     loadViewContent($('#education'), '/education/content');
// }
//
// function loadExperienceContent() {
//     loadViewContent($('#experience'), '/experience/content');
// }
//
// function loadHonorContent() {
//     loadViewContent($('#honor'), '/honor/content');
// }
//
// function loadHobbyContent() {
//     loadViewContent($('#hobby'), '/hobby/content');
// }
//
// function loadContactContent() {
//     loadViewContent($('#contact'), '/contact/content');
// }
//
// function loadDownloadResumeContent() {
//     loadViewContent($('#downloadResume'), '/download/content');
// }

//在主页面中加载显示内容
function loadViewContent(target, url) {
    //显示加载中提示
    alert("开始加载")
    startLoading(target);
    //执行内容加载
    target.load(ctx + url, function(e) {
        //关闭加载中提示
        stopLoading(target);

        //从浏览器底部弹出编辑窗口
        target.on('click', '.edit-btn', function(event) {
            event.preventDefault();
            var title = $(this).data('title');
            var url = $(this).data('url');
            openEditContentWindow(title, url);
        });
    });
}

//加载编辑内容
function loadEditContent(title, url) {
    alert("加载编辑内容")
    //编辑窗口标题
    $editPanel.find('.edit-panel-title').html(title);
    //加载内容
    $editPanel.find('.edit-panel-body').load(ctx + url, function(e) {
        //编辑表单中的取消按钮事件
        $(this).find('.cancel-btn').click(function(e) {
            closeEditContentWindow();
        });
    });
}

//打开编辑窗口
function openEditContentWindow(title, url) {
    alert("打开编辑窗口")
    $('#editPanel').animate({
        'left' : '0px',
        'bottom' : '0px'
    }, 300, function(e) {
        loadEditContent(title, url);
    });
}

//关闭编辑窗口
function closeEditContentWindow() {
    alert("关闭编辑窗口")
    $('#editPanel').animate({
        'left' : '0px',
        'bottom' : '-450px'
    }, 300, function(e) {
        //清空编辑窗口标题
        $editPanel.find('.edit-panel-title').html('');
        //清空编辑窗口内容
        $editPanel.find('.edit-panel-body').html('')
    });
}

//打开模式窗口（弹出窗口）
function openModalWindow(url, data) {
    // 防止重复打开多个模式窗口
    if ($('.modal-backdrop').is(':visible')) {
        return false;
    }
    var $modal = $('<div class="modal fade"  tabindex="-1"><div class="modal-dialog"><div class="modal-content"><div class="modal-content-loading">加载中...</div></div></div></div>');

    // backdrop:static 静态,点击遮罩层不关闭
    // backdrop:true 动态,点击遮罩层关闭
    // backdrop:false 无遮罩层
    $modal.modal({
        backdrop : 'static',
        keyboard : true
    });

    $modal.on('shown.bs.modal', function() {
        $modal.find('.modal-content').load(appendUrlTimestamp(ctx + url), data, function() {
        });
    });

    // 关闭modal时销毁modal
    $modal.on('hidden.bs.modal', function() {
        $(this).remove();
    });
    return false;
}

//关闭模式窗口
function closeModalWindow() {
    $(".modal-header button.close:last").trigger('click');
}

//为指定 url 增加时间戳（防止页面缓存）
function appendUrlTimestamp(url) {
    if (url.indexOf("?") > 0) {
        url += "&";
    } else {
        url += "?";
    }
    return url + new Date().getTime();
}

//显示加载中提示（基于 waitMe 插件实现）
function startLoading(target) {
    target.waitMe({
        effect : 'bounce',
        text : '...',
        bg : 'rgba(255,255,255,0.7)',
        color : '#000',
        sizeW : '',
        sizeH : ''
    });
}

//停止加载中提示
function stopLoading(target) {
    target.waitMe('hide');
}