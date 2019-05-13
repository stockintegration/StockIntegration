$.ajax({
    type:"GET",
    url:"http://localhost:8080/ts_code",
    data:{"ts_code":"300696.SZ"},
    async:false,
    success:function (data) {
        alert(JSON.stringify(data))
    }

})