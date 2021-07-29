import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {WordService} from "../../service/word.service";
import {Subscription} from "rxjs";
import {Word} from "../../model/word";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  subscription: Subscription;
  word: Word;
  english: string;
  constructor(
    private activatedRoute: ActivatedRoute,
    private wordService: WordService
  ) {
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap) => {
      this.english = paraMap.get('english');
      // @ts-ignore
      this.word = this.getWord(this.english);
    });
  }

  ngOnInit(): void {
  }
  getWord(english: string) {
    return this.wordService.findByEnglish(english);
  }
}
