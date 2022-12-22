import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from scipy.stats import t
from scipy.stats import linregress
from sklearn import linear_model
import statsmodels.api as sm



x = pd.read_excel("data_source.xlsx")["Perceptions of corruption"][:22]
counts, bins = np.histogram(x, bins='auto')
print(x)

fig, axs1 = plt.subplots(1, 4, sharey=True, tight_layout=True, clear = True)
axs1[0].hist(x, bins=int(np.log2(21) + 1))
axs1[0].set_title('Формула Стёрджеса')
print(1,int(np.log2(21) + 1))

axs1[1].hist(x, bins)
axs1[1].set_title('Aвтоматические промежутки numpy')
print(2,bins)

bins = [i*0.05 + x.min() for i in [0, 1, 2,4, 6, 7, 10]]
axs1[2].hist(x, bins)
axs1[2].set_title('Промежуток 3')
print(3,bins)
bins = [i*0.1 + x.min() for i in [0, 1, 2 , 3 , 4]]
axs1[3].hist(x, bins)
axs1[3].set_title('Промежуток 4')
print(4,bins)

#plt.show()

m = x.mean()

s = x.std()

dof = len(x) - 1
confidence = 0.95
t_crit = np.abs(t.ppf((1-confidence)/2,dof))
print(f"({m-s*t_crit/np.sqrt(len(x))}, {m+s*t_crit/np.sqrt(len(x))})") # для вычисления интервала доверия я меняю импортируемый столбец в строке 10
print(t_crit)

x = pd.read_excel("data.xlsx")

x = np.vstack((x["Score"][:21], x["Social support"][:21], x["Healthy life expectancy"][:21], x["Perceptions of corruption"][:21])).astype(float)
print(np.corrcoef(x))


x = pd.read_excel("data.xlsx")

y = x["Score"][:21]

x1 =  x["Social support"][:21]

x2 = x["Healthy life expectancy"][:21]

x3 = x["Perceptions of corruption"][:21]


fig, axs = plt.subplots(1, 3, sharey=True, tight_layout=True, clear = True)

res = linregress(x1.astype(float), y)

def myfunc1(x):
  return res.slope * x + res.intercept

mymodel = list(map(myfunc1, x1))

axs[0].scatter(x1, y)
axs[0].plot(x1, mymodel, color = 'red')
axs[0].set_title("Индекс социальной поддержки")

res = linregress(x2.astype(float), y)

def myfunc1(x):
  return res.slope * x + res.intercept

mymodel = list(map(myfunc1, x2))

axs[1].scatter(x2, y)
axs[1].plot(x2, mymodel, color = 'red')
axs[1].set_title("Здоровье")

res = linregress(x3.astype(float), y)

def myfunc1(x):
  return res.slope * x + res.intercept

mymodel = list(map(myfunc1, x3))

axs[2].scatter(x3, y)
axs[2].plot(x3, mymodel, color = 'red')
axs[2].set_title("Отношение к коррупции")


x = np.vstack(( x["Social support"][:21], x["Healthy life expectancy"][:21], x["Perceptions of corruption"][:21], np.ones(21))).astype(float).T

model = sm.OLS(y, x).fit()
predictions = model.predict(x) 
 
print_model = model.summary()
print(print_model)

plt.show()