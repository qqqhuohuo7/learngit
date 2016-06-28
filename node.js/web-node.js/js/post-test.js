(function($){
    $("#gobutton").click(function(){
        var params = {};
        params.type = "POST";
        params.data = {
            param1:"111"
        };
        ajaxFun(params,function(){
            console.log("!!!!!!!!!!!!");
        });
    });

    var ajaxFun = function(param,callback){
        //console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||send ajax request:"+"/"+param.data);
        console.log("ajaxFun");
        $.ajax({
            url: ":8081/testPost/",
            data: param.data,
            cache:false,
            type: param.type,
            success:function(resp){
                console.log("success");
                //console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||ajax success response:"+resp);
                callback(resp);
            },
            error:function(error){
                console.log("error");
                //console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||ajax:error!");
                callback(null);
            }
        });
    };
})(window.jQuery);