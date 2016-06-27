function postTest(params) {
    if(params == null){
        ;
    }

    var ajaxFun = function(param,callback){
        console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||send ajax request:"+"/"+param.data);
        $.ajax({
            url: "/api/v1.0/"+param.id,
            data: param.data,
            cache:false,
            type: param.type,
            success:function(resp){
                console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||ajax success response:"+resp);
                callback(resp);
            },
            error:function(error){
                console.log(new Date().Format("yyyy-MM-dd hh:mm:ss")+"||ajax:error!");
                callback(null);
            }
        });
    },
}