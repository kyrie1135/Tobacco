//判空
function isNotBlank(text) {
    if (text != null && text.trim() != ""){
        return true;
    }else {
        return false;
    }
}

//清空某元素内所有input的内容
function clearInputs(obj) {
    $("#"+obj+" input[type='text']").each(function () {
        this.value = "";
    });
}