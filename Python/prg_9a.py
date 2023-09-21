"""
Write a python program to download the all XKCD comics
"""

import os
import requests
from bs4 import BeautifulSoup

url = 'https://xkcd.com/1/'

if not os.path.exists('xkcd_comics'):
    os.makedirs('xkcd_comics')

while True:
    res = requests.get(url)
    res.raise_for_status()

    soup = BeautifulSoup(res.text, 'html.parser')

    comic_elem = soup.select('#comic img')
    if comic_elem == []:
        print("Could not find the comic")
    else:
        comic_url = 'https:' + comic_elem[0].get('src')

        print(f"Downloading {comic_url}...")
        res = requests.get(comic_url)
        res.raise_for_status()

        img_file = open(os.path.join('xkcd_comics', os.path.basename(comic_url)), 'wb')
        for chunk in res.iter_content(1):
            img_file.write(chunk)
        img_file.close()

        pre_link = soup.select('a[rel="prev"]')[0]
        if not pre_link:
            break
        url = 'https://xkcd.com' + pre_link.get('href')

print('All comics downloaded')