import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from scipy.stats import t
from scipy.stats import linregress
from sklearn import linear_model
import statsmodels.api as sm





x = pd.read_excel("data.xlsx")

y = x["Score"][:21].astype(float)

x1 = np.vstack(( x["Social support"][:21], np.ones(21))).astype(float).T
x2 = np.vstack(( x["Healthy life expectancy"][:21], np.ones(21))).astype(float).T
x3 = np.vstack(( x["Perceptions of corruption"][:21], np.ones(21))).astype(float).T

x = np.vstack(( x["Social support"][:21], x["Healthy life expectancy"][:21], x["Perceptions of corruption"][:21], np.ones(21))).astype(float).T

model = sm.OLS(y, x).fit()
predictions = model.predict(x) 
 
print_model = model.summary()
print(print_model)


model1 = sm.OLS(y, x1).fit()
predictions1 = model1.predict(x1) 

print(model1.summary())

model2 = sm.OLS(y, x2).fit()
predictions1 = model2.predict(x2) 

print(model2.summary())

model3 = sm.OLS(y, x3).fit()
predictions1 = model3.predict(x3) 

print(model3.summary())