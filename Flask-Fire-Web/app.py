from flask import Flask, render_template, url_for

app = Flask(__name__)

@app.route('/'), method=['GET','POST']
def index():
     return render_template("index.html")

@app.route('/product'), method=['GET', 'POST']
def product():
     return render_template("BuyingPage.html")

@app.route('/history'), method=['GET', 'POST']
def history():
     return render_template("History.html")
