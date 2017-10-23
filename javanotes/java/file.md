[TOC]

# 常用构造函数

File(File parent, String child) 
          根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。 
File(String pathname) 
          通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。 
File(String parent, String child) 
          根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。

字段separator用于跨平台

```java
         //构造函数File(String pathname)
         File f1 =new File("c:\\zuidaima\\1.txt");
         //File(String parent,String child)
         File f2 =new File("c:\\zuidaima","2.txt");
         File f3 =new File("c:"+File.separator+"abc");//separator 跨平台分隔符
         //File(File parent,String child)
         File f4 =new File(f3,"3.txt");
         System.out.println(f1);//c:\zuidaima\1.txt
```

# 创建

1.boolean createNewFile() 不存在返回true 存在返回false
2.boolean mkdir() 创建目录
3.boolean mkdirs() 创建多级目录

## 创建文件夹

```java
//import java.io.*;   
File myFolderPath = new File(str1);   
try {   
    if (!myFolderPath.exists()) {   
       myFolderPath.mkdir();   
    }   
}   
catch (Exception e) {   
    System.out.println("新建目录操作出错");   
    e.printStackTrace();   
}
```
## 创建文件

```java
File myFilePath = new File(str1);   
try {   
    if (!myFilePath.exists()) {   
        myFilePath.createNewFile();   
    }     
}   
catch (Exception e) {   
    System.out.println("新建文件操作出错");   
    e.printStackTrace();   
}    
```

# 删除

1.boolean delete()
2.boolean deleteOnExit() 文件使用完成后删除

## 删除一个文件下夹所有的文件夹 

```java
File delfile=new File(str1);   
File[] files=delfile.listFiles();   
for(int i=0;i<files.length;i++){   
    if(files[i].isDirectory()){   
        files[i].delete();   
    }   
}     
```

## 清空文件夹

先删除文件夹再创建该文件夹

# 判断方法

boolean exists() 判断文件是否存在
boolean isDirectory() 
boolean isFile()

# 获取方法

String getParent()//如果没有父目录返回null
static File[] listRoots() 列出可用的文件系统根。
String[] list() 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
File[] listFiles() 返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
long length() 返回由此抽象路径名表示的文件的长度。 

## 列出磁盘下的文件和文件夹

```java
File[] files =File.listRoots();  
for(File file:files){  
    System.out.println(file);  
    if(file.length()>0){  
        String[] filenames =file.list();  
        for(String filename:filenames){  
            System.out.println(filename);  
        }  
    }  
}  
```

## 文件过滤
```java
	         File[] files =File.listRoots();
	         for(File file:files){
	             System.out.println(file);
	             if(file.length()>0){
	                 String[] filenames =file.list(new FilenameFilter(){
	                     //file 过滤目录 name 文件名
	                     public boolean accept(File file,String filename){
	                         return filename.endsWith(".mp3");
	                     }
	                 });
	                 for(String filename:filenames){
	                     System.out.println(filename);
	                 }
	             }
	         }
```


# 读写文件

## 读取

```java
File file = new File("d:"+File.separator+"1.txt");
FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);
String str = null;
while((str = br.readLine()) != null){
	System.out.println(str);	
}
fr.close();
br.close();
```

## 写入

```java
File file = new File("d:"+File.separator+"1.txt");
FileWriter fw = new FileWriter(file);
fw.write("21345");//覆盖
fw.flush();
fw.close();
```

































































