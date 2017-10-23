#查询Student表中的所有记录的Sname、Ssex和Class列。
select Sname,Ssex,Class from student;

#查询教师所有的单位即不重复的Depart列。
select distinct Depart from teacher;

#查询Student表的所有记录。
select * from student;

#查询Score表中成绩在60到80之间的所有记录。
select * from score where degree between 60 and 80;

#查询Score表中成绩为85，86或88的记录。
select * from score where degree in(85,86,88);

#查询Student表中“95031”班或性别为“女”的同学记录。
select * from student where class='95031' or ssex='女';

#以Class降序查询Student表的所有记录。
select * from student order by class desc;

#以Cno升序、Degree降序查询Score表的所有记录。
select * from score order by cno asc,degree desc;

#查询“95031”班的学生人数。
select count(*) from student where class='95031';

#查询Score表中的最高分的学生学号和课程号。
#先获得最高分再查找
select sno,cno from score where degree = (select max(degree) from score);

#查询‘3-105’号课程的平均分。
select avg(degree) from score where cno='3-105';

#查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
select cno,avg(degree) from score 
where
cno like '3%'
group by cno having count(sno)>=5;

#查询最低分大于70，最高分小于90的Sno列。
select sno from score group by sno having min(degree)>70 and max(degree)<90;

#查询所有学生的Sname、Cno和Degree列。
#简单方式
select sname,cno,degree from student,score where student.sno = score.sno order by sname;
#
select student.sname,score.cno,score.degree from student,score where student.sno = score.sno order by sname;
select a.sname,b.cno,b.degree from student as a,score as b where a.sno=b.sno order by sname;
#inner join
select a.sname,b.cno,b.degree from student as a inner join score as b on a.sno=b.sno order by sname;

#查询所有学生的Sno、Cname和Degree列。
select a.sno,b.cname,a.degree from score as a inner join course as b on a.cno=b.cno order by sno;

#查询所有学生的Sname、Cname和Degree列。
select a.sname,b.cname,c.degree from student as a inner join (course as b,score as c) on a.sno=c.sno and c.cno=b.cno;

#17、查询“95033”班所选课程的平均分。
select avg(degree) from student a inner join score b on a.sno=b.sno where a.class='95033';

#19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
select a.* from score a where a.cno='3-105' and a.degree>(select degree from score b where b.sno='109' and b.cno='3-105');

#20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
select * from score a where a.sno in (select b.sno from score b group by b.sno having count(*)>1);


