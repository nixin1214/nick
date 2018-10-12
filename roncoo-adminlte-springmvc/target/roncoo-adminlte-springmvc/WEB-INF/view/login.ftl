<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <title>中垦-经分系统</title>

    <base href="${ctx}/static/roncoo-adminlte/">
    <link rel="stylesheet" href="dist/css/login2.css">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="cont">
    <div style="position: absolute; z-index: 10; width: 32rem; height: 100%; background-image: url('dist/img/newbg-left.png'); background-repeat: inherit; "></div>
    <div class="demo">
        <div class="login" style="background-image: url('dist/img/newbg-right.png'); border-radius: 5px;">
            <div class="login__check">
                <div class="label" style="font-size: 30px; font-family: '微软雅黑'; color: #4e6f5b">登录</div>
            <#--<img src="dist/img/cqlt_logo.png" alt="" style="padding-right: 1rem">
            <img src="dist/img/logo.png" alt="" style="padding-left: 1rem">-->
            </div>
            <form action="${ctx}/login" class="login__form" method="post">
                <div class="login__row">
                    <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8"></path>
                    </svg>
                    <!--账号-->
                    <input type="hidden" name="openId" value="${openId!}">
                    <input type="text" name="username" class="login__input name" placeholder="用户名"/>
                </div>
                <div class="login__row">
                    <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0"></path>
                    </svg>
                    <!--密码-->
                    <input type="password" name="password" class="login__input pass" placeholder="密码"/>
                </div>
                <button type="submit" class="login__submit">登 录</button>
            <#--<p class="login__signup">还没有账号? &nbsp;<a href="#" target="_blank">立刻注册</a></p>-->
            </form>
        </div>
    </div>
    <div style="
    position: fixed;
    z-index: 10;
    font-size: 4rem;
    color: #eee;
    bottom: 1.5rem;
    margin: 0 auto;
    left: 49rem;
    font-family: '幼圆';
    font-weight: bold;
    ">铸就国家品牌，引领良品生活</div>
</div>

<script src="dist/js/pages/login2.js"></script>
<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery.min.js"></script>

<!-- add begin user杨北平 to 2017-12-1 添加登录错误提示功能！ -->
<#if error?exists>
<script src="dist\layer\layer.js"></script>
<input type="hidden" id="tip" value="${error}">
<script>
    $(function () {
        var tip = $("#tip").val();
        layer.msg(tip);
    });
</script>
</#if>
<!-- add end -->

<script>


    $(document).ready(function () {
        var animating = false, submitPhase1 = 1100, submitPhase2 = 400, logoutPhase1 = 800, $login = $('.login'),
                $app = $('.app');

        function ripple(elem, e) {
            $('.ripple').remove();
            var elTop = elem.offset().top, elLeft = elem.offset().left, x = e.pageX - elLeft, y = e.pageY - elTop;
            var $ripple = $('<div class=\'ripple\'></div>');
            $ripple.css({
                top: y,
                left: x
            });
            elem.append($ripple);
        }
        ;
        $('.login__form,.reg__form').on('submit', function (e) {
            if (animating)
                return false;
            animating = true;
            var that = $(".login__submit");
            ripple($(that), e);
            $(that).addClass('processing');
            setTimeout(function () {
                animating = false;
                that.removeClass('processing');
                //alert("登录成功");
            }, submitPhase1);
            return true;
        });

        $(".login__signup a").on('click', function (e) {
            var that = $(".login__submit");
            that.addClass('processing success');
            setTimeout(function () {
                $app.show();
                $app.css('top');
                $app.addClass('active');
            }, submitPhase2 - 70);
            setTimeout(function () {
                $login.hide();
                $login.addClass('inactive');
                animating = false;
                that.removeClass('success processing');
            }, submitPhase2);
            return false;
        });

        $(document).on('click', '.app__logout', function (e) {
            if (animating)
                return;
            $('.ripple').remove();
            animating = true;
            var that = $(".login__submit");
            that.addClass('processing success');
            setTimeout(function () {
                $app.removeClass('active');
                $login.show();
                $login.css('top');
                $login.removeClass('inactive');
            }, submitPhase2 - 70);
            setTimeout(function () {
                $app.hide();
                animating = false;
                that.removeClass('success processing');
            }, submitPhase2);
        });

        if (window.parent != window) {
            window.parent.location.reload(true);
        }

    });

</script>
</body>
</html>