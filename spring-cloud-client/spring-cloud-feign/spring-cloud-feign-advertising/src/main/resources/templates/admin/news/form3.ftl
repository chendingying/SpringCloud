<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 学堂信息编辑</title>
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
                    <h5>学堂信息编辑</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/news/edit">
                        <input type="hidden" id="news_id" name="news_id" value="${news.news_id}">
                        <input type="hidden" id="news_type" name="news_type" value="3">



                        <div class="form-group">
                            <label class="col-sm-3 control-label">新闻源：</label>
                            <div class="col-sm-8">
                                <select name="commercial_id" class="form-control">
                                		<#list commercial as r>
                                            <option value="${r.id}" <#if news.commercial_id == r.id>selected="selected"</#if>>
                                				${r.name}
                                            </option>
                                        </#list>
                                </select>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-sm-3 control-label">标题：</label>
                            <div class="col-sm-8">
                                <input id="news_title" name="news_title" class="form-control" value="${news.news_title}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">内容：</label>
                            <div class="col-sm-8">
                                <input id="news_content" name="news_content" class="form-control" value="${news.news_content}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">图片：</label>
                            <div class="col-sm-8">
                                <input id="news_picture" name="news_picture" class="form-control" value="${news.news_picture}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">来源：</label>
                            <div class="col-sm-8">
                                <input id="origin" name="origin" class="form-control" value="${news.origin}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">积分规则：</label>
                            <div class="col-sm-8">
                                <select name="point_rule_id" class="form-control">
                                		<#list pointRules as r>
                                            <option value="${r.point_rule_id}" <#if news.point_rule_id == r.point_rule_id>selected="selected"</#if>>
                                                ${r.name}
                                            </option>
                                        </#list>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">评论量：</label>
                            <div class="col-sm-8">
                                <input id="comment_count" name="comment_count" class="form-control" value="${news.comment_count}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">阅读量：</label>
                            <div class="col-sm-8">
                                <input id="reading_count" name="reading_count" class="form-control" value="${news.reading_count}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">点赞数：</label>
                            <div class="col-sm-8">
                                <input id="good_count" name="good_count" class="form-control" value="${news.good_count}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">点踩数：</label>
                            <div class="col-sm-8">
                                <input id="bad_count" name="bad_count" class="form-control" value="${news.bad_count}">
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
            news: {
                commercial_id: {
                    required: true,
                    minlength: 4,
                    maxlength: 20
                },
                news_title: {
                    required: true,
                    minlength: 4,
                    maxlength: 40
                },
                news_content: {
                    required: true
                },
                origin: {
                    required: true
                },
                point_rule_id: {
                    required: true
                },
                comment_count: {
                    required: true
                },
                reading_count: {
                    required: true
                },
                good_count: {
                    required: true
                },
                bad_count: {
                    required: true
                }
            },
            messages: {},
            submitHandler:function(form){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "${ctx!}/admin/news/edit3",
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
