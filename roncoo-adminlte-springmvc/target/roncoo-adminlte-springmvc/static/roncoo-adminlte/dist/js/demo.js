/**
 * AdminLTE Demo Menu
 * ------------------
 * You should not use this file in production.
 * This file is for demo purposes only.
 */
$(function () {
  'use strict'

  /**
   * Get access to plugins
   */

  $('[data-toggle="control-sidebar"]').controlSidebar()
  $('[data-toggle="push-menu"]').pushMenu()

  var $pushMenu       = $('[data-toggle="push-menu"]').data('lte.pushmenu')
  var $controlSidebar = $('[data-toggle="control-sidebar"]').data('lte.controlsidebar')
  var $layout         = $('body').data('lte.layout')

  /**
   * List of all the available skins
   *
   * @type Array
   */
  var mySkins = [
    'skin-blue',
    'skin-black',
    'skin-red',
    'skin-yellow',
    'skin-purple',
    'skin-green',
    'skin-blue-light',
    'skin-black-light',
    'skin-red-light',
    'skin-yellow-light',
    'skin-purple-light',
    'skin-green-light'
  ]

  /**
   * Get a prestored setting
   *
   * @param String name Name of of the setting
   * @returns String The value of the setting | null
   */
  function get(name) {
    if (typeof (Storage) !== 'undefined') {
      return localStorage.getItem(name)
    } else {
      window.alert('Please use a modern browser to properly view this template!')
    }
  }

  /**
   * Store a new settings in the browser
   *
   * @param String name Name of the setting
   * @param String val Value of the setting
   * @returns void
   */
  function store(name, val) {
    if (typeof (Storage) !== 'undefined') {
      localStorage.setItem(name, val)
    } else {
      window.alert('Please use a modern browser to properly view this template!')
    }
  }

  /**
   * Toggles layout classes
   *
   * @param String cls the layout class to toggle
   * @returns void
   */
  function changeLayout(cls) {
    $('body').toggleClass(cls)
    $layout.fixSidebar()
    if ($('body').hasClass('fixed') && cls == 'fixed') {
      $pushMenu.expandOnHover()
      $layout.activate()
    }
    $controlSidebar.fix()
  }

  /**
   * Replaces the old skin with the new skin
   * @param String cls the new skin class
   * @returns Boolean false to prevent link's default action
   */
  function changeSkin(cls) {
    $.each(mySkins, function (i) {
      $('body').removeClass(mySkins[i])
    })

    $('body').addClass(cls)
    store('skin', cls)
    return false
  }

  /**
   * Retrieve default settings and apply them to the template
   *
   * @returns void
   */
  function setup() {
    var tmp = get('skin')
    if (tmp && $.inArray(tmp, mySkins))
      changeSkin(tmp)

    // Add the change skin listener
    $('[data-skin]').on('click', function (e) {
      if ($(this).hasClass('knob'))
        return
      e.preventDefault()
      changeSkin($(this).data('skin'))
    })

    // Add the layout manager
    $('[data-layout]').on('click', function () {
      changeLayout($(this).data('layout'))
    })

    $('[data-controlsidebar]').on('click', function () {
      changeLayout($(this).data('controlsidebar'))
      var slide = !$controlSidebar.options.slide

      $controlSidebar.options.slide = slide
      if (!slide)
        $('.control-sidebar').removeClass('control-sidebar-open')
    })

    $('[data-sidebarskin="toggle"]').on('click', function () {
      var $sidebar = $('.control-sidebar')
      if ($sidebar.hasClass('control-sidebar-dark')) {
        $sidebar.removeClass('control-sidebar-dark')
        $sidebar.addClass('control-sidebar-light')
      } else {
        $sidebar.removeClass('control-sidebar-light')
        $sidebar.addClass('control-sidebar-dark')
      }
    })

    $('[data-enable="expandOnHover"]').on('click', function () {
      $(this).attr('disabled', true)
      $pushMenu.expandOnHover()
      if (!$('body').hasClass('sidebar-collapse'))
        $('[data-layout="sidebar-collapse"]').click()
    })

    //  Reset options
    if ($('body').hasClass('fixed')) {
      $('[data-layout="fixed"]').attr('checked', 'checked')
    }
    if ($('body').hasClass('layout-boxed')) {
      $('[data-layout="layout-boxed"]').attr('checked', 'checked')
    }
    if ($('body').hasClass('sidebar-collapse')) {
      $('[data-layout="sidebar-collapse"]').attr('checked', 'checked')
    }

  }

  // Create the new tab
  var $tabPane = $('<div />', {
    'id'   : 'control-sidebar-theme-demo-options-tab',
    'class': 'tab-pane active'
  })

  // Create the tab button
  var $tabButton = $('<li />', { 'class': 'active' })
    .html('<a href=\'#control-sidebar-theme-demo-options-tab\' data-toggle=\'tab\'>'
      + '<i class="fa fa-wrench"></i>'
      + '</a>')

  // Add the tab button to the right sidebar tabs
  $('[href="#control-sidebar-home-tab"]')
    .parent()
    .before($tabButton)

  // Create the menu
  var $demoSettings = $('<div />')

  // Layout options
  $demoSettings.append(
    '<h4 class="control-sidebar-heading">'
    + '布局选项'
    + '</h4>'
    // Fixed layout
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-layout="fixed"class="pull-right"/> '
    + '固定布局'
    + '</label>'
    + '<p>激活固定布局。你将不能使用固定和盒装布局</p>'
    + '</div>'*/
    // Boxed layout
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-layout="layout-boxed" class="pull-right"/> '
    + '盒装布局'
    + '</label>'
    + '<p>激活盒装布局</p>'
    + '</div>'*/
    // Sidebar Toggle
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-layout="sidebar-collapse"class="pull-right"/> '
    + '切换侧边栏'
    + '</label>'
    + '<p>拨动左侧边栏的状态（开或关）</p>'
    + '</div>'*/
    // Sidebar mini expand on hover toggle
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-enable="expandOnHover"class="pull-right"/> '
    + '侧边栏展开悬停'
    + '</label>'
    + '<p>让侧边栏微扩展悬停</p>'
    + '</div>'*/
    // Control Sidebar Toggle
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-controlsidebar="control-sidebar-open"class="pull-right"/> '
    + '切换右侧边栏幻灯片'
    + '</label>'
    + '<p>幻灯片内容和推送内容效果之间切换</p>'
    + '</div>'*/
    // Control Sidebar Skin Toggle
    /*+ '<div class="form-group">'
    + '<label class="control-sidebar-subheading">'
    + '<input type="checkbox"data-sidebarskin="toggle"class="pull-right"/> '
    + 'Toggle Right Sidebar Skin'
    + '</label>'
    + '<p>Toggle between dark and light skins for the right sidebar</p>'
    + '</div>'*/
  )
  var $skinsList = $('<ul />', { 'class': 'list-unstyled clearfix' })

  // Dark sidebar skins
  var $skinBlue =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-blue" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9"></span><span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Blue</p>')
  $skinsList.append($skinBlue)
  var $skinBlack =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-black" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix"><span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe"></span><span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Black</p>')
  $skinsList.append($skinBlack)
  var $skinPurple =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-purple" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span><span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Purple</p>')
  $skinsList.append($skinPurple)
  var $skinGreen =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-green" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span><span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Green</p>')
  $skinsList.append($skinGreen)
  var $skinRed =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-red" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span><span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Red</p>')
  $skinsList.append($skinRed)
  var $skinYellow =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-yellow" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span><span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin">Yellow</p>')
  $skinsList.append($skinYellow)

  // Light sidebar skins
  var $skinBlueLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-blue-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9"></span><span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Blue Light</p>')
  $skinsList.append($skinBlueLight)
  var $skinBlackLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-black-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix"><span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe"></span><span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Black Light</p>')
  $skinsList.append($skinBlackLight)
  var $skinPurpleLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-purple-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span><span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Purple Light</p>')
  $skinsList.append($skinPurpleLight)
  var $skinGreenLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-green-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span><span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Green Light</p>')
  $skinsList.append($skinGreenLight)
  var $skinRedLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-red-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span><span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Red Light</p>')
  $skinsList.append($skinRedLight)
  var $skinYellowLight =
        $('<li />', { style: 'float:left; width: 33.33333%; padding: 5px;' })
          .append('<a href="javascript:void(0)" data-skin="skin-yellow-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">'
            + '<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span><span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span></div>'
            + '<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span></div>'
            + '</a>'
            + '<p class="text-center no-margin" style="font-size: 12px">Yellow Light</p>')
  $skinsList.append($skinYellowLight)

  $demoSettings.append('<h4 class="control-sidebar-heading">Skins</h4>')
  $demoSettings.append($skinsList)

  $tabPane.append($demoSettings)
  $('#control-sidebar-home-tab').after($tabPane);

  setup();

  $('[data-toggle="tooltip"]').tooltip();

    //绑定tabs事件
    //$('#navTabs').addtabs({iframeHeight: "100%"});
    console.log('load demo.js success');
    $("#navDiv").width($("#header > .navbar").width() - $(".sidebar-toggle").outerWidth() - $(".navbar-custom-menu").outerWidth() - 50);

    /*以下是选项卡事件*/
    // 打开tab页
    $(".ajax-template").on("click","a[target='navTab']",function(){
        var that = $(this);
        var _text = that.text();
        if (that.attr('data-title')) {
            _text = that.attr('data-title');
        }
        var _href = that.attr("href");
        if (!$("#navTabs li[url='"+_href+"']").length && !parent.$("#navTabs li[url='"+_href+"']").length) {
        var id = 'zk' + Date.parse(new Date()) + generateMixed(5);
            if (parent.$("#content")) {
                parent.$("#navTabs").append('<li data-panel="' + id + '" url="'+_href+'"><a href="#" data-toggle="tab"><span>'+_text+'</span></a> <i class="close-tab fa fa-close"></i></li>');
                parent.$("#content").append('<div id="'+ id +'" class="tabs-panel" ><iframe src="' + _href + '" width="100%" height="'+($(window.parent.document).height() - 55)+'" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling-x="no" scrolling-y="auto" allowtransparency="yes" ></iframe></div>');
                _drop(parent.$("#navTabs li[url='"+_href+"']"));
                parentShowTab(parent.$("#navTabs li[url='"+_href+"']"));
            } else {
                $("#navTabs").append('<li data-panel="' + id + '" url="'+_href+'"><a href="#" data-toggle="tab"><span>'+_text+'</span></a> <i class="close-tab fa fa-close"></i></li>');
                $("#content").append('<div id="'+ id +'" class="tabs-panel"><iframe src="' + _href + '" width="100%" height="'+($(window).height() - 55)+'" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling-x="no" scrolling-y="auto" allowtransparency="yes" ></iframe></div>');
                _drop($("#navTabs li[url='"+_href+"']"));
                showTab($("#navTabs li[url='"+_href+"']"));
            }
            /*
            $("#loading").show();
            $.ajax({
                url:_href,
                dataType:"html",
                success:function(result){
                    $("#loading").hide();
                    $("#navTabs").append('<li url="'+_href+'"><a href="#" data-toggle="tab"><span>'+_text+'</span></a> <i class="close-tab fa fa-close"></i></li>');
                    _drop(that);
                    $("#content").append('<div class="tabs-panel">'+result+'</div>');
                    showTab($("#navTabs li[url='"+_href+"']"));
                },
                error:function(err){
                    $("#loading").hide();
                    console.log(err)
                }
            })*/
        }else{
            //_drop($(this));
            if (parent.$("#navTabs li[url='"+_href+"']")) {
                parentShowTab(parent.$("#navTabs li[url='"+_href+"']"));
            } else {
                showTab($("#navTabs li[url='"+_href+"']"));
            }
        }

        if (that.parents(".sidebar-menu").length) {
            that.parent("li").addClass("active").siblings().removeClass("active");
        }
        return false;
    });

    // 点击tab标签
    $("#navTabs").on("click","a",function(){
        if ($(this).attr("data-toggle") !== 'dropdown') {
            showTab($(this).parent('li'));
            //_drop($(this).parent('li'));
        }
    });
    // tab标签右键菜单
    $("#navTabs").on("contextmenu","li",function(e){
        /*e.preventDefault();
        var that = $(this);
        var w = that.width();
        var i = that.index();
        var bl = $(".main-header").offset().left;
        $("#contextMenu").show().css("left",e.clientX-bl).attr("is",i);
        return false;*/
    });
    // 关闭tab标签
    $("#navTabs").on("click",".fa-close",function(){
        var index = $(this).parents("li").index() - 1;
        //showTab($(this).parents("li").prev());
        if (parent.$("#navTabs>li")) {
            showTab(parent.$("#navTabs>li").eq(1));//关闭标签后直接返回首页
        } else {
            showTab($("#navTabs>li").eq(1));//关闭标签后直接返回首页
        }
        var panelId = $(this).parent().attr("data-panel");
        $("#" + panelId).detach();
        //$("#content .tabs-panel").eq(index).remove();
        _drop($(this).parents("li"));
        //$(this).parents("li").remove();
        $(this).parent().detach();
    });
    // 关闭tab标签
    $("#contextMenu").on("click","li",function(){
        var rel = $(this).attr("rel");
        var i = $("#contextMenu").attr("is");
        if (rel === "reload") {
            var _href = $("#navTabs>li").eq(i).attr("url");
            if (!_href) return false;
            $("#loading").show();
            $.ajax({
                url:_href,
                dataType:"html",
                success:function(result){
                    $("#loading").hide();
                    $("#content>.tabs-panel").eq(i).html(result)
                    showTab($("#navTabs li[url='"+_href+"']"));
                },
                error:function(err){
                    $("#loading").hide();
                    console.log(err)
                }
            })

        }else if (rel === "closeCurrent"){
            if (i == 0) return false;
            if ($("#navTabs>li").eq(i).hasClass("active")) {
                $("#navTabs>li").eq(0).addClass("active");
                $("#content>.tabs-panel").eq(0).show();
            }

            $("#navTabs>li").eq(i).remove();
            $("#content>.tabs-panel").eq(i).remove();

        }else if (rel === "closeOther"){

            $("#navTabs>li").eq(1).nextAll().attr("sel","temp");
            $("#navTabs>li").eq(i).addClass("active").removeAttr("sel");
            $("#navTabs>li[sel='temp']").remove();
            $("#content>.tabs-panel").eq(0).nextAll().attr("sel","temp");
            $("#content>.tabs-panel").eq(i).show().removeAttr("sel");
            $("#content>.tabs-panel[sel='temp']").remove();

        }else if (rel === "closeAll"){

            $("#navTabs>li").eq(0).addClass("active").nextAll().remove();
            $("#content>.tabs-panel").eq(0).show().nextAll().remove();

        }
        $("#contextMenu").hide();
    });
    // tab标签上一页、下一页
    $("#navTabs").nextAll("a").on("click",function(){
        var ml = parseInt($("#navTabs").css("marginLeft"));
        var itemL = $("#navTabs>li").length;
        var itemW = $("#navTabs>li").eq(0).width();
        var boxW = $("#navTabs").parent().width();
        if ($(this).hasClass("next")) {
            if (itemL*itemW+ml-boxW>0) {
                ml -= itemW*2;
            }
        }else{
            if (ml>itemW*2) {
                ml += itemW*2;
            }else{
                ml = 0;
            }
        }
        $("#navTabs").css("marginLeft",ml);
    });
    // show tab页内容
    function showTab(that){
        if (parent.$("#navTabs")) {
            parentShowTab(that);
            return;
        }
        var itemL = $("#navTabs>li").length - 1;
        var itemW = $("#navTabs>li").eq(1).width();
        var boxW = $("#navTabs").parent().width();
        that.addClass("active").siblings().removeClass("active");
        var panelId = that.attr("data-panel");
        //$("#content>.tabs-panel").eq(that.index()-1).show().siblings().hide();
        $("#content>.tabs-panel").hide();
        $("#" + panelId).show();
        /*if (itemL * itemW > boxW-itemW) {
            $("#navTabs").width(itemL*itemW+itemW).parent().addClass("more");
            var pl = that.prevAll().length;
            if (pl * itemW > boxW-itemW) {
                $("#navTabs").css("marginLeft",boxW-pl * itemW-itemW-30);
            }else{
                $("#navTabs").css("marginLeft",0);
            }
        }else{
            $("#navTabs").width("100%").parent().removeClass("more");
        }*/
    }

    // show tab页内容
    function parentShowTab(that){
        var itemL = parent.$("#navTabs>li").length - 1;
        var itemW = parent.$("#navTabs>li").eq(1).width();
        var boxW = parent.$("#navTabs").parent().width();
        that.addClass("active").siblings().removeClass("active");
        var panelId = that.attr('data-panel');
        //parent.$("#content>.tabs-panel").eq(that.index()-1).show().siblings().hide();
        parent.$("#content>.tabs-panel").hide();
        parent.$("#" + panelId).show();
        /*if (itemL * itemW > boxW-itemW) {
            parent.$("#navTabs").width(itemL*itemW+itemW).parent().addClass("more");
            var pl = that.prevAll().length;
            if (pl * itemW > boxW-itemW) {
                parent.$("#navTabs").css("marginLeft",boxW-pl * itemW-itemW-30);
            }else{
                parent.$("#navTabs").css("marginLeft",0);
            }
        }else{
            parent.$("#navTabs").width("100%").parent().removeClass("more");
        }*/
    }
    
    /**
     * 下拉菜单控制
     */
    function _drop(liObj) {
    	//创建下拉标签
    	var navobj = $("#navTabs");

        var dropdown = $('<li class="dropdown pull-right hide tabdrop"><a class="dropdown-toggle" data-toggle="dropdown" href="javascript:;">' +
                '<i class="glyphicon glyphicon-align-justify"></i>' +
                ' <b class="caret"></b></a><ul class="dropdown-menu"></ul></li>');
        //检测是否已增加

        if (parent.$("#navTabs")) {
            navobj = parent.$("#navTabs");
            if (!parent.$('.tabdrop').html()) {
                //navobj.append(dropdown);
                dropdown.prependTo(navobj);
            } else {
                dropdown = navobj.find('.tabdrop');
            }
        } else {
            if (!$('.tabdrop').html()) {
                //navobj.append(dropdown);
                dropdown.prependTo(navobj);
            } else {
                dropdown = navobj.find('.tabdrop');
            }
        }
        //检测是否有下拉样式
        if (navobj.parent().is('.tabs-below')) {
            dropdown.addClass('dropup');
        }
        var collection = 0;

        var maxwidth = navobj.width() - 80;

        var liwidth = 0;
        //检查超过一行的标签页
        var litabs = navobj/*.append(dropdown.find('li'))*/.find('>li').not('.tabdrop');
        var lisize = litabs.size();
        litabs.each(function (i, j) {
            liwidth += $(j).width();
            if (collection == 0 && i == lisize - 1 && liwidth <= (navobj.width() - 80)) {
                return true;
            }
            if (liwidth > maxwidth) {
                var liHtml = liObj.clone();
                liObj.detach();
                dropdown.find('ul').append($(liHtml));
                collection++;
                return false;
            }
        });
        //如果有超出的，显示下拉标签
        if (collection > 0) {
            dropdown.removeClass('hide');
            if (dropdown.find('.active').length == 1) {
                dropdown.addClass('active');
            } else {
                dropdown.removeClass('active');
            }
        } else {
            dropdown.addClass('hide');
        }
        return collection;
    }

    var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];

    /**
     * 生成随机字符串
     * @param n 字符串位数
     * @returns {string} 随机串
     */
    function generateMixed(n) {
        var res = "";
        for(var i = 0; i < n ; i ++) {
            var id = Math.ceil(Math.random()*35);
            res += chars[id];
        }
        return res;
    }

// 确认对话框
    $(document).on("click","a[target='ajaxTodo']",function(){
        var that = $(this);
        var href = that.attr("href");
        var title = that.attr("data-body");
        var cb = that.attr("callback");
        $("#smModal").attr("action",href).attr("callback",cb).find(".modal-body").html(title).end().modal("show");

        return false;
    });

// 打开对话框
    $(document).on("click","a[target='modal']",function(){
        var that = $(this);
        var href = that.attr("href");
        var method = that.attr("method") == "post"?"post":"get";
        var modal = that.attr("modal");
        $("#loading").show();
        $.ajax({
            url:href,
            type:method,
            dataType:"html",
            success:function(result){
                $("#loading").hide();
                $("#lgModal").show();
                $("#lgModal").find(".modal-dialog").attr("class","modal-dialog modal-"+modal);
                $("#lgModal").find(".modal-body").html(result).end().modal("show");
                try {
                    if (getResources()) {
                        getResources();
                    }
                } catch (e) {
                }
            },
            error:function(){
                $("#loading").hide();
                console.error("加载失败");
            }
        })
        return false;
    });
// 点击界面
    $(document).on("click",function(){
        $("#contextMenu").hide();
    });
    $("#smModal").on("click",".modal-footer>.btn-primary",function(){
        var action = $("#smModal").attr("action");
        var clcb = $("#smModal").attr("callback");
        if (!action) {
            $("#smModal").modal("hide");
            return false;
        }

        $.get(action,function(){
            $("#smModal").modal("hide");
            if (!!clcb) {
                // console.log(clcb);
                try {
                    eval(clcb);
                } catch (e) {
                    reloadTable(security_tab);
                }
            }else{
                alertMsg("操作成功","success");
            }
        })
    });

    $(window).resize(function() {
        $("#navDiv").width($("#header > .navbar").width() - $(".sidebar-toggle").outerWidth() - $(".navbar-custom-menu").outerWidth()-50);
    });
});
var alertsetTime;
function alertMsg(text,type){
    if (!$("#alertMsgBox").length) {
        var html =  '<div class="box box-danger box-solid" id="alertMsgBox">'
            +'  <div class="box-header with-border">'
            +'    <h3 class="box-title">提示</h3>'
            +'    <div class="box-tools pull-right">'
            +'      <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>'
            +'    </div>'
            +'  </div>'
            +'  <div class="box-body"></div>'
            +'</div>'
        $("body").append(html)
    }
    if (!text) text="提示内容不可为空";
    if (!type) type?type:"default";
    clearTimeout(alertsetTime);
    $("#alertMsgBox").attr("class","box box-"+type+" box-solid").stop().slideDown("slow").find(".box-body").html(text);
    alertsetTime = setTimeout(function(){
        $("#alertMsgBox").slideUp("slow");
    },4000)
}


// 动态提示
function modal1(){
    if($("#modalMain").length == 0){
        var html =  '<div class="modal fade" id="modalMain">'
            +'  <div class="modal-dialog modal-sm">'
            +'    <div class="modal-content">'
            +'      <div class="modal-header">'
            +'        <button type="button" class="close" data-dismiss="modal" aria-label="Close">'
            +'          <span aria-hidden="true">×</span></button>'
            +'        <h4 class="modal-title">提示</h4>'
            +'      </div>'
            +'      <div class="modal-body">'
            +'        <p>提示什么？</p>'
            +'     </div>'
            +'      <div class="modal-footer">'
            +'        <button type="button" aria-label="Close" class="btn btn-default" data-dismiss="modal">close</button>'
            +'        <button type="button" class="btn btn-primary" aria-label="primary">确认</button>'
            +'      </div>'
            +'    </div>'
            +'    <!-- /.modal-content -->'
            +'  </div>'
            +'  <!-- /.modal-dialog -->'
            +'</div>'
        $("body").append(html)
    }
}