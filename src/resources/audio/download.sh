#!/bin/sh

wget -q -U Mozilla -O "$*.mp3" "http://translate.google.com/translate_tts?ie=UTF-8&total=1&idx=0&textlen=32&client=tw-ob&q=$*&tl=en-za"
