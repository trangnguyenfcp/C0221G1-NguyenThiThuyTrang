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
  search(wordSearch: string): string {
    if (!wordSearch) {
      return '';
    }
    const wordFind = this.words.find(word => word.english === wordSearch.toLowerCase());
    if (wordFind) {
      return wordFind.vietnamese;
    }
    return 'Not Found!';
  }
}
