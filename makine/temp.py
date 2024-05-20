from sklearn.linear_model import LinearRegression
import pandas as pd 

df = pd.read_csv("Student_Marks.csv")

df.head(3)

y = df[["Marks"]]
x = df[["number_courses","time_study"]]
df.info()
l = LinearRegression()
model = l.fit(x, y)
model.predict([[4,7]])
# y = ax+b 
# y = a1x1+a2x2+b
