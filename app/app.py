from flask import Flask,request,jsonify
import numpy as np
import pickle

model = pickle.load(open('plantdisease.pkl','rb'))

app = Flask(__name__)


@app.route('/predictplantdisease',methods=['POST'])
def predict():
    ImageFile = request.form.get('file')

    input_query = ImageFile;

    result = model.predict(input_query)[0]

    return jsonify({'Health ':str(result)})

if __name__ == '__main__':
    app.run(debug=True)