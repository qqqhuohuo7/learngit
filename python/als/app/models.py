import MySQLdb
 
conn = MySQLdb.connect(user="python",passwd="password",host="127.0.0.1")
conn.select_db("python") #选择database
curr = conn.cursor() #创建游标
 
conn.commit()
curr.close()
conn.close()