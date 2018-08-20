<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 积分规则编辑</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>积分规则编辑</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/pointrule/edit">
                        <input type="hidden" id="point_rule_id" name="point_rule_id" value="${pointrule.point_rule_id}">



                        <div class="form-group">
                            <label class="col-sm-3 control-label">规则名称：</label>
                            <div class="col-sm-8">
                                <input id="name" name="name" class="form-control" value="${pointrule.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">可获得积分：</label>
                            <div class="col-sm-8">
                                <input id="point" name="point" class="form-control" value="${pointrule.point}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">最低阅读时长：</label>
                            <div class="col-sm-8">
                                <input id="time" name="time" class="form-control" value="${pointrule.time}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">可获得次数：</label>
                            <div class="col-sm-8">
                                <input id="get_count" name="get_count" class="form-control" value="${pointrule.get_count}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">规则过期时间：</label>
                            <div class="col-sm-8">
                                <input id="timeout" name="timeout" class="form-control" value="${pointrule.timeout}">
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $("#frm").validate({
            pointrule: {
                name: {
                    required: true,
                    minlength: 4,
                    maxlength: 20
                },
                point: {
                    required: true,
                    minlength: 4,
                    maxlength: 40
                },
                time: {
                    required: true
                },
                get_count: {
                    required: true
                },
                timeout: {
                    required: true
                }

            },
            messages: {},
            submitHandler:function(form){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "${ctx!}/admin/pointrule/edit",
                    data: $(form).serialize(),
                    success: function(msg){
                        layer.msg(msg.message, {time: 2000},function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index);
                        });
                    }
                });
            }
        });
    });
</script>

</body>

</html>
