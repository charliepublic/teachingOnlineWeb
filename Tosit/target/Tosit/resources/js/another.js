layui.use(['element', 'layer'], function() {
    var a = layui.jquery;
    var element = layui.element;

    a(window).on('resize', function() {
        var obj = a('#tabContainers');
        obj.height(a(this).height() - 180);
        obj.find('iframe').each(function() {
            a(this).height(obj.height());
        });
    }).resize();

    var tabs = a('#tabTitle');
    var tabContainers = a('#tabContainer');
    var sideNav = a('#sideNav');
    a('.layui-nav .layui-nav-item .layui-nav-child dd> a').each(function() {
        var obj = a(this);
        var url = obj.data('url');
        if(url !== undefined) {
            obj.on('click', function() {
                var tabTitle = '<label>' + obj.html() + '</label>';
				var count = 0;
                var tabId = tabs.find('li:last-child').attr('lay-id');
                tabs.find('li').each(function(i, e) {
					if(a(this).find('label').text() === obj.html()) {
						count++;
						tabId = a(this).attr('lay-id');
					};
                });
                if(count === 0) {
                    tabTitle += '<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>';
                    element.tabAdd('page-tab', {
                        title: tabTitle,
                        content: '<iframe src="' + url + '" style="height:100%; width: 100%"></iframe>',
                        id: tabId + 1
                    });
                    
					tabId = tabs.find('li:last-child').attr('lay-id');

                    var $content = a('.layui-tab-content');
					$content.find('iframe').each(function() {
						a(this).height($content.height());
					});

					//点击tab li切换导航，切换侧边导航的layui-this
					var $li = tabs.find('li');
					$li.find('label').on('click', function() {
						var thisPage = a(this).text(); //当前显示页的标题
						var sidePage = sideNav.find('dd.layui-this').find('a').text(); //当前侧面导航显示的标题
						if(thisPage != sidePage) {
							sideNav.find('dd').each(function() {
								if(a(this).find('label').text() == thisPage) {
									sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
									a(this).addClass('layui-this');
								}
							})
							if(thisPage == '首页') { //始终留置一个tab
								sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
							}
						}
                    })
                    $li.eq($li.length - 1).children('i.layui-tab-close').on('click', function() {
						element.tabDelete('page-tab', tabId);
						var thisPage = tabs.find('li.layui-this').find('label').text(); //当前显示页的标题
						var sidePage = sideNav.find('dd.layui-this').find('a').text(); //当前侧面导航显示的标题
						if(thisPage != sidePage) {
							sideNav.find('dd').each(function() {
								if(a(this).find('label').text() == thisPage) {
									sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
									a(this).addClass('layui-this');
								}
							})
							if(thisPage == '首页') { //始终留置一个tab
								sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
							}
						}
					});
					//获取焦点
					element.tabChange('page-tab', tabId);
                } else {
					//切换tab
					element.tabChange('page-tab', tabId);
				}
            })
        }
    });
});