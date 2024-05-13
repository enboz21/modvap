import pandas as pd 
from sklearn.linear_model import LinearRegression
df = pd.read_csv('araba listesi.csv')
df.head(3)
# y = ax+b 

#kullanılmayan stunları atmak için 
df = df.drop(columns = ["index"])
df.head(3)

#veri tipini görmek için 
#df.info()

#kullanılmayan katagörisel verileri(kullanılamayan string) verileri lümerik ( sayısal) veriye 
#cevirmek için kullanılır
df = pd.get_dummies(df,columns=['Type'],drop_first=True)


#String içerene veriyi(1.6L) gibi vereileri lümerik yapar
df['Engine'] = df['Engine'].str.replace("L","")
df['Engine'] = pd.to_numeric(df['Engine'])
df.head(3)
y = df[['Score']]
x = df[["Year","Engine","PriceRank"]]
lm = LinearRegression()
model =lm.fit(x, y)
model.predict(2018 , 1.6 , 312 )
