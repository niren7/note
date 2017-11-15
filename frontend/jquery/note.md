jQuery取不到id有.的值
即id = “pojo.name”用jQuery取值。如果直接用$("#pojo.name").val()取不到值。
可以用$("[id='pojo.name']").val(); 
