# 时间格式

在数据库为时间类型，而javabean为String类型的时候，可能出现显示带有毫秒的情况

```
date_format(p.CREATE_TIME, '%Y-%m-%d  %H:%i:%s') CREATE_TIME
```
