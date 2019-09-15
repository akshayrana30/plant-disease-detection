
# coding: utf-8

# In[1]:

import bs4 as bs
import urllib.request


source = urllib.request.urlopen('https://plantvillage.psu.edu/topics/apple/infos').read()


# In[2]:

soup = bs.BeautifulSoup(source,'lxml')
for url in soup.find_all('loc'):
    print(url.text)

# In[3]:

# title of the page
print(soup.title)

# get attributes:
print(soup.title.name)

# get values:
print(soup.title.string)

# beginning navigation:
print(soup.title.parent.name)

# getting specific values:
print(soup.p)


# In[4]:

print(soup.find_all('p'))


# In[5]:

for paragraph in soup.find_all('p'):
    print(paragraph.string)
    print(str(paragraph.text))


# In[6]:

for url in soup.find_all('a'):
    print(url.get('href'))


# In[9]:

nav = soup.nav
for url in nav.find_all('a'):
    print(url.get('href'))
          


# In[10]:

body = soup.body
for paragraph in body.find_all('p'):
    print(paragraph.text)


# In[11]:

for div in soup.find_all('div', class_='body'):
    print(div.text)


# In[12]:

#scrapping specifically with a table example
table = soup.table

#find the table rows within the table
table_rows = table.find_all('tr')

# iterate through the rows, find the td tags, and then print out each of the table data tags:
for tr in table_rows:
    td = tr.find_all('td')
    row = [i.text for i in td]
    print(row)


# In[14]:

soup = bs.BeautifulSoup(source,'xml')
for url in soup.find_all('loc'):
    print(url.text)


# In[15]:

soup = bs.BeautifulSoup(source,'lxml')

js_test = soup.find('p', class_='jstest')

print(js_test.text)



# In[ ]:



