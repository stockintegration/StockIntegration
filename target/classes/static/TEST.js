$.ajax({
    type:"POST",
    url:"http://localhost:8080/basicInfo",
    data:{'ts_code':"300696"},
    async:false,
    success:function (data) {
        alert(JSON.stringify(data))
    }

})