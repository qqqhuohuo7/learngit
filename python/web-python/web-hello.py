
from flask import Flask ,render_template,request
app = Flask(__name__)

@app.route('/')
def hello_world():
    print('hello, world')
    return 'Hello World!'

@app.route('/index/')
def index_page():
    print("Pleaseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
    print('hello, world')
    return render_template('index.html')

@app.route('/testPost')
def testPost():
    param1 = request.form['param1']
    print (param1)
    return 'gooooooooooooooooooooooooooood!'

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0',port=8000)