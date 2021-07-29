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
  constructor(
    private activatedRoute: ActivatedRoute,
    private wordService: WordService
  ) { }

  ngOnInit(): void {
    this.subscription = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('word');
      const mean = this.wordService.search(word);
      // @ts-ignore
      this.word = {word, mean};
    } ) ;
  }
  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
