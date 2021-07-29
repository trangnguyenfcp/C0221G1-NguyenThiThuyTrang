import { Injectable } from '@angular/core';
import {Word} from "../model/word";

@Injectable({
  providedIn: 'root'
})
export class WordService {
  words: Word[] = [{
    english: 'dog',
    vietnamese: 'cho'
  }, {
    english: 'cat',
    vietnamese: 'meo'
  }, {
    english: 'phone',
    vietnamese: 'dien thoai'
  }];
  constructor() { }
  getAll() {
    return this.words;
  }
 findByEnglish(english: string) {
    return this.words.find(word => word.english === english);
 }
}
