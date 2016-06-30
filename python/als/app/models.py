#-*- coding: UTF-8 -*- 

import MySQLdb
 
conn = MySQLdb.connect(user="python",passwd="password",host="127.0.0.1")
conn.select_db("python") #选择database
curr = conn.cursor() #创建游标
 
sqlStr = 'insert into `user` (`id`,`username`) values (%d,"%s")' (1,username) #绑定变量防sql注入
curr.execute(sqlStr)

class Record():
    def __init__(self):
        
    def addRecord(self,tokenid,record):
        #sqlStr = 'select username from user' #组sql
        #arr = curr.execute(sqlStr)
        #print arr #这里打印arr值为查询列表的长度
        #fetchmany()方法可以获得多条数据，但需要指定数据的条数
        #info = curr.fetchmany(arr)
        #info为查询到的列表内容

        sqlStr = 'select service from Server'
        arr = curr.execute(sqlStr)
        info = curr.fetchmany(arr)
        print (arr)
        
conn.commit()
curr.close()
conn.close()