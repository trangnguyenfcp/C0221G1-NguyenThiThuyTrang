import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  @Input()
  seconds: number;
  @Output()
  finish = new EventEmitter();
  remainingTime: number;
  message = '';
  interValid = 0;
  constructor() { }
  clearTimer() {
    clearInterval(this.interValid);
  }
  start() {
    this.countdown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  ngOnInit(): void {
  }
  private countdown() {
    this.clearTimer();
    this.interValid = window.setInterval(() => {
      if (this.seconds > 0) {
        this.finish.emit(this.seconds);
        this.seconds -= 1;
      } else {
        this.finish.emit('Boom!!!!');
        this.stop();
      }
    }, 1000);}
  stop() {
    clearInterval(this.interValid);
  }
  reset() {
    this.clearTimer();
    this.start();
    this.message = `Start new countdown`;
  }
}
